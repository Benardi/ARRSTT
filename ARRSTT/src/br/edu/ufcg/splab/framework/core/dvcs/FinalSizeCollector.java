package br.edu.ufcg.splab.framework.core.dvcs;

import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

/**
 * This DVC saves a TestSuite's size
 */
public class FinalSizeCollector implements InterfaceDvc {

	@Override
	public StringBuffer collect(TestSuite testSuite) {
		return new StringBuffer(testSuite.size() + "");
	}

	@Override
	public String toString() {
		return "DV Size";
	}
}
