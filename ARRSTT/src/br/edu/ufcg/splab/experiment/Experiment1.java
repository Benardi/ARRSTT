package br.edu.ufcg.splab.experiment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

public class Experiment1 {
private InterfaceSearch search;
	
	
	public Experiment1(InterfaceSearch search){
		this.search = search;
	}
	
	public void doExperiment(int loopCoverage, String fileName) throws Exception {
		File[] folder = new File("input_examples/").listFiles();
		ReadTGF tgfReader = new ReadTGF();
		String output = "";
		
		for (File file : folder) {
			InterfaceGraph graph = tgfReader.getGraph(file.getAbsolutePath());
			long time = System.currentTimeMillis();
			search.getTestSuite(graph.getRoot(), loopCoverage);
			output += System.currentTimeMillis() - time + "\n";
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File( fileName + ".txt")));
		writer.write(output);
		writer.close();
	}
	
	public void setSearch(InterfaceSearch search){
		this.search = search;
	}

}
