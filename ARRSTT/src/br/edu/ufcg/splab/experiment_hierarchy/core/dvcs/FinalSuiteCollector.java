package br.edu.ufcg.splab.experiment_hierarchy.core.dvcs;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class FinalSuiteCollector implements InterfaceDvc {

	@Override
	public StringBuffer collect(TestSuite t) {
		return new StringBuffer(t.toString());
	}

}
