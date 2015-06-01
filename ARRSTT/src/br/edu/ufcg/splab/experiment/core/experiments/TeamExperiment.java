package br.edu.ufcg.splab.experiment.core.experiments;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.experiment.core.combinators.Combinable;
import br.edu.ufcg.splab.experiment.core.factors.InterfaceFactor;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

public class TeamExperiment extends ReplicableExperiment {
	public static final String LINE_END = System.getProperty("line.separator");
	
	private ReadTGF tgfReader;
	private File[] graphFiles;
	private List<String> outputs; // added by Iaron. This should contain all outputs.
	
	public TeamExperiment(List<InterfaceFactor<?>> factors,	Combinable combinator, int repNumber) throws Exception {
		super(factors, combinator, repNumber);
		
		// Added to ensure our experiment will work. - Iaron
		if(factors.size() != 3) throw new Exception("This experiment must have exactly 3 factors");
		
		this.tgfReader = new ReadTGF();
		this.graphFiles = new File("input_examples/").listFiles();
		this.outputs = new ArrayList<>();
	}

	@Override
	public void runExperiment() throws Exception {
		List<InterfaceGraph> runGraphs = graphsToRun(0);
		
		for (int i = 1; i <= this.getRepNumber(); i++) {
			List<List<?>> combinations = getCombinator().combine();
			
			//fill the outputs List
			for (List<?> combination : combinations) {
				InterfaceSearch search = (InterfaceSearch) combination.get(0);
				Integer loopCoverage = (Integer) combination.get(1);
				Integer branchType = (Integer) combination.get(2);
				
				outputs.add(search.getName() + loopCoverage + ":"); // branchType to be added in the future
			}
			
			
			for(int j = 0; j < combinations.size(); j++){
				InterfaceSearch search = (InterfaceSearch) combinations.get(j).get(0);
				Integer loopCoverage = (Integer) combinations.get(j).get(1);
				Integer branchType = (Integer) combinations.get(j).get(2);

				for (InterfaceGraph graph : runGraphs) {
					Long initTime = System.nanoTime();
					search.getTestSuite(graph.getRoot(), loopCoverage);
					Long endTime = System.nanoTime();
					
					//This block has to be heavily checked
					Long timeDif = (endTime - initTime);
					String output = timeDif.toString();
					String currentOutput = outputs.get(j);
					currentOutput += output;
					outputs.set(j, currentOutput);
					
				}
			}
		}
		
		putToFile(outputs);
	}
	
	
	//This Branch type will be used once we have de measurement, right? - Iaron
	private List<InterfaceGraph> graphsToRun(Integer branchType) throws Exception {
		List<InterfaceGraph> graphs = new ArrayList<InterfaceGraph>();
		
 		for (File file : graphFiles) { 
			graphs.add(tgfReader.getGraph(file.getAbsolutePath()));
		}
 		
 		return graphs;
	}
	
	private void putToFile(List<String> outputs) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File( "Experiment.txt")));
		
		for(String output : outputs){
			writer.write(output + LINE_END);
		}
		
		writer.close();
	}
}
