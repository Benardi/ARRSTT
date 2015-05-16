package br.edu.ufcg.splab.experiment.core.factors;

import java.util.ArrayList;
import java.util.List;

public class FactorBranch extends AbstractFactor<Integer> {

	public FactorBranch(List<Integer> treatments) {
		super(treatments);
	}
	
	public FactorBranch() {
		super(new ArrayList<Integer>());
	}
	
}
