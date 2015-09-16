package br.edu.ufcg.splab.experiment_hierarchy.util.measurement;

/**
 * Interface that represents every class that can calculate the measurement of
 * another one in some way.
 */
public interface InterfaceMeasurement {
	/**
	 * Calculates and returns the measurement.
	 * @return the measurement.
	 */
	public double measure();
}
