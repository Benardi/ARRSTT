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
	
	//private File[] graphFiles;
	private List<String> outputsTime; 
	private List<String> outputsTestSuiteSize;
	private List<InterfaceGraph> graphs; 
	private GraphSeparatorByBranch separator;
	
	
	public TeamExperiment() throws Exception {
		outputsTime = new ArrayList<String>();
		outputsTestSuiteSize = new ArrayList<String>();
		separator = new GraphSeparatorByBranch();
		graphs = new ArrayList<InterfaceGraph>();
		getGraphsToRun(separator);
		
	}



	public void runExperiment() throws Exception {
		List<TreatmentSearch> combinations = combine();
		StringBuilder currentOutputTime;
		StringBuilder currentOutputSize;
		
		
		for(TreatmentSearch combination : combinations){
			currentOutputTime = new StringBuilder();
			currentOutputSize = new StringBuilder();
			
			for(InterfaceGraph graph : graphs){
				combination.setGraph(graph);
				
				Long initTime = System.nanoTime();
				combination.execute();
				Long endTime = System.nanoTime();
				
				Long timeDif = (endTime - initTime);
				currentOutputTime.append(timeDif + " ");
				currentOutputSize.append(combination.getTestSuite().size());
			}
			outputsTime.add(currentOutputTime.toString());
			outputsTestSuiteSize.add(currentOutputSize.toString());
		}
		
		putToFile(outputsTime, "Times");
		putToFile(outputsTestSuiteSize, "Test Suite Size");
		
	}
	
	private List<TreatmentSearch> combine(){
		List<TreatmentSearch> combinations = new ArrayList<TreatmentSearch>();
		List<InterfaceSearch> searches = new ArrayList<InterfaceSearch>();
		searches.add(new DepthFirstSearch());
		searches.add(new BreadthFirstSearch());
		for(InterfaceSearch search: searches){
			for(int loopCoverage = 1; loopCoverage <= 7; loopCoverage += 3){
				// It is null because I will be setting the graph.
				combinations.add(new TreatmentSearch(search, null, loopCoverage, ""));
			}
		}
		return combinations;
	}
	
	
	
	//Writes the results, saved in a String, in a txt.
	private void putToFile(List<String> outputs, String fileName) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File( fileName + ".txt")));
		
		for(String output : outputs){
			writer.write(output + LINE_END);
		}
		
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
		int limit = minSize(lows, highs);
		for(int i = 0; i < limit; i++){
			graphs.add(lows.get(i));
		}
		for(int i = 0; i < limit; i++){
			graphs.add(highs.get(i));
		}
	}
	
	private int minSize(List<InterfaceGraph> l1, List<InterfaceGraph> l2){
		if(l1.size() <= l2.size()){
			return l1.size();
		} else {
			return l2.size();
		}
	}
}
