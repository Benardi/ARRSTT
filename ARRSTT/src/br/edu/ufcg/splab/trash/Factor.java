package br.edu.ufcg.splab.trash;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;

public class Factor extends AbstractFactor {

	/**
	 * Build a new factor.
	 * 
	 * @param treatments
	 * 		A list of treatments that the factor initially has.
	 */
	public Factor(List<ExecutableTreatment> treatments) {
		super(treatments);
	}

	/**
	 * Build a new factor with an initially empty list of treatments.
	 */
	public Factor() {
		super(new ArrayList<ExecutableTreatment>());
	}
}
