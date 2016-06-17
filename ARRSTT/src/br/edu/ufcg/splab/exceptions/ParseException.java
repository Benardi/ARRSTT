/*
 * @(#)ParseException.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                     03/02/2012    
 */
package br.edu.ufcg.splab.exceptions;

import br.edu.ufcg.splab.graph_hierarchy.exceptions.LTSBTException;

/**
 *
 **/
public class ParseException extends LTSBTException {
	private static final long serialVersionUID = 2096559636965507877L;


	public ParseException(){
		super("And error has occured in ParseException.");
	}

	
	public ParseException(String message) {
		super(message);
	}

}