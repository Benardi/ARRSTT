package br.edu.ufcg.splab.experiment.core.combinators;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.core.InterfaceFactor;

public class CFCombinator extends AbstractCombinator {
	
	public CFCombinator(List<InterfaceFactor<?>> factors) {
		super(factors);
	}
	
	public CFCombinator() {
		super(new ArrayList<InterfaceFactor<?>>());
	}
	
	public List<List<?>> combinate() {
		// To be implemented;
		return new ArrayList<List<?>>();
	}
	
}
