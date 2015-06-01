package br.edu.ufcg.splab.experiment.core.combinators;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.core.factors.InterfaceFactor;
import br.edu.ufcg.splab.experiment.core.treatments.InterfaceTreatment;

/**
 * This is a complete factorial combinator. This means that
 * it will generate all possible combinations for the treatments. 
 *
 */
public class CFCombinator extends AbstractCombinator {
	
	/**
	 * Build a new combinator with a list of factors. 
	 * 
	 * @param factors
	 * 		The list of factors which the treatments are in.
	 */
	public CFCombinator(List<InterfaceFactor<?>> factors) {
		super(factors);
	}

	public List<List<?>> combine() {
		List<List<?>> combinatedList = new ArrayList<List<?>>();
		InterfaceTreatment<?>[] searches = (InterfaceTreatment[]) super.getFactors().get(0).getTreatments();
		InterfaceTreatment<?>[] loopCoverage = (InterfaceTreatment[]) super.getFactors().get(1).getTreatments();
		InterfaceTreatment<?>[] factorBranches = (InterfaceTreatment[]) super.getFactors().get(2).getTreatments();
		
		
		for (InterfaceTreatment<?> search : searches) {
			for (InterfaceTreatment<?>  loop : loopCoverage) {
				for (InterfaceTreatment<?>  factorBranch : factorBranches) {
					List<InterfaceTreatment<?>> f = new ArrayList<InterfaceTreatment<?>>();
					
					f.add(search);
					f.add(loop);
					f.add(factorBranch);
					
					combinatedList.add(f);
				}
			}
		}
		
		return combinatedList;
	}
	
}
