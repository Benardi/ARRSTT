/*
 * @(#)InterfaceGraph.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                  08/02/2012    
 */
package br.edu.ufcg.splab.graph_hierarchy.core;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * Interface to represent a graph. 
 * 
 **/
public interface InterfaceGraph {
	
	public InterfaceVertex getRoot();
	public List<InterfaceEdge> getEdges();
	public Map<UUID,InterfaceVertex> getStates();
	//public List<InterfaceVertex> getStates();

}
