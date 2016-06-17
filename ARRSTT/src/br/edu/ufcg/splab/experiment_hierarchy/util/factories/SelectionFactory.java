package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.BiggestTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.RandomTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.SimilarityTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> his class covers all necessary procedure involved in the process
 * of generating a selector.
 * <br>
 * <b>Description of use:</b> Receives a type of selection and returns a selector of
 * the respective type.
 */
public class SelectionFactory {
	/**
	 * <b>Objective:</b> Generating a selector whose type of selection is the same as
	 * the provided one.
	 * <br>
	 * <b>Description of use:</b> The generated selection can be used in the building
	 * of a selection as in the Experiment Factory class.
	 * 
	 * @param type
	 *            The desired type of selection
	 * @return A selector of the desired type.
	 */
	public InterfaceSelectionTechnique createTreatment(SelectionType type) {
		if (type == SelectionType.BIGGEST) {
			return createBiggestSelector();
		} else if (type == SelectionType.RANDOMIZED) {
			return createRandomizedSelector();
		} else {
			return createSimilaritySelector();
		}
	}

	/**
	 * 
	 * @return A biggest test case selector
	 */
	public InterfaceSelectionTechnique createBiggestSelector() {
		return new BiggestTechnique();
	}

	/**
	 * 
	 * @return A randomized selector.
	 */
	public InterfaceSelectionTechnique createRandomizedSelector() {
		return new RandomTechnique();
	}

	/**
	 * 
	 * @return a similarity selector.
	 */
	public InterfaceSelectionTechnique createSimilaritySelector() {
		return new SimilarityTechnique();
	}
}
