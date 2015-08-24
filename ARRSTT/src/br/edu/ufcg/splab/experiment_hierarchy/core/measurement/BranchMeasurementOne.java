package br.edu.ufcg.splab.experiment_hierarchy.core.measurement;

import br.edu.ufcg.splab.graph.core.InterfaceGraph;

/**
 * Class responsible to calculate a certain measurement of a graph.
 * This measurement is represented by the amount of states a graph
 * has divided by the amount of states. 
 *
 */
public class BranchMeasurementOne implements InterfaceMeasurement {
	/**
	 * The graph that will have it's measurement calculated
	 */
	private InterfaceGraph graph;
	
	/**
	 * Constructor of the class
	 * @param graph
	 * 		The graph that will have it's measurement calculated
	 */
	public BranchMeasurementOne(InterfaceGraph graph) {
		this.graph = graph;
	}
	
	/**
	 * Calculates and returns the measurement.
	 * @return the measurement.
	 */
	public double measure() {
		return (double)graph.getEdges().size() / (double)graph.getStates().size();
	}
	
	/**
	 * @return the graph that will have it's measurement calculated.
	 */
	public InterfaceGraph getGraph() {
		return graph;
	}
	
	/**
	 * @param graph the new graph to have it's measurement calculated.
	 */
	public void setGraph(InterfaceGraph graph) {
		this.graph = graph;
	}	
}
