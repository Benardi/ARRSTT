package br.edu.ufcg.splab.experiment.core.treatments;

/**
 * Represents a treatment. A treatment is basically composed of
 * an object of the type T.
 * 
 * @param <T>
 * 		The type of data that the treatment encapsulates.
 */
public class Treatment<T> implements InterfaceTreatment<T> {
	/**
	 * An object encapsulated by the treatment.
	 */
	private T treatment;

	/**
	 * Build a new treatment with a value.
	 * 
	 * @param t
	 * 		The data that will be hold by the object.
	 */
	public Treatment(T t) {
		this.treatment = t;
	}
	
	/**
	 * Build an empty treatment.
	 */
	public Treatment() {
		
	}

	/**
	 * Change the value hold by the treatment.
	 * 
	 * @param newTreatment
	 * 		The new value.
	 */
	public void setTreatment(T newTreatment) {
		treatment = newTreatment;
	}

	@Override
	public boolean isEmpty() {
		if (treatment == null) {
			return true;
		}
		return false;
	}

	@Override
	public T getTreatment() {
		return treatment;
	}
}