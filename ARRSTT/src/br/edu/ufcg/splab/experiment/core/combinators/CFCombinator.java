package br.edu.ufcg.splab.experiment.core.combinators;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	/**
	 * Generate all the possible combinations for the treatments.
	 * 
	 * @return A list with n-tuples, each one a combination 
	 */
	
	public List<List<InterfaceTreatment<?>>> combine() {
		Iterator<InterfaceFactor<?>> iterator = super.getFactors().iterator();
	    combinatedList = initializeList();
	    
	    while (iterator.hasNext()) 
	    	combineFactor(iterator.next());
	    
	    return combinatedList;
	}
	
	/**
	 * After the list(the list inside the combinatedList) is expanded
	 * delete the previous state of it.
	 * 
	 * @param factor
	 */
	
	private void combineFactor(InterfaceFactor<?> factor) {
		Iterator<List<InterfaceTreatment<?>>> iterator = combinatedList.iterator();
		int loopEnd = combinatedList.size();
		
		while (iterator.hasNext())
			generateCombinations(iterator.next(), factor);
		
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