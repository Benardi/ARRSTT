package br.edu.ufcg.splab.experiment.core.factors;

import java.util.List;

import br.edu.ufcg.splab.experiment.core.InterfaceFactor;
import br.edu.ufcg.splab.experiment.useless.Treatment;

public abstract class AbstractFactor<T> implements InterfaceFactor<T> {
	private List<Treatment<T>> treatments;
	
	public AbstractFactor(List<Treatment<T>> treatments) {
		this.treatments = treatments;
	}
	
	@Override
	public boolean addTreatment(Treatment<T> treatment) {
		return treatments.add(treatment);
	}

	@Override
	public boolean removeTreatment(Treatment<T> treatment) {
		return treatments.remove(treatment);
	}
	
	@Override
	public Treatment<T> getTreatment(int i) {
		return treatments.get(i);
	}
	
	
	// Has to be checked - Iaron
	@SuppressWarnings("unchecked")
	@Override
	public Treatment<T>[] getTreatments() {
		return (Treatment<T>[]) treatments.toArray();
	}
	
}
