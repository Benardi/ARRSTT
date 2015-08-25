package br.edu.ufcg.splab.trash;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract implementation of a combinator. Uses a list
 * of factors. 
 *
 */
public abstract class AbstractCombinator {
private List<InterfaceFactor> factors;
	
	/**
	 * Build a combinator with a list of factors.
	 * 
	 * @param factors
	 * 		The list of factors that the combinator will combine.
	 */
	public AbstractCombinator(List<InterfaceFactor> factors) {
		this.factors = factors;
	}
	
	/**
	 * Set the list of factors to a new list.
	 * 
	 * @param factors
	 * 		The new list of factors.
	 */
	public void setFactors(List<InterfaceFactor> factors) {
		this.factors = factors;
	}
	
	/**
	 * Get the current list of factors.
	 * 
	 * @return
	 * 		The list of factors the object is holding.
	 */
	public List<InterfaceFactor> getFactors() {
		return new ArrayList<InterfaceFactor>(factors);
	}
}
