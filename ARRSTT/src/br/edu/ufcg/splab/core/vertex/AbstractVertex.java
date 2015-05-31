/*
 * @(#)AbstractVertex.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                     03/02/2012    
 */
package br.edu.ufcg.splab.core.vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceVertex;

/**
 * A class that represents a graph's vertex.
 * 
 *  
 * CLASS:
 * This vertex is used in the graph built to generate a test case with purpose.
 *
 * RESPONSIBILITIES:
 * 	-> It has the behavior of a common vertex, in a graph. 
 *
 * COLABORATORS: 
 *	-> This vertex is used as an element of a Graph.
 *	-> This vertex is used to represent a vertex in a LTS graph, so it contains a label.
 *
 * USAGE:
 *	-> This class is used to generate a test case with purpose. 
 *	
 **/

public abstract class AbstractVertex implements InterfaceVertex{

	/**
	 * The vertex's label.
	 */
	private String label;
	/**
	 * The list of edges that enters this vertex.
	 */
	private List<InterfaceEdge> inTransitions;
	/** 
	 * A list of edges that out this vertex.
	 */
	private List<InterfaceEdge> outTransitions;
	/**
	 * The id
	 */
	private UUID uuid;
	
	
	/**
	 * Constructor
	 * Create a vertex with the specified label.
	 * 
	 * @param label Vertex's label.
	 */
	public AbstractVertex(String label){
		this.label = label;
		this.inTransitions = new ArrayList<InterfaceEdge>();
		this.outTransitions = new ArrayList<InterfaceEdge>();
		this.uuid = UUID.randomUUID();
	}

	
	
	/**
	 * 
	 * Adds an edge in list of inTransitions.
	 */
	
	public void addEdgeInTransitions(InterfaceEdge edge){
		this.inTransitions.add(edge);
	}
	
	/**
	 * 
	 * Adds an edge in list of outTransitions.
	 */
	public void addEdgeOutTransitions(InterfaceEdge edge){
		this.outTransitions.add(edge);
	}
	
	/**
	 * 
	 * Return true if the vertex is a leaf or false otherwise.
	 */
	public boolean isLeaf(){
		return getOutTransitions().size() == 0;
	}
	
	/*
	 * Gets and Sets.
	 */	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<InterfaceEdge> getInTransitions() {
		return inTransitions;
	}
	public List<InterfaceEdge> getOutTransitions() {
		return outTransitions;
	}
	public UUID getUUID(){
		return this.uuid;
	}
	
	public String toString(){
		return this.label;
	}
	
	public abstract boolean equals(Object o);
	
	/*
	public int compareTo(AbstractVertex v){
		//Possible exception when labels are not integer values.
		try{
			int thisLabel = Integer.valueOf(this.label);
			int otherLabel = Integer.valueOf(v.getLabel());
			if(thisLabel > otherLabel){
				return 1;
			}else if(thisLabel == otherLabel){
				return 0;
			
			}else{
				return -1;
			}
		
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
	*/
}
