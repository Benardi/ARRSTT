package br.edu.ufcg.splab.experiment.core.factors;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.useless.Treatment;

public class FactorBranch extends AbstractFactor<Integer> {

	public FactorBranch(List<Treatment<Integer>> treatments) {
		super(treatments);
	}
	
	public FactorBranch() {
		super(new ArrayList<Treatment<Integer>>());
	}
	
}
