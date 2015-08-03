package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.measurement.BranchMeasurementOne;
import br.edu.ufcg.splab.experiment_hierarchy.core.measurement.InterfaceMeasurement;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.parser.ReadTGF;

// This class and package should be deleted later after we decide where exactly this code should go.
// Was not tested yet
public class BranchSeparator {
	private List<InterfaceGraph> highGraphs;
	private List<InterfaceGraph> allGraphs;
	private List<InterfaceGraph> lowGraphs;
	
	
	public BranchSeparator(){
		highGraphs = new ArrayList<>();
		allGraphs = new ArrayList<>();
		lowGraphs = new ArrayList<>();
	}
	
	public void separate() throws Exception {
		loadGraphs();
		separateByBranch();
	}
	
	public List<InterfaceGraph> getLows(){
		return lowGraphs;
	}
	
	public List<InterfaceGraph> getHighs(){
		return highGraphs;
	}
	
	// This method gets the folder with the files, read them and put the graphs
	// on the allGraphs attribute.
	private void loadGraphs() throws Exception{
		File[] folder = new File("input_examples/").listFiles();
		ReadTGF tgfReader = new ReadTGF();
		for (File file : folder) {
			InterfaceGraph graph = tgfReader.getGraph(file.getAbsolutePath());
			allGraphs.add(graph);
		}
	}
	
	// This method separates graphs by checking if edges / vertexes is higher or lower than 2.
	private void separateByBranch() {
		for(InterfaceGraph graph : allGraphs) {
			InterfaceMeasurement measureObject = new BranchMeasurementOne(graph);
			
			if(measureObject.measure() > 1.3)
				highGraphs.add(graph);
			else
				lowGraphs.add(graph);
		}
	}
	
	public List<InterfaceGraph> getGraphsToRun() throws Exception {
		separate();
		return merge();
		
	}

	private List<InterfaceGraph> merge() {
		List<InterfaceGraph> mergedList = new ArrayList<InterfaceGraph>();
		int limit = Math.min(getLows().size(), getHighs().size());
	
		for(int i = 0; i < limit; i++) 
			mergedList.add(getLows().get(i));
		
		for(int i = 0; i < limit; i++) 
			mergedList.add(getHighs().get(i));
		
		return mergedList;
	}
}
