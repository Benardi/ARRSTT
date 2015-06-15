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
    private List<List<InterfaceTreatment<?>>> combinatedList;
	
	/**
	 * Build a new combinator with a list of super.getFactors(). 
	 * 
	 * @param super.getFactors()
	 * 		The list of super.getFactors() which the treatments are in.
	 */
	public CFCombinator(List<InterfaceFactor<?>> factors) {
		super(factors);
	}
	
	public CFCombinator() {
		super(new ArrayList<InterfaceFactor<?>>());
	}

    
	/* There are two things here that we may look... first, this works just for our experiment, because
	 * it is explicit what each treatment is, and it combines exactly 3 super.getFactors(), I think we can make
	 * this work for any amount of super.getFactors(). The other thing is that since I've made some changes to Factor
	 * itself and that now we have a Treatment class, I think this method should return a List<List<Treatment>>
	 * because this will make it more flexible and keep the Expert. So, what do you think? - Iaron
	 */
	 /*
	public List<List<?>> combine(){
		List<List<?>> combinatedList = new ArrayList<List<?>>();
		InterfaceTreatment<?>[] searches = (InterfaceTreatment[]) super.getsuper.getFactors()().get(0).getTreatments();
		InterfaceTreatment<?>[] loopCoverage = (InterfaceTreatment[]) super.getsuper.getFactors()().get(1).getTreatments();
		InterfaceTreatment<?>[] factorBranches = (InterfaceTreatment[]) super.getsuper.getFactors()().get(2).getTreatments();
		
		
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
	}*/
	
	/**
	 * Generate all the possible combinations for the treatments.
	 * 
	 * @return A list with n-tuples, each one a combination 
	 */
	
	public List<List<InterfaceTreatment<?>>> combine() {
	    combinatedList = initializeList();
	    
	    for (int i = 1; i < super.getFactors().size(); i++) 
	    	combineFactor(super.getFactors().get(i));
	    
	    return combinatedList;
	}
	
	/**
	 * After the list(the list inside the combinatedList) is expanded
	 * delete the previous state of it.
	 * 
	 * @param factor
	 */
	
	private void combineFactor(InterfaceFactor<?> factor) {
		int loopEnd = combinatedList.size();
		for (int j = 0; j < loopEnd; j++)
			generateCombinations(combinatedList.get(j), factor);
		
		combinatedList.removeAll(combinatedList.subList(0, loopEnd));
	}
	
	/**
	 * Receives the actual state of a list(list inside the combinatedList),
	 * expands it and put it in the combinatedList to form the final n-tuple.
	 * 
	 * @param combination
	 * 		The actual state of a n-tuple.
	 * @param factor
	 */
	
	private void generateCombinations(List<InterfaceTreatment<?>> combination, InterfaceFactor<?> factor) {
		for (InterfaceTreatment<?> treatment : factor.getTreatments()) {
			List<InterfaceTreatment<?>> miniList = new ArrayList<InterfaceTreatment<?>>(combination);
			miniList.add(treatment);
		}
	}
	
	/**
	 * Initialize the combinatedList with a list for each treatment
	 * of the first factor.
	 * 
	 * @return The list initialized
	 */
	
	private List<List<InterfaceTreatment<?>>> initializeList() {
		List<List<InterfaceTreatment<?>>> combinatedList = new ArrayList<List<InterfaceTreatment<?>>>();
		
		for (InterfaceTreatment<?> treatment : super.getFactors().get(0).getTreatments()) {
	    	List<InterfaceTreatment<?>> treatments = new ArrayList<InterfaceTreatment<?>>();
	    	
	    	treatments.add(treatment);
	    	combinatedList.add(treatments);
	    }
	    
	    return combinatedList;
	}
}