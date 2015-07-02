package br.edu.ufcg.splab.experiment.IaronBranch;

import br.edu.ufcg.splab.core.InterfaceGraph;

public interface Measurement {
	public double measure();
	public InterfaceGraph getGraph();
	public void setGraph(InterfaceGraph graph);
}
