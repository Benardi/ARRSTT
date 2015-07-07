package br.edu.ufcg.splab.experiment.IaronBranch;

import br.edu.ufcg.splab.core.InterfaceGraph;

public class BranchMeasurementOne implements Measurement {
	private InterfaceGraph graph;
	
	public BranchMeasurementOne(InterfaceGraph graph) {
		this.graph = graph;
	}
	
	public double measure() {
		double numVertexes = graph.getStates().size();
		double numEdges = graph.getEdges().size();
		
		return numEdges / numVertexes;
	}

	public InterfaceGraph getGraph() {
		return graph;
	}

	public void setGraph(InterfaceGraph graph) {
		this.graph = graph;
	}	
}
