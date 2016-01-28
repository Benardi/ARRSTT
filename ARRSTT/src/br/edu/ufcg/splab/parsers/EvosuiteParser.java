package br.edu.ufcg.splab.parsers;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.Transition;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.TransitionType;
import br.edu.ufcg.splab.graph_hierarchy.core.vertex.Vertex;

public class EvosuiteParser implements Parser {
	private int count;
	
	public EvosuiteParser() {
		this.count = 0;
	}
	
	public TestSuite parseFile(String filePath) {
		ParseFile file = new ParseFile(filePath);
		
		file.streamOn();
		String completeCode = makeCompleteCode(file);
		List<String> methods = splitToMethodsOfCode(completeCode);
		cleanMethods(methods);
		List<List<String>> lines = splitToLinesOfCode(methods);
		cleanLines(lines);
		file.streamOff();
		
		return buildTestSuite(lines);
	}
	
	private String makeCompleteCode(ParseFile file) {
		StringBuffer code = new StringBuffer();
		String currentLine = new String();
		
		while (currentLine != null) {
			code.append(currentLine);
			currentLine = file.readLine();
		}
		
		return code.toString();
	}
	
	private List<String> splitToMethodsOfCode(String completeCode) {
		String[] methodsOfCode = completeCode.split("@Test");
		List<String> methodsOfCodeList = new ArrayList<String>();
		
		for (String method : methodsOfCode) {
			methodsOfCodeList.add(method);
		}
		
		return methodsOfCodeList;
	}
	
	private void cleanMethods(List<String> methods) {
		methods.remove(0); // Remove class header
	}

	private List<List<String>> splitToLinesOfCode(List<String> methodsOfCode) {
		List<List<String>> linesOfCode = new ArrayList<List<String>>();
		
		for (String method : methodsOfCode) {
			List<String> linesInMethod = new ArrayList<String>(); 
			
			for (String line : method.split(";")) {
				linesInMethod.add(line);
			}
			
			linesOfCode.add(linesInMethod);
		}
		
		return linesOfCode;
	}

	private void cleanLines(List<List<String>> linesOfCode) {
		// Remove methods signature and closing curly braces
		for (List<String> linesInMethod : linesOfCode) {
			linesInMethod.set(0, linesInMethod.get(0).split("\\{")[1]);
			linesInMethod.remove(linesInMethod.size() - 1);
		}
		
		// Trim lines
		for (List<String> linesInMethod : linesOfCode) {
			for (int i = 0; i < linesInMethod.size(); i++) {
				linesInMethod.set(i, linesInMethod.get(i).trim());
			}
		}
	}

	private TestCase buildTestCase(List<String> steps) {
		TestCase buildingTestCase = new TestCase();
		
		for (String step : steps) {
			InterfaceVertex startVertex = new Vertex(count + "");
			count++;
			InterfaceVertex terminalVertex = new Vertex(count + "");
			count++;
			InterfaceEdge edge = new Transition(startVertex, step, terminalVertex, TransitionType.STEPS);
			buildingTestCase.add(edge);
		}
		
		return buildingTestCase;
	}
	
	private TestSuite buildTestSuite(List<List<String>> lines) {
		TestSuite testSuite = new TestSuite();
		this.count = 0;
		
		for (List<String> linesInMethod : lines) {
			testSuite.add(buildTestCase(linesInMethod));
		}
		
		return testSuite;
	}
	
}
