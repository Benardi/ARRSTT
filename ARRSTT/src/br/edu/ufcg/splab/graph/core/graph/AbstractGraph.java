/*
 * @(#)AbstractGraph.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                 08/02/2012    
 */
package br.edu.ufcg.splab.graph.core.graph;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.core.InterfaceVertex;



/**
 * A class that represents a graph.
 *
 *  
 * CLASS:
 * This graph is used to generate test cases with purpose.
 *
 * RESPONSIBILITIES:
 * 	-> It has the behavior of a common graph. 
 * 	-> It contains collections of vertexes and edges, to establish its structure. 
 *
 * COLABORATORS: 
 *	-> Edges and Vertexes are elements of the graph, used to define paths and matching purposes.
 *
 * USAGE:
 *	-> This class is used to provide a representation of the LTS graph.
 *	
 **/


public abstract class AbstractGraph implements InterfaceGraph{

	/**
	 * A map of the vertex of the graph.
	 * The key is the UUID and value is a vertex.
	 */
	private Map<UUID,InterfaceVertex> states;
	
	/**
	 * A list of the edges of the graph.
	 */
	private List<InterfaceEdge> edges;
	
	/**
	 * The root of the graph.
	 */
	private InterfaceVertex root;
	
	
	/**
	 * Constructor
	 * Create a graph.
	 * 
	 */
	public AbstractGraph() {
		this.setStates(new HashMap<UUID,InterfaceVertex>());
		this.setEdges(new ArrayList<InterfaceEdge>());
	}
	
	//TODO vai ficar assim ou cria os metodos setStates e setEdges
//	public AbstractGraph(HashMap<UUID, InterfaceVertex> states,List<InterfaceEdge> edges, InterfaceVertex root){
//		this.setStates(states);
//		this.setEdges(edges);
//		this.root = root;
//	}
	
	
	
	/*
	 * 
	 * Gets and Sets.
	 * 
	 */
	
	
	

//	public List<InterfaceVertex> getStates() {
//		return new ArrayList<InterfaceVertex>(states.values());
//	}
	
	public InterfaceVertex getRoot(){
		return this.root;
	}
	public void setRoot(InterfaceVertex newRoot){
		this.root = newRoot;
		//if(!getStates().values().contains(root)){	
		//	this.getStates().put(newRoot.getUUID(), newRoot);
		//}
	}


	public void setStates(Map<UUID,InterfaceVertex> states) {
		this.states = states;
	}
	public Map<UUID,InterfaceVertex> getStates() {
		return states;
	}
	public void setEdges(List<InterfaceEdge> edges) {
		this.edges = edges;
	}
	public List<InterfaceEdge> getEdges() {
		return edges;
	}
	
	
	
	
}
