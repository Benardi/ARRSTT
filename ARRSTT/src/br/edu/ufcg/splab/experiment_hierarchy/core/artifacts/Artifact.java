package br.edu.ufcg.splab.experiment_hierarchy.core.artifacts;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;

public class Artifact <T> {
	private T target;
	private List<DependentVariableCollector> dvcs;
	
	public Artifact(T target, List<DependentVariableCollector> dvcs) {
		this.target = target;
		this.dvcs = dvcs;
	}
	
	public T getTarget() {
		return target;
	}
	
	public List<DependentVariableCollector> getDvcs() {
		return dvcs;
	}
}
