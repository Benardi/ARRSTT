package br.edu.ufcg.splab.experiment.core;

import br.edu.ufcg.splab.experiment.useless.Treatment;

/**
 * A general type that every factor of an experiment
 * must implement.
 * 
 * @param <T>
 * 		The type of data that the treatments of a factor will be.
 */
public interface InterfaceFactor<T> {
	public boolean addTreatment(Treatment<T> treatment);
	public boolean removeTreatment(Treatment<T> treatment);
	public Treatment<T> getTreatment(int i);
	public Treatment<T>[] getTreatments();
}
