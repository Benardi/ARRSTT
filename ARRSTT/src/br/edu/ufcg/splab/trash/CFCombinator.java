package br.edu.ufcg.splab.trash;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;

/**
 * This is a complete factorial combinator. This means that
 * it will generate all possible combinations for the treatments. 
 *
 */

public class CFCombinator extends AbstractCombinator {
    private List<List<ExecutableTreatment>> combinatedList;
	
	/**
	 * Build a new combinator with a list of super.getFactors(). 
	 * 
	 * @param super.getFactors()
	 * 		The list of super.getFactors() which the treatments are in.
	 */
 
	public CFCombinator(List<InterfaceFactor> factors) {
		super(factors);
	}
	
	public CFCombinator() {
		super(new ArrayList<InterfaceFactor>());
	}
	
	/**
	 * Generate all the possible combinations for the treatments.
	 * 
	 * @return A list with n-tuples, each one a combination 
	 */
	public List<List<ExecutableTreatment>> combine() {
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
	private void combineFactor(InterfaceFactor factor) {
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
	private void generateCombinations(List<ExecutableTreatment> combination, InterfaceFactor factor) {
		for (ExecutableTreatment treatment : factor.getTreatments()) {
			List<ExecutableTreatment> miniList = new ArrayList<ExecutableTreatment>(combination);
			miniList.add(treatment);
		}
	}
	
	/**
	 * Initialize the combinatedList with a list for each treatment
	 * of the first factor.
	 * 
	 * @return The list initialized
	 */
	private List<List<ExecutableTreatment>> initializeList() {
		List<List<ExecutableTreatment>> combinatedList = new ArrayList<List<ExecutableTreatment>>();
		
		for (ExecutableTreatment treatment : super.getFactors().get(0).getTreatments()) {
	    	List<ExecutableTreatment> treatments = new ArrayList<ExecutableTreatment>();
	    	
	    	treatments.add(treatment);
	    	combinatedList.add(treatments);
	    }
	    
	    return combinatedList;
	}
}
