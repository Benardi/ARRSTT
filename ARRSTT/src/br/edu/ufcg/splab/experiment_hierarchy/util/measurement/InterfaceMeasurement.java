package br.edu.ufcg.splab.experiment_hierarchy.util.measurement;

/**
 * Interface that represents every class that can calculate the measurement of
 * another one in some way.
 */
/**
 * <b>Objective:</b> Interface that represents every class that can calculate
 * the measurement of another one in some way.<br>
 * <br>
 * 
 * <b>Description of use:</b> The class BranchMeasurementOne implements this
 * interface.
 *
 */
public interface InterfaceMeasurement {
	/**
	 * <b>Objective:</b> Calculates and returns the measurement. <br>
	 * 
	 * <b>Example of use:</b> This method is used to measure some dimension.
	 * 
	 * @return the measurement.
	 */
	public double measure();
}
