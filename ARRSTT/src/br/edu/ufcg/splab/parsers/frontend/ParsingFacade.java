package br.edu.ufcg.splab.parsers.frontend;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.parsers.EvosuiteParser;

public class ParsingFacade {
	private ParseController controller;
	
	public ParsingFacade() {
		this.controller = new ParseController();
	}
	
	public void changeParser(String parserStr) {
		if (parserStr.equalsIgnoreCase("evosuite")) {
			controller.setParser(new EvosuiteParser());
		}
	}
	
	public String parse(String filePath) {
		return formatTestSuiteString(controller.parse(filePath));
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
