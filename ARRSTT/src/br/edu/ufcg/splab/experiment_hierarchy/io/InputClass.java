package br.edu.ufcg.splab.experiment_hierarchy.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ParseException;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.XMLParser;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.graph.Graph;
import br.edu.ufcg.splab.graph_hierarchy.parser.ReadTGF;

public class InputClass {
	
	public List<TestSuite> loadSuites(File[] files) throws Exception{
		List<TestSuite> suites = new ArrayList<>();
		for(File file : files){
			String type = getFileType(file);
			if(type.equals("tgf")){
				suites.add(getTGFSuite(file));
			} else if(type.equals("xml")){
				suites.addAll(getXMLSuite(file));
			} else {
				throw new Exception("File type not supported");
			}
		}
		return suites;
	}
	
	private List<TestSuite> getXMLSuite(File file) throws ParseException, IOException {
		XMLParser parser = new XMLParser();
		return parser.read(file.getPath()); // tenho que ajeitar os throws, e eh o get path ou absolute?
	}

	private TestSuite getTGFSuite(File file) throws Exception {
		ReadTGF reader = new ReadTGF();
		Graph g = reader.getGraph(file.getAbsolutePath());//checar se eh o path mesmo
		InterfaceSearch search = new DepthFirstSearch();
		return search.getTestSuite(g.getRoot(), 0);
	}
	
	//fazer a gambiarra que wesley disse
	private String getFileType(File file){
		String name = file.getName();
		String[] divisions = name.split(".");
		String type = divisions[divisions.length-1];
		return type;
	}

}
