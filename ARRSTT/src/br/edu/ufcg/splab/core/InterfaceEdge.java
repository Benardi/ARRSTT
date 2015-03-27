/*
 * @(#)InterfaceEdge.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                     03/02/2012    
 */
package br.edu.ufcg.splab.core;
import java.util.UUID;

import br.edu.ufcg.splab.core.edges.EdgeType;



/**
 * Interface to represent a directed edge. 
 * 
 **/
public interface InterfaceEdge {
	
	public String getLabel();
	public void setLabel(String label);
	public InterfaceVertex getFrom();
	public InterfaceVertex getTo();
	public void setFrom(InterfaceVertex from);
	public void  setTo(InterfaceVertex to);
	public UUID getUUID();
	public EdgeType getTipo();
	public void setTipo(EdgeType tipo);
}
