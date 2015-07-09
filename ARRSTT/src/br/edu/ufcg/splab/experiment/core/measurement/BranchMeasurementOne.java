package br.edu.ufcg.splab.experiment.core.measurement;

import br.edu.ufcg.splab.core.InterfaceGraph;

public class BranchMeasurementOne implements InterfaceMeasurement {
	private InterfaceGraph graph;
	
	public BranchMeasurementOne(InterfaceGraph graph) {
		this.graph = graph;
	}
	
	public double measure() {
		return (double)graph.getEdges().size() / (double)graph.getStates().size();
	}

	public InterfaceGraph getGraph() {
		return graph;
	}

	public void setGraph(InterfaceGraph graph) {
		this.graph = graph;
	}	
}
