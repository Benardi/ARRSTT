package br.edu.ufcg.splab.experiment.core.experiments;

import java.util.List;

import br.edu.ufcg.splab.experiment.core.Combinable;
import br.edu.ufcg.splab.experiment.core.InterfaceExperiment;
import br.edu.ufcg.splab.experiment.core.InterfaceFactor;

public abstract class AbstractExperiment implements InterfaceExperiment {
	private List<InterfaceFactor<?>> factors;
	private Combinable combinator;
	
	public AbstractExperiment(List<InterfaceFactor<?>> factors, Combinable combinator) {
		this.factors = factors;
		this.combinator = combinator;
	}

	@Override
	public boolean addFactor(InterfaceFactor<?> factor) {
		return factors.add(factor);
	}

	@Override
	public boolean removeFactor(InterfaceFactor<?> factor) {
		return factors.remove(factor);
	}

	@Override
	public InterfaceFactor<?> getFactor(int i) {
		return factors.get(i);
	}

	@Override
	public void setCombinator(Combinable combinator) {
		this.combinator = combinator;
	}

	@Override
	public Combinable getCombinator() {
		return combinator;
	}
	
}
