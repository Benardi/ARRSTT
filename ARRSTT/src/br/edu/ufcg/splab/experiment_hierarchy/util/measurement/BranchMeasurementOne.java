package br.edu.ufcg.splab.experiment_hierarchy.util.measurement;

import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Refactoring													Iaron Araujo		2015-07-07
 * 
 */
/**
 * <b>Objective:</b> Class responsible to calculate a certain measurement of a
 * graph. <br>
 * <br>
 * <b>Description of use:</b> This measurement is represented by the amount of
 * states a graph has divided by the amount of states.
 *
 */
public class BranchMeasurementOne implements InterfaceMeasurement {
	/**
	 * The graph that will have it's measurement calculated
	 */
	private InterfaceGraph graph;

	/**
	 * <b>Objective:</b> Enable the construction of one object from this class. <br>
	 * <br>
	 * <b>Description of use:</b> This constructor is used to create and
	 * initialize a new object from this class.
	 *
	 * @param graph
	 *            The graph that will have it's measurement calculated
	 */
	public BranchMeasurementOne(InterfaceGraph graph) {
		this.graph = graph;
	}

	public double measure() {
		return (double) graph.getEdges().size()
				/ (double) graph.getStates().size();
	}

	/**
	 * <b>Objective:</b> Give access to the graph whose measurement is being
	 * done. <br>
	 * 
	 * <b>Example of use:</b> This method is used to give access to the graph so
	 * it can be manipulated.
	 * 
	 * @return the graph that will have it's measurement calculated.
	 */
	public InterfaceGraph getGraph() {
		return graph;
	}

	/**
	 * <b>Objective:</b> Defines the graph whose measurement will be done. <br>
	 * 
	 * <b>Example of use:</b> This method is used to determine a graph so it can
	 * be manipulated.
	 * 
	 * @param graph
	 *            the new graph to have it's measurement calculated.
	 */
	public void setGraph(InterfaceGraph graph) {
		this.graph = graph;
	}
}
