package br.edu.ufcg.splab.experiment.core.factors;

import java.util.List;

import br.edu.ufcg.splab.experiment.core.treatments.InterfaceTreatment;

/**
 * Abstract implementation of a factor. Uses a List to store
 * treatments. 
 *
 * @param <T>
 * 		Data type that treatments of this factor receives.
 */
public abstract class AbstractFactor<T> implements InterfaceFactor<T> {
	/**
	 * Store the treatments.
	 */
	private List<InterfaceTreatment<T>> treatments;
	
	/**
	 * Build a new factor.
	 * 
	 * @param treatments
	 * 		A list of treatments that the factor initially has.
	 */
	public AbstractFactor(List<InterfaceTreatment<T>> treatments) {
		this.treatments = treatments;
	}
	
	@Override
	public boolean addTreatment(InterfaceTreatment<T> treatment) {
		return treatments.add(treatment);
	}

	@Override
	public boolean removeTreatment(InterfaceTreatment<T> treatment) {
		return treatments.remove(treatment);
	}
	
	@Override
	public InterfaceTreatment<T> getTreatment(int i) {
		return treatments.get(i);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public InterfaceTreatment<T>[] getTreatments() {
		return (InterfaceTreatment<T>[]) treatments.toArray();
	}
	
}
