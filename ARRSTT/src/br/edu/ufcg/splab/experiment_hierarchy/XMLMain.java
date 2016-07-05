package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.IOException;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ParseException;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.SimilarityTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.TestSuiteMerger;
import br.edu.ufcg.splab.experiment_hierarchy.util.XMLParser;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class XMLMain {

	public static void main(String[] args) throws ParseException, IOException {
		XMLParser parser = new XMLParser();
		String path = "extras/xmls/";
//		List<TestSuite> list1 = parser.read(path + "firstTry.testproject-deep.xml");
//		List<TestSuite> list2 = parser.read(path + "TestSuite1.testsuite-deep.xml");
//		List<TestSuite> list3 = parser.read(path + "Toy4.testsuite-deep.xml");
//		List<TestSuite> list4 = parser.read(path + "old.xml");
//		List<TestSuite> list5 = parser.read(path + "TS1.testsuite-deep.xml");
		List<TestSuite> list5 = parser.read(path + "experimento_neto/suite_experiment.xml");
		
		
		System.out.println("=====================================================================");
		System.out.println(list5.size());
		printTestSuite(list5);
		
		SimilarityTechnique similarity = new SimilarityTechnique();
		TestSuiteMerger merger = new TestSuiteMerger();
		TestSuite ts = merger.merge(list5);
		System.out.println("===========");
		System.out.println(ts.size());
		TestSuite subset = similarity.select(ts, 0.5);
		System.out.println(subset.size());
		
	}

	private static void printTestSuite(List<TestSuite> testSuites) {
		for(TestSuite ts : testSuites){
			//System.out.println("<TS ID: " +ts.getID() + ">\n" + ts.toString());
			System.out.println(ts.size());
		}
	}

}
