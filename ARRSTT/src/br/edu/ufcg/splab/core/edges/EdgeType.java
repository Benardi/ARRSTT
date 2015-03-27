/*
 * @(#)Tipo.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                    14/11/2012    
 */

package br.edu.ufcg.splab.core.edges;


public enum EdgeType {
	DEFAULT("default"),
	STEPS("steps"),
	CONDITIONS("conditions"),
	EXPECTED_RESULTS("expected_results");
	
	String str;
	
	private EdgeType(String str) {
		this.str = str;
	}

	public String getStrTipo() {
		return str;
	}

	public static EdgeType getInstance(String str) {
		for (EdgeType t : values()) {
			if (t.getStrTipo().equals(str.toLowerCase())) {
				return t;
			}
		}
		return null;
	}
}


