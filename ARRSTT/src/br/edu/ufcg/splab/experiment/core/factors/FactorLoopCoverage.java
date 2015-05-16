package br.edu.ufcg.splab.experiment.core.factors;

import java.util.ArrayList;
import java.util.List;

public class FactorLoopCoverage extends AbstractFactor<Integer> {

	public FactorLoopCoverage(List<Integer> treatments) {
		super(treatments);
	}
	
	public FactorLoopCoverage() {
		super(new ArrayList<Integer>());
	}
	
}
