/*
 * @(#)InterfaceVertex.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                     03/02/2012    
 */
package br.edu.ufcg.splab.graph.core;
import java.util.List;
import java.util.UUID;

/**
 * Interface to represent a vertex 
 * 
 **/
public interface InterfaceVertex {
	
	public String getLabel();
	public void setLabel(String label);
	public List<InterfaceEdge> getOutTransitions();
	public List<InterfaceEdge> getInTransitions();
	public void addEdgeOutTransitions(InterfaceEdge edge);
	public void addEdgeInTransitions(InterfaceEdge edge);
	public boolean isLeaf();
	public UUID getUUID();
	
	
}
