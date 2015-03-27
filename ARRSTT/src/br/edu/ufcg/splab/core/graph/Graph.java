/*
 * @(#)Graph.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                 06/02/2012    
 */
package br.edu.ufcg.splab.core.graph;


import java.util.UUID;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.core.edges.Edge;
import br.edu.ufcg.splab.core.edges.EdgeType;
import br.edu.ufcg.splab.core.vertex.Vertex;
import br.edu.ufcg.splab.exceptions.GraphException;




/**
 * 
 * Class to represent a graph. 
 * @see abstracts.AbstractGraph
 * 
 * */
public class Graph extends AbstractGraph{

	/**
	 * Constructor
	 * @see abstracts.AbstractGraph
	 * 
	 */
	public Graph() {
		super();
	}
	
	/**
	 *
	 *Adds a vertex in graph with specified label
	 *@return UUID
	 */
	//TODO

	public UUID addVertex(String label) {

		InterfaceVertex v = new Vertex(label);

		if (getStates().size() == 0) {
			setRoot(v);
			this.getStates().put(v.getUUID(), v);
		}

		this.getStates().put(v.getUUID(), v);
		return v.getUUID();
	}
	
	/**
	 *
	 * Create edge between the vertices specified with respective labelEdge
	 * and adds edge in graph
	 * @throws Exception
	 */
	public void createEdge(UUID from, UUID to, String labelEdge, EdgeType tipo) throws GraphException{
		InterfaceVertex vFrom = getStates().get(from);
		InterfaceVertex vTo = getStates().get(to);
		
//		System.out.println("vf "+vFrom);
//		System.out.println("vt "+vTo);
		if(vFrom==null || vTo==null){
			throw new NullPointerException("State was not specified for edge: '"+labelEdge+"'");
		}
		InterfaceEdge edge = new Edge(vFrom, labelEdge, vTo,tipo);
		vFrom.addEdgeOutTransitions(edge);
		vTo.addEdgeInTransitions(edge);
		this.getEdges().add(edge);
		
	}
	
	/**
	 * Removes a single transition form the graph. If the sink state of
	 * the transition is left disconnected, then it will also be removed to
	 * avoid disconnected vertex.  
	 * @param transition The transition that needs to be removed.
	 * @return a boolean value indicating if the removal was successful performed.
	 */
	public boolean removeTransition(InterfaceEdge transition){
		if(getEdges().contains(transition)){
			transition.getFrom().getOutTransitions().remove(transition);
			transition.getTo().getInTransitions().remove(transition);
			getEdges().remove(transition);
			
			//disconnected vertex.
			if(transition.getTo().getInTransitions().isEmpty()){
				getStates().remove(transition.getTo().getUUID());
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		System.out.println(g.getRoot());
		Vertex v = new Vertex("a");
		g.addVertex("a");
		g.addVertex("a");
		//g.setRoot(v);
		System.out.println(g.getRoot());
		//g.setRoot(v);
		System.out.println(g.getStates().size());
		
	}

	
}
