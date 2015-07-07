package br.edu.ufcg.splab.experiment.core.experiments;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.experiment.IaronBranch.GraphSeparatorByBranch;
import br.edu.ufcg.splab.experiment.core.treatments.TreatmentSearch;
import br.edu.ufcg.splab.searchs.BreadthFirstSearch;
import br.edu.ufcg.splab.searchs.DepthFirstSearch;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

/**
 * This is the class that should execute the specific experiment made
 * on the ARRSTT project. 
 */
public class TeamExperiment {
	public static final String LINE_END = System.getProperty("line.separator");
	
	private StringBuilder outputsTime; 
	private StringBuilder outputsTestSuiteSize;
	private List<InterfaceGraph> graphs; 
	private GraphSeparatorByBranch separator;
	private List<Integer> loopCoverages;
	
	
	public TeamExperiment(List<Integer> loopCoverages) throws Exception {
		outputsTime = new StringBuilder();
		this.loopCoverages = loopCoverages;
		outputsTestSuiteSize = new StringBuilder();
		separator = new GraphSeparatorByBranch();
		graphs = new ArrayList<InterfaceGraph>();
		getGraphsToRun(separator);
		
	}



	public void runExperiment() throws Exception {
		List<TreatmentSearch> combinations = combine();
		int count = 0;
		for(TreatmentSearch combination : combinations){	
				Long initTime = System.nanoTime();
				combination.execute();
				Long endTime = System.nanoTime();
				
				Long timeDif = (endTime - initTime);
				outputsTime.append(timeDif + "	");
				outputsTestSuiteSize.append(combination.getTestSuite().size() + "	");
				
				//Isso é melhor que o for com %?
				count += 1;
				if(count == 6){
					outputsTime.append(LINE_END);
					outputsTestSuiteSize.append(LINE_END);
					count = 0;
				}
				
		}
		
		putToFile(outputsTime, "Times");
		putToFile(outputsTestSuiteSize, "Test Suite Size");
		
	}
	
	private List<TreatmentSearch> combine(){
		List<TreatmentSearch> combinations = new ArrayList<TreatmentSearch>();
		List<InterfaceSearch> searches = new ArrayList<InterfaceSearch>();
		searches.add(new DepthFirstSearch());
		searches.add(new BreadthFirstSearch());
		
		for(InterfaceGraph graph : graphs){
			for(InterfaceSearch search: searches){
				for(Integer loopCoverage : loopCoverages){
					// It is null because I will be setting the graph.
					combinations.add(new TreatmentSearch(search, graph.getRoot(), loopCoverage, ""));
				}
			}
		}	
		return combinations;
	}
	
	
	
	//Writes the results, saved in a String, in a txt.
	private void putToFile(StringBuilder output, String fileName) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File( fileName + ".txt")));
		writer.write(output.toString());
		writer.close();
	}
	
	
	private void getGraphsToRun(GraphSeparatorByBranch separator) throws Exception {
		List<InterfaceGraph> lows, highs;
		separator.separate();
		lows = separator.getLows();
		highs = separator.getHighs();
		merge(lows, highs);
	}
	
	private void merge(List<InterfaceGraph> lows, List<InterfaceGraph> highs){
		int limit = Math.min(lows.size(), highs.size());
		for(int i = 0; i < limit; i++){
			graphs.add(lows.get(i));
		}
		for(int i = 0; i < limit; i++){
			graphs.add(highs.get(i));
		}
	}
}
