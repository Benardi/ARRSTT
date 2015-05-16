package br.edu.ufcg.splab.experiment.core.factors;

import java.util.List;

import br.edu.ufcg.splab.experiment.core.InterfaceFactor;

public abstract class AbstractFactor<T> implements InterfaceFactor<T> {
	private List<T> treatments;
	
	public AbstractFactor(List<T> treatments) {
		this.treatments = treatments;
	}
	
	@Override
	public boolean addTreatment(T treatment) {
		return treatments.add(treatment);
	}

	@Override
	public boolean removeTreatment(T treatment) {
		return treatments.remove(treatment);
	}
	
	@Override
	public T getTreatment(int i) {
		return treatments.get(i);
	}
}
