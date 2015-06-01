package br.edu.ufcg.splab.experiment.core.factors;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.core.treatments.InterfaceTreatment;

/**
 * Represents a factor for the branchs (to be decide how it will work).
 *
 */
public class FactorBranch extends AbstractFactor<Integer> {

	/**
	 * Build a new branch factor and put in the new object a list of treatments.
	 * 
	 * @param treatments
	 * 		A list of treatments that the object will incorporate.
	 */
	public FactorBranch(List<InterfaceTreatment<Integer>> treatments) {
		super(treatments);
	}
	
	/**
	 * Build a new branch factor with an initially empty list of treatments.
	 */
	public FactorBranch() {
		super(new ArrayList<InterfaceTreatment<Integer>>());
	}
	
}
