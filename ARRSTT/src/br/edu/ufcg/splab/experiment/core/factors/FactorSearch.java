package br.edu.ufcg.splab.experiment.core.factors;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.core.treatments.InterfaceTreatment;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

/**
 * Represents a factor for the search.
 *
 */
public class FactorSearch extends AbstractFactor<InterfaceSearch> {
	/**
	 * Build a new search factor and put in the new object a list of treatments.
	 * 
	 * @param treatments
	 * 		A list of treatments that the object will incorporate.
	 */
	public FactorSearch(List<InterfaceTreatment<InterfaceSearch>> treatments) {
		super(treatments);
	}
	
	/**
	 * Build a new search factor with an initially empty list of treatments.
	 */
	public FactorSearch() {
		super(new ArrayList<InterfaceTreatment<InterfaceSearch>>());
	}
	
}
