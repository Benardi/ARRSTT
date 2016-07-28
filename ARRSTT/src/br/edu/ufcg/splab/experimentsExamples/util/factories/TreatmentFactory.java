package br.edu.ufcg.splab.experimentsExamples.util.factories;

import br.edu.ufcg.splab.arrsttFramework.IExecutableTreatment;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.core.treatments.GenerationTreatment;
import br.edu.ufcg.splab.experimentsExamples.core.treatments.MinimizationTreatment;
import br.edu.ufcg.splab.experimentsExamples.core.treatments.SelectionTreatment;
import br.edu.ufcg.splab.experimentsExamples.techniques.generation.InterfaceGenerationTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experimentsExamples.util.enums.GenerationType;
import br.edu.ufcg.splab.graph.core.InterfaceVertex;
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
	public IExecutableTreatment createSelection(InterfaceSelectionTechnique selector, TestSuite testSuite, double percentage) {
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
	public IExecutableTreatment createGeneration(GenerationType type,
			InterfaceVertex root, int loopCoverage) {
		InterfaceGenerationTechnique generator = new GenerationFactory()
				.createTreatment(type);
		return new GenerationTreatment(generator, root, loopCoverage);
	}
	
	public IExecutableTreatment createMinimization(InterfaceMinimizationTechnique technique) {
		return new MinimizationTreatment(technique);
	}
}
