package br.edu.ufcg.splab.parsers;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

public class ParsingFacade {
	private Parser parser;
	private TestSuite lastGeneratedTestSuite;
	
	public ParsingFacade(Parser parser) {
		this.parser = parser;
	}
	
	public ParsingFacade() {
		this.parser = null;
	}
	
	public void changeParser(String parserStr) {
		if (parserStr.equals("evosuite")) {
			this.parser = new EvosuiteParser();
		}
	}
	
	public String parse(String filePath) {
		this.lastGeneratedTestSuite = parser.parseFile(filePath);
		System.out.println(this.lastGeneratedTestSuite);
		return formatTestSuiteString(lastGeneratedTestSuite);
	}
	
	private String formatTestSuiteString(TestSuite testSuite) {
		StringBuffer output = new StringBuffer();
		int count = 1;
		int tcCount = 1;
		
		for (TestCase tc : testSuite) {
			count = 1;
			output.append("----- TestCase " + tcCount + " -----" + "\n");
			
			for (InterfaceEdge edge : tc) {
				output.append(count + "." + "  "+ edge + "\n");
				count++;
			}
			
			tcCount++;
			output.append("\n");
		}
		
		return output.toString();
	}
	
}
