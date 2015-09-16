package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.SelectionTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BiggestTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BySimilaritySelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.RandomizedTestCaseSelection;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class SelectionFactory {
	public ExecutableTreatment createTreatment(SelectionType type, TestSuite testSuite, double percentage) {
		if (type == SelectionType.BIGGEST) {
			return createBiggestSelector(testSuite, percentage);
		} else if (type == SelectionType.RANDOMIZED) {
			return createRandomizedSelector(testSuite, percentage);
		} else {
			return createSimilaritySelector(testSuite, percentage);
		}
	}
	
	public ExecutableTreatment createBiggestSelector(TestSuite testSuite, double percentage) {
		return new SelectionTreatment(new BiggestTestCaseSelector(), testSuite, percentage);
	}
	
	public ExecutableTreatment createRandomizedSelector(TestSuite testSuite, double percentage) {
		return new SelectionTreatment(new RandomizedTestCaseSelection(), testSuite, percentage);
	}
	
	public ExecutableTreatment createSimilaritySelector(TestSuite testSuite, double percentage) {
		return new SelectionTreatment(new BySimilaritySelector(), testSuite, percentage);
	}
}
