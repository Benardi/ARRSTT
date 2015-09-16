package br.edu.ufcg.splab.trash;

import java.util.List;

/**
 * Abstract implementation of an experiment. Already
 * defines some operations with the factors and the combinator.
 * 
 */
public abstract class AbstractExperiment implements InterfaceExperiment {
	private List<InterfaceFactor> factors;
	private Combinable combinator;
	
	/**
	 * Build a new experiment, takes a list of factors and a combinator.
	 * 
	 * @param factors
	 * 		The list of factors of the experiment.
	 * @param combinator
	 * 		The combinator the experiment will use.
	 */
	public AbstractExperiment(List<InterfaceFactor> factors, Combinable combinator) {
		this.factors = factors;
		this.combinator = combinator;
	}

	@Override
	public boolean addFactor(InterfaceFactor factor) {
		return factors.add(factor);
	}

	@Override
	public boolean removeFactor(InterfaceFactor factor) {
		return factors.remove(factor);
	}

	@Override
	public InterfaceFactor getFactor(int i) {
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
