package br.edu.ufcg.splab.experiment.core.combinators;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.core.Combinable;
import br.edu.ufcg.splab.experiment.core.InterfaceFactor;

public abstract class AbstractCombinator implements Combinable {
	private List<InterfaceFactor<?>> factors;
	
	public AbstractCombinator(List<InterfaceFactor<?>> factors) {
		this.factors = factors;
	}
	
	public void setFactors(List<InterfaceFactor<?>> factors) {
		this.factors = factors;
	}
	
	public List<InterfaceFactor<?>> getFactors() {
		return new ArrayList<InterfaceFactor<?>>(factors);
	}
}
