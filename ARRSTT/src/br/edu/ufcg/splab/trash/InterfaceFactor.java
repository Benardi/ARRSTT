package br.edu.ufcg.splab.trash;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;

/**
 * Represents a generic type of factor.
 * 
 * @param <T>
 * 		Data type that treatments of this factor receives.
 */
public interface InterfaceFactor {
	/**
	 * Add a treatment to the factor.
	 * 
	 * @param treatment
	 * 		The treatment to be put on the factor.
	 * @return
	 * 		True if the treatment was successfully added, false otherwise.
	 */
	public boolean addTreatment(ExecutableTreatment treatment);
	
	/**
	 * Remove a treatment from the factor.
	 * 
	 * @param treatment
	 * 		The treatment to be removed from the factor.
	 * @return
	 * 		True if the treatment was successfully removed, false otherwise.	
	 */
	public boolean removeTreatment(ExecutableTreatment treatment);
	
	/**
	 * Retrieves a treatment from the factor.
	 * 
	 * @param i
	 * 		A number that can be translated into a treatment on the using representation.
	 * @return
	 * 		The retrieving treatment.
	 */
	public ExecutableTreatment getTreatment(int i);
	
	/**
	 * Converts all treatments to an array.
	 * 
	 * @return
	 * 		An array with all treatments.
	 */
	public ExecutableTreatment[] getTreatments();
}
