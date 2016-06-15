package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.IOException;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ParseException;
import br.edu.ufcg.splab.experiment_hierarchy.util.XMLParser;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class XMLMain {

	public static void main(String[] args) throws ParseException, IOException {
		XMLParser parser = new XMLParser();
		String path = "xmls\\";
		List<TestSuite> list1 = parser.read(path + "firstTry.testproject-deep.xml");
		List<TestSuite> list2 = parser.read(path + "TestSuite1.testsuite-deep.xml");
		List<TestSuite> list3 = parser.read(path + "Toy4.testsuite-deep.xml");
		List<TestSuite> list4 = parser.read(path + "old.xml");
		List<TestSuite> list5 = parser.read(path + "TS1.testsuite-deep.xml");
		
		for(TestSuite ts : list1){
			System.out.println("<TS ID: " +ts.getID() + ">\n" + ts.toString());
		}
		System.out.println("=====================================================================");
		for(TestSuite ts : list2){
			System.out.println("<TS ID: " +ts.getID() + ">\n" + ts.toString());
		}
		System.out.println("=====================================================================");
		for(TestSuite ts : list3){
			System.out.println("<TS ID: " +ts.getID() + ">\n" + ts.toString());
		}
		System.out.println("=====================================================================");
		for(TestSuite ts : list4){
			System.out.println("<TS ID: " +ts.getID() + ">\n" + ts.toString());
		}
		System.out.println("=====================================================================");
		for(TestSuite ts : list5){
			System.out.println("<TS ID: " +ts.getID() + ">\n" + ts.toString());
		}
	}

}
