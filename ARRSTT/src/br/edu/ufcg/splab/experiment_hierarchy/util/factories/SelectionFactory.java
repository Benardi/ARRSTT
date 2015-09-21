package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.selections.BiggestTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BySimilaritySelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.RandomizedTestCaseSelection;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;

public class SelectionFactory {
	
	public InterfaceTestCaseSelector createTreatment(SelectionType type) {
		if (type == SelectionType.BIGGEST) {
			return createBiggestSelector();
		} else if (type == SelectionType.RANDOMIZED) {
			return createRandomizedSelector();
		} else {
			return createSimilaritySelector();
		}
	}
	
	public InterfaceTestCaseSelector createBiggestSelector() {
		return new BiggestTestCaseSelector();
	}
	
	public InterfaceTestCaseSelector createRandomizedSelector() {
		return new RandomizedTestCaseSelection();
	}
	
	public InterfaceTestCaseSelector createSimilaritySelector() {
		return new BySimilaritySelector();
	}
}
