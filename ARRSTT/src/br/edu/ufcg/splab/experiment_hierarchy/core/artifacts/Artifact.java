package br.edu.ufcg.splab.experiment_hierarchy.core.artifacts;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;

public class Artifact <T> {
	private T target;
	private List<InterfaceDvc> dvcs;
	
	public Artifact(T target, List<InterfaceDvc> dvcs) {
		this.target = target;
		this.dvcs = dvcs;
	}
	
	public T getTarget() {
		return target;
	}
	
	public List<InterfaceDvc> getDvcs() {
		return dvcs;
	}
}
