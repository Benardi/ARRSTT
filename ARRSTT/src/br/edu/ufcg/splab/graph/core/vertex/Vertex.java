/*
 * @(#)Vertex.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                     03/02/2012    
 */
package br.edu.ufcg.splab.graph.core.vertex;




/**
 * Class Vertex
 *
 *@see abstracts.AbstractVertex
 */

public class Vertex extends AbstractVertex{

	/**
	 * 
	 * Constructor
	 * @see abstracts.AbstractVertex
	 */
	
	public Vertex(String label) {
		super(label);
	}

	@Override
	public boolean equals(Object o) {
		boolean resp = false;
		if(o instanceof Vertex){
			Vertex vertex = (Vertex) o;
			if(this.getUUID().equals(vertex.getUUID())){
				resp = true;
			}
		}
		return resp;
	}
	
}
