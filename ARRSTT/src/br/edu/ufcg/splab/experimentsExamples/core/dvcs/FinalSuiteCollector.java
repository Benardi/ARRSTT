package br.edu.ufcg.splab.experimentsExamples.core.dvcs;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;

/**
 * This DVC is responsible for saving the result of a
 * TestSuite's toString method.
 */
public class FinalSuiteCollector implements IDvc {

	@Override
	public StringBuffer collect(TestSuite t) {
		return new StringBuffer("----- " + "NEW TEST SUITE" + " -----" + t.toString());
	}
	
	@Override
	public String getName(){
		return "Final Suite";
	}

}
