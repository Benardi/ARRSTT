/*
 * @(#)AbstractEdge.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                     03/02/2012    
 */
package br.edu.ufcg.splab.graph.core.edges;



import java.util.UUID;

import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.graph.core.InterfaceVertex;



	/**
	 * Class to represent a directed edge. 
	 *  
	 * CLASS:
	 * 	Class to represent a directed edge between two vertexes in a graph..
	 *
	 * -> Establish a connection between two vertex.
	 * -> Represent an edge from a directed graph.
	 *
	 * COLABORATORS: 
	 * -> Used in the Graph as a connection between two vertexes.
	 *
	 * USAGE:
	 * -> To retrive the origin of the edge: getFrom().
	 * -> To retrive the label of the edge: getLabel().
	 * -> To retrive the destiny of the edge: getTo().
	 * 
	 **/

public abstract class AbstractEdge implements InterfaceEdge {
	
	/**
	 * The origin vertex of the edge.
	 * */
	private InterfaceVertex from;
	/**
	 * The edge's label.
	 */
	private String label;
	/**
	 * The destiny vertex of the edge.
	 * */
	private InterfaceVertex to;
	/**
	 * The id of the edge.
	 */
	private UUID uuid;
	
	/**
	 * 
	 */
	private TransitionType tipo;
	
	
	/**
	 * Constructor
	 * Create a directed edge between two vertexes of the graph.
	 * 
	 * @param from The origin vertex of the edge.
	 * @param label The edge's label.
	 * @param to The destiny vertex of the edge.
	 */
	
	public AbstractEdge(InterfaceVertex from, String label, InterfaceVertex to, TransitionType tipo){
		this.from=from;
		this.label=label;
		this.to=to;
		this.uuid = UUID.randomUUID();
		this.tipo = tipo;
	}
	
	
	/*
	 * 
	 * Gets and Sets.
	 * 
	 */
	public InterfaceVertex getFrom() {
		return from;
	}
	public void setFrom(InterfaceVertex from) {
		this.from = from;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public InterfaceVertex getTo() {
		return to;
	}
	public void setTo(InterfaceVertex to) {
		this.to = to;
	}
	public UUID getUUID(){
		return this.uuid;
	}
	
	public void setType(TransitionType tipo){
		this.tipo = tipo;
	}
	public TransitionType getType(){
		return this.tipo;
	}

	
	/**
	 * Retrieve a string representation of the edge.
	 * The string follows the .aut standard format:
	 * <tt>([origin's label], "[edge's label]", [destiny's label])</tt>
	 * @return a string representation of the edge. 
	 */
	public String toString() 
	{
		if (this.getFrom() == null && this.getTo() == null) {
			//Star label's string representation.
			return "(*,\"" + this.getLabel() + "\",*)";
		}
		return "(" + this.getFrom().getLabel() + ",\"" + this.getLabel() + "\"," + this.getTo().getLabel() + ") ";
		//return label;
	}
	
	public abstract boolean equals(Object o);
}
