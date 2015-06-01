package br.edu.ufcg.splab.experiment.core.treatments;

/**
 * Represents a general type of treatment.
 *
 * @param <T>
 * 		The type of data that the treatment encapsulates.
 */
public interface InterfaceTreatment<T> {
	/**
	 * Checks if a treatment is empty of data.
	 * 
	 * @return
	 * 		True if it is empty, false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Get the data inside the treatment object.
	 * 
	 * @return
	 * 		The data encapsulated by the treatment.
	 */
	public T getTreatment();
}
