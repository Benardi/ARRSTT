package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/**
 * 
 * Class who represents the set up of an experiment whose sphere is the
 * selection.
 * 
 * @author JoséBenardi
 *
 */
public class SelectionSetup implements InterfaceSetup {
	private SelectionType[] selectionAlgorithms;
	private double selectionPercentage;
	private List<TestSuite> testSuites;

	/**
	 * 
	 * @param graphs
	 *            The base graph that will be manipulated.
	 * @param maskarator
	 *            The technique who will insert errors on the graph.
	 * @param maskPercentage
	 *            Percentage of errors put in the graph.
	 * @param selectionPercentage
	 *            Percentage that will be chosen as result.
	 * 
	 */
	public SelectionSetup(List<TestSuite> testSuites, double selectionPercentage, SelectionType[] selectionAlgorithms) {
		this.selectionPercentage = selectionPercentage;
		this.testSuites = testSuites;
		this.selectionAlgorithms = selectionAlgorithms;
	}

	@Override
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
