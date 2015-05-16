package br.edu.ufcg.splab.experiment.core;

/**
 * A general type that every factor of an experiment
 * must implement.
 * 
 * @param <T>
 * 		The type of data that the treatments of a factor will be.
 */
public interface InterfaceFactor<T> {
	public boolean addTreatment(T treatment);
	public boolean removeTreatment(T treatment);
	public T getTreatment(int i);
}
