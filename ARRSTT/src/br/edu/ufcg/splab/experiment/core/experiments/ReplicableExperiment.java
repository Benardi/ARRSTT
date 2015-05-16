package br.edu.ufcg.splab.experiment.core.experiments;

import java.util.List;

import br.edu.ufcg.splab.experiment.core.Combinable;
import br.edu.ufcg.splab.experiment.core.InterfaceFactor;

public abstract class ReplicableExperiment extends AbstractExperiment {
	private int repNumber;
	
	public ReplicableExperiment(List<InterfaceFactor<?>> factors,	Combinable combinator, int repNumber) {
		super(factors, combinator);
		
		this.repNumber = repNumber;
	}
	
	public void setRepNumber(int repNumber) {
		this.repNumber = repNumber;
	}
	
	public int getRepNumber() {
		return repNumber;
	}
}
