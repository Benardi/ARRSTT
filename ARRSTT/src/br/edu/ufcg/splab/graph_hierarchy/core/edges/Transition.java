/*
 * @(#)Edge.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                     03/02/2012    
 */
package br.edu.ufcg.splab.graph_hierarchy.core.edges;

import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;



/**
 * 
 * Class to represent a edge. 
 * @see abstracts.AbstractEdge
 * 
 * */

public class Transition extends AbstractEdge {
	

	/**
	 * 
	 * Constructor
	 * @see abstracts.AbstractEdge
	 * 
	 * */
	public Transition(InterfaceVertex from, String label, InterfaceVertex to,TransitionType tipo) {
		super(from, label, to, tipo);
	}
	
	/**
	 * 
	 * Verify if this edge is equal to a specified edge. 
	 * 
	 */	
	@Override
	public boolean equals(Object o) {
		boolean retorno = false;

		if (o instanceof Transition) {
			Transition edge = (Transition) o;

			if (edge.getLabel().equals(this.getLabel())
					&& edge.getFrom().equals(this.getFrom())
					&& edge.getTo().equals(this.getTo())) {
				retorno = true;
			}
		}
		return retorno;
	}

}
