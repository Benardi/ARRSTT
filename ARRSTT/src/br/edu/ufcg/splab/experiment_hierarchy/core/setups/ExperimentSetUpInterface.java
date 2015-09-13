package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

/**
 * 
 * Interface that represents the basic structure expected from an experiment set
 * up.
 * 
 * @author JoséBenardi
 *
 */
public interface ExperimentSetUpInterface {
	/**
	 * 
	 * @return The list of independent variables
	 */
	public List<Tuple<ExecutableTreatment>> getIndependentVariables();
}
