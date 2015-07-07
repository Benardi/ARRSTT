package br.edu.ufcg.splab.experiment.IaronBranch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.parser.ReadTGF;

// This class and package should be deleted later after we decide where exactly this code should go.
// Was not tested yet
public class GraphSeparatorByBranch {
	private List<InterfaceGraph> highGraphs;
	private List<InterfaceGraph> allGraphs;
	private List<InterfaceGraph> lowGraphs;
	
	
	public GraphSeparatorByBranch(){
		highGraphs = new ArrayList<>();
		allGraphs = new ArrayList<>();
		lowGraphs = new ArrayList<>();
	}
	
	public void separate() throws Exception{
		loadGraphs();
		separateByBranch1();
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
	private void separateByBranch1() {
		Measurement measureObject = new BranchMeasurementOne(null); // Isso tem que mudar?
		
		for(InterfaceGraph graph : allGraphs) {
			measureObject.setGraph(graph);
			
			if(measureObject.measure() > 1.3)
				highGraphs.add(graph);
			else
				lowGraphs.add(graph);
		}
	}

}
