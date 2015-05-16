package br.edu.ufcg.splab.experiment.core;

public interface InterfaceExperiment {
	public void runExperiment();
	public boolean addFactor(InterfaceFactor<?> factor);
	public boolean removeFactor(InterfaceFactor<?> factor);
	public InterfaceFactor<?> getFactor(int i);
	public void setCombinator(Combinable combinator);
	public Combinable getCombinator();
}
