package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.GenerationTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.MinimizationTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.SelectionTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.generation.InterfaceGenerationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> This class covers all necessary procedure involved in the process
 * of generating a treatment.
 * <br>
 * <b>Description of use:</b> This class is used in the "set up" type classes to where
 * for e.g it can be used to generate the independent variables.
 */
public class TreatmentFactory {
	/**
	 * 
	 * @param type
	 *            The type of selection
	 * @param testSuite
	 *            the test suite.
	 * @param percentage
	 *            the percentage
	 * @return A selection treatment that is composed by all the parameters.
	 */
	public ExecutableTreatment createSelection(InterfaceSelectionTechnique selector, TestSuite testSuite, double percentage) {
		// cria o selection type
		// chamar o selection para retornar a instancia de selection.
		return new SelectionTreatment(selector, testSuite, percentage);
	}

	/**
	 * 
	 * @param type
	 *            the type of generation
	 * @param root
	 *            the root
	 * @param loopCoverage
	 *            the loop coverage
	 * @return A generation treatment that is composed by all the parameters.
	 */
	public ExecutableTreatment createGeneration(GenerationType type,
			InterfaceVertex root, int loopCoverage) {
		InterfaceGenerationTechnique generator = new GenerationFactory()
				.createTreatment(type);
		return new GenerationTreatment(generator, root, loopCoverage);
	}
	
	public ExecutableTreatment createMinimization(InterfaceMinimizationTechnique technique) {
		return new MinimizationTreatment(technique);
	}
}
