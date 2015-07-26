package br.edu.ufcg.splab.experimentHierarchy.core.experiment_rep;

import java.util.List;

import br.edu.ufcg.splab.experimentHierarchy.core.combinators.Combinable;
import br.edu.ufcg.splab.experimentHierarchy.core.factors.InterfaceFactor;

/**
 * Represents a replicable experiment.
 *
 */
public abstract class ReplicableExperiment extends AbstractExperiment {
	private int repNumber;
	
	/**
	 * Build a new experiment, take a list of factors, a combinator a the number
	 * of replications of the experiment.
	 * 
	 * @param factors
	 * 		The list of factors of the experiment.
	 * @param combinator
	 * 		The combinator the experiment will use.
	 * @param repNumber
	 * 		The number of replications of the experiment.
	 */
	public ReplicableExperiment(List<InterfaceFactor> factors,	Combinable combinator, int repNumber) {
		super(factors, combinator);
		
		this.repNumber = repNumber;
	}
	
	/**
	 * Set the number of replications.
	 * 
	 * @param repNumber
	 * 		The new number of replications.
	 */
	public void setRepNumber(int repNumber) {
		this.repNumber = repNumber;
	}
	
	/**
	 * Get the number of replications of the experiment.
	 * 
	 * @return
	 * 		The current number of replications.
	 */
	public int getRepNumber() {
		return repNumber;
	}
}
