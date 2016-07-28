package br.edu.ufcg.splab.experimentsExamples.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experimentsExamples.util.measurement.BranchMeasurementOne;
import br.edu.ufcg.splab.experimentsExamples.util.measurement.InterfaceMeasurement;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.parser.ReadTGF;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-05-27
 * 
 */
/**
 * <b>Objective:</b> This class is responsible for loading the graphs in the input_exemples
 * and classify them into "low branched graphs" and "high branched graphs". After the
 * classification is done, they are moved into one of the two lists that represents these
 * categories. Both lists must have the same size, that's why most part of the times not
 * all graphs are loaded.
 * <br>
 * <b>Description of use</b> This is generally used to represent a quantitative treatment 
 * in the ARRSTT's Generation experiment, being part of it's ExecutableTreatment.
 *
 */
public class BranchSeparator {
	private List<InterfaceGraph> highGraphs;
	private List<InterfaceGraph> allGraphs;
	private List<InterfaceGraph> lowGraphs;
	
	/**
	 * Constructor of the class. Initializes the list containing all graphs, the one
	 * containing the low branch ones and another containing the high branch.
	 */
	public BranchSeparator(){
		highGraphs = new ArrayList<>();
		allGraphs = new ArrayList<>();
		lowGraphs = new ArrayList<>();
	}
	/**
	 * <b>Objective:</b> This is the method that divides the graphs and puts them into
	 * lists.
	 * <br>
	 * <b>Exemple of use:</b> This is used in the ARRSTT's experiment to divide the graphs
	 * into categories.
	 * @throws Exception If the directory's name is invalid.
	 */
	public void separate() throws Exception {
		loadGraphs();
		separateByBranch();
	}
	
	/**
	 * <b>Objective:</b> This method is used, after the division is done, to get
	 * the separated list of graphs. This one gets the "low branch" one.
	 * @return The list of the graphs that fell into the "low branch" category.
	 */
	public List<InterfaceGraph> getLows(){
		return lowGraphs;
	}
	/**
	 * <b>Objective:</b> This method is used, after the division is done, to get
	 * the separated list of graphs. This one gets the "high branch" one.
	 * @return The list of the graphs that fell into the "high branch" category.
	 */
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
			
			//REFACTOR: Magic number
			if(measureObject.measure() > 1.3)
				highGraphs.add(graph);
			else
				lowGraphs.add(graph);
		}
	}
	
	/**
	 * <b>Objective:</b> This method should be called before the separate method so the graphs
	 * to be divided are loaded.
	 * @return The list of all graphs.
	 * @throws Exception if the directory's name is invalid.
	 */
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
