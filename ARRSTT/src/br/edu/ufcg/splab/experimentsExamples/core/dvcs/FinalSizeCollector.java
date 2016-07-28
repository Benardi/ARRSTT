package br.edu.ufcg.splab.experimentsExamples.core.dvcs;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;

/**
 * This DVC saves a TestSuite's size
 */
public class FinalSizeCollector implements IDvc {

	@Override
	public StringBuffer collect(TestSuite testSuite) {
		return new StringBuffer(testSuite.size() + "");
	}

	@Override
	public String toString() {
		return "DV Size";
	}
	
	@Override
	public String getName(){
		return "Final Size";
	}
}
