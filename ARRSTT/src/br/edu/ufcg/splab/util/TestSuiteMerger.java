package br.edu.ufcg.splab.util;

import java.util.List;

import br.edu.ufcg.splab.util.testcollections.TestCase;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class TestSuiteMerger {
	
	public TestSuiteMerger(){
		
	}
	
	public TestSuite merge(List<TestSuite> list){
		TestSuite result = new TestSuite();
		for(TestSuite ts: list){
			for(TestCase tc : ts.getTestSuite()){
				result.add(tc);
			}
		}
		return result;
	}

}
