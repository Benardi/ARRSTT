package br.edu.ufcg.splab.experiment.core.factors;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.core.treatments.InterfaceTreatment;

/**
 * Represents a factor for the loop coverage.
 *
 */
public class FactorLoopCoverage extends AbstractFactor<Integer> {
	/**
	 * Build a new loop coverage factor and put in the new object a list of treatments.
	 * 
	 * @param treatments
	 * 		A list of treatments that the object will incorporate.
	 */
	public FactorLoopCoverage(List<InterfaceTreatment<Integer>> treatments) {
		super(treatments);
	}
	
	/**
	 * Build a new loop coverage factor with an initially empty list of treatments.
	 */
	public FactorLoopCoverage() {
		super(new ArrayList<InterfaceTreatment<Integer>>());
	}
	
}
