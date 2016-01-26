package br.edu.ufcg.splab.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.Transition;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.TransitionType;
import br.edu.ufcg.splab.graph_hierarchy.core.vertex.Vertex;

public class EvosuiteParser {
	private int count;
	
	public EvosuiteParser() {
		this.count = 0;
	}
	
	public TestSuite parseFile(String filePath) {
		String completeCode = buildCompleteCodeString(new File(filePath));
		String[] methodsCode = breakCodeIntoMethods(completeCode);
		List<String[]> stepsCode = breakCodeIntoSteps(methodsCode);
		TestSuite ts = new TestSuite();
		
		for (String[] stepsMethod : stepsCode) {
			for (int i = 0; i < stepsMethod.length; i++) {
				stepsMethod[i] = stepsMethod[i].trim();
			}
			
			ts.add(buildTestCase(stepsMethod));
		}
		
		System.out.println(ts);
		
		return ts;
	}
	
	private TestCase buildTestCase(String steps[]) {
		TestCase buildingTestCase = new TestCase();
		this.count = 0;
		
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
	
	private String buildCompleteCodeString(File file) {
		BufferedReader characterReader = null;
		StringBuffer completeCode = new StringBuffer();
		String currentLine = new String();
		
		try {
			characterReader = new BufferedReader(new FileReader(file));
			
			while (currentLine != null) {
				currentLine = characterReader.readLine();
				completeCode.append(currentLine);
			}
		} catch(IOException ioException) {
			ioException.printStackTrace();
		} finally {
			try {
				characterReader.close();
			} catch(IOException innerIOException) {
				innerIOException.printStackTrace();
			}
		}
		
		return completeCode.toString();
	}
	
	private String[] breakCodeIntoMethods(String completeCode) {
		String[] codeInMethods = completeCode.split("@Test");
		String[] modCodeInMethods = Arrays.copyOfRange(codeInMethods, 1, codeInMethods.length);
		return modCodeInMethods;
	}
	
	private List<String[]> breakCodeIntoSteps(String[] methodsCode) {
		List<String[]> steps = new ArrayList<String[]>();
		
		for (String method : methodsCode) {
			String[] stepLines = method.split(";");
			stepLines[0] = stepLines[0].split("\\{")[1];
			stepLines = Arrays.copyOfRange(stepLines, 0, stepLines.length - 1);
			steps.add(stepLines);
		}
		
		return steps;
	}
}
