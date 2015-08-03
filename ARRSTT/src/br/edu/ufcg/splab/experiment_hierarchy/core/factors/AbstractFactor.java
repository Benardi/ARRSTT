package br.edu.ufcg.splab.experiment_hierarchy.core.factors;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;

/**
 * Abstract implementation of a factor. Uses a List to store
 * treatments. 
 *
 */
public abstract class AbstractFactor implements InterfaceFactor {
	/**
	 * Store the treatments.
	 */
	private List<ExecutableTreatment> treatments;
	
	/**
	 * Build a new factor.
	 * 
	 * @param treatments
	 * 		A list of treatments that the factor initially has.
	 */
	public AbstractFactor(List<ExecutableTreatment> treatments) {
		this.treatments = treatments;
	}
	
	@Override
	public boolean addTreatment(ExecutableTreatment treatment) {
		return treatments.add(treatment);
	}

	@Override
	public boolean removeTreatment(ExecutableTreatment treatment) {
		return treatments.remove(treatment);
	}
	
	@Override
	public ExecutableTreatment getTreatment(int i) {
		return treatments.get(i);
	}
	
	@Override
	public ExecutableTreatment[] getTreatments() {
		return (ExecutableTreatment[]) treatments.toArray();
	}
}
