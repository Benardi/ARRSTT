package br.edu.ufcg.splab.framework.core.dvcs;

import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class FinalSuiteCollector implements InterfaceDvc {

	@Override
	public StringBuffer collect(TestSuite t) {
		return new StringBuffer("----- " + "NEW TEST SUITE" + " -----" + t.toString());
	}

}
