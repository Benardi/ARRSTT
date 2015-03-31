package br.edu.ufcg.splab.util;

import java.util.List;

import br.edu.ufcg.splab.core.InterfaceEdge;

public class TestCase {
	
	List<InterfaceEdge> tCase;
	
	
	public TestCase(List<InterfaceEdge> tCase){
		this.tCase = tCase;
	}
	
	public List<InterfaceEdge> getTestCase(){
		return tCase;
	}

}
