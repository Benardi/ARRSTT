package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.builders.APCoverage;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.builders.ATCoverage;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.builders.RequirementBuilder;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.factories.MinimizationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.ReqBuilderType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-08-11
 * 
 */
/**
 * <b>Objective:</b> This is a complete factorial combinator. This means that
 * it will generate all possible combinations for the Selection
 * Experiment's treatments. 
 * <br>
 * <b>Description of use:</b> Used in the Experiment class to generate the
 * necessary for the Runner to work.
 *
 */
public class MinimizationSetup implements InterfaceSetup {
	private List<MinimizationType> minimizationAlgorithms;
	private List<TestSuite> testSuites;
	private ReqBuilderType builder;
	
	/**
	 * SelectionSetup's constructor.
	 * 
	 * @param testSuites
	 * 			The list of TestSuites that contains TestCases with
	 * 			defects.
	 * @param selectionPercentage
	 * 			The quantity of TestCase that will be selected in each
	 * 			TestSuite.
	 * @param selectionAlgorithms
	 * 			The algorithm that will take the TestSuite and percentage
	 * 			and do the selection.
	 */
	public MinimizationSetup(List<TestSuite> testSuites, List<MinimizationType> minimizationAlgorithms, ReqBuilderType builder) {
		this.testSuites = testSuites;
		this.minimizationAlgorithms = minimizationAlgorithms;
		this.builder = builder;
	}

	@Override
	/**
	 * <b>Objective:</b> Return the complete factorial independent variables' 
	 * combinations of the ARRSTT selection experiment.
	 * <br>
	 * <b>Exemple of use:</b> The list of tuples returned can be used
	 * by a Runner that is going to execute the experiment. This
	 * generally happens in the Experiment class. 
	 * 
	 * @return The list of ExecutableTreatment's tuple, that
	 * represents independent variables combinations.
	 */
	public List<Tuple<ExecutableTreatment>> getArtifacts() {
		List<Tuple<ExecutableTreatment>> combinations = new ArrayList<>();
		TreatmentFactory treatmentFactory = new TreatmentFactory();

		for (MinimizationType minimization : minimizationAlgorithms) {
			for (TestSuite ts : testSuites) {
				Tuple<ExecutableTreatment> combination = new Tuple<ExecutableTreatment>();
				RequirementBuilder reqBuilder = null;
				
				if (ReqBuilderType.APCoverage == builder) {
					reqBuilder = new APCoverage(ts);
				} else if (ReqBuilderType.ATCoverage == builder) {
					reqBuilder = new ATCoverage(ts);
				}
				
				combination.add(treatmentFactory.createMinimization(minimization, ts, reqBuilder.getRequirements()));
				combinations.add(combination);
			}
		}

		return combinations;
	}
}
