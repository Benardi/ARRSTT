package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.TreatmentSelection;
import br.edu.ufcg.splab.experiment_hierarchy.graph_maskers.InterfaceGraphMaskarator;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BiggestTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BySimilaritySelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.RandomizedTestCaseSelection;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;

/**
 * 
 * Class who represents the set up of an experiment whose sphere is the
 * selection.
 * 
 * @author JoséBenardi
 *
 */
public class ExperimentSetUpSelection implements ExperimentSetUpInterface {
	private static final int LOOP_COVERAGE = 0;
	private InterfaceSearch search;
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
	public ExperimentSetUpSelection(List<TestSuite> testSuites, double selectionPercentage) {
		this.selectionPercentage = selectionPercentage;
		this.testSuites = testSuites;
	}

	@Override
	public List<Tuple<ExecutableTreatment>> getIndependentVariables() {
		return combine(selectionPercentage);
	}

	/**
	 * 
	 * @param maskedTestSuites
	 *            Copy of the graph bound to the class.
	 * 
	 * @param selectionPercentage
	 *            Percentage of cases that shall be chosen
	 * @return
	 */
	private List<Tuple<ExecutableTreatment>> combine(double selectionPercentage) {
		List<Tuple<ExecutableTreatment>> combinations = new ArrayList<>();

		List<InterfaceTestCaseSelector> selectionAlgorithms = new ArrayList<InterfaceTestCaseSelector>();
		selectionAlgorithms.add(new BySimilaritySelector());
		selectionAlgorithms.add(new RandomizedTestCaseSelection());

		selectionAlgorithms.add(new BiggestTestCaseSelector());

		for (InterfaceTestCaseSelector selection : selectionAlgorithms) {
			for (TestSuite ts : testSuites) {
				Tuple<ExecutableTreatment> combination = new Tuple<ExecutableTreatment>();
				combination.add(new TreatmentSelection(selection, ts,
						selectionPercentage));
				combinations.add(combination);
			}
		}

		return combinations;
	}
}
