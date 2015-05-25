package br.edu.ufcg.splab.experiment.core.factors;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.useless.Treatment;

public class FactorLoopCoverage extends AbstractFactor<Integer> {

	public FactorLoopCoverage(List<Treatment<Integer>> treatments) {
		super(treatments);
	}
	
	public FactorLoopCoverage() {
		super(new ArrayList<Treatment<Integer>>());
	}
	
}
