package br.edu.ufcg.splab.experiment_hierarchy.searches;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.parser.ReadTGF;

public class SearchMain {
	
	public static void main(String[] args) {
		main1();
	}
	
	public static void main1() {
		try {
			ReadTGF tgfReader = new ReadTGF();
			InterfaceGraph graph = tgfReader.getGraph("input_examples/loopytoy3.tgf");
			InterfaceSearch searchObject = new DepthFirstSearch();
			TestSuite testSuite = searchObject.getTestSuite(graph.getRoot(), 3);
			System.out.print(testSuite);
			System.out.println("Number of test cases generated: " + testSuite.size());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main2() {
		try {
			ReadTGF tgfReader = new ReadTGF();
			InterfaceGraph graph = tgfReader.getGraph("input_examples/loopytoy3.tgf");
			InterfaceSearch searchObject = new DepthFirstSearch();
			TestSuite testSuite1 = searchObject.getTestSuite(graph.getRoot(), 3);
			searchObject = new BreadthFirstSearch();
			TestSuite testSuite2 = searchObject.getTestSuite(graph.getRoot(), 3);
			
			for (TestCase tc1 : testSuite1) {
				if (!testSuite2.contains(tc1)) {
					System.out.println(tc1);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
