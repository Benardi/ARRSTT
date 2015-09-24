package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
/* Change		Author		Date
 * Creation		Iaron		2015-08-11
 */
/**
 * Objective: This is a complete factorial combinator. This means that
 * it will generate all possible combinations for the Selection
 * Experiment's treatments. 
 * 
 * Description of use: Used in the Experiment class to generate the
 * necessary for the Runner to work.
 *
 */
public class SelectionSetup implements InterfaceSetup {
	private SelectionType[] selectionAlgorithms;
	private double selectionPercentage;
	private List<TestSuite> testSuites;
	
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
	public SelectionSetup(List<TestSuite> testSuites, double selectionPercentage, SelectionType[] selectionAlgorithms) {
		this.selectionPercentage = selectionPercentage;
		this.testSuites = testSuites;
		this.selectionAlgorithms = selectionAlgorithms;
	}

	@Override
	/**
	 * Objective: Return the complete factorial independent variables' 
	 * combinations of the ARRSTT selection experiment.
	 * 
	 * Exemple of use: The list of tuples returned can be used
	 * by a Runner that is going to execute the experiment. This
	 * generally happens in the Experiment class. 
	 * 
	 * @return The list of ExecutableTreatment's tuple, that
	 * represents independent variables combinations.
	 */
	public List<Tuple<ExecutableTreatment>> getIndependentVariables() {
		List<Tuple<ExecutableTreatment>> combinations = new ArrayList<>();
		TreatmentFactory treatmentFactory = new TreatmentFactory();

		for (SelectionType selection : selectionAlgorithms) {
			for (TestSuite ts : testSuites) {
				Tuple<ExecutableTreatment> combination = new Tuple<ExecutableTreatment>();
				combination.add(treatmentFactory.createSelection(selection, ts, selectionPercentage));
				combinations.add(combination);
			}
		}

		return combinations;
	}
}
