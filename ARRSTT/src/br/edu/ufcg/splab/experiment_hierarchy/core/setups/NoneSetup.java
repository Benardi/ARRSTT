package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.NoneTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class NoneSetup implements InterfaceSetup{
	private List<TestSuite> testSuites;
	
	public NoneSetup(List<TestSuite> testSuites){
		this.testSuites = testSuites;
	}
	
	
	@Override
	public List<Tuple<ExecutableTreatment>> getArtifacts() {
		List<Tuple<ExecutableTreatment>> tuples = new ArrayList<>();
		for(TestSuite ts: testSuites){
			Tuple<ExecutableTreatment> t = new Tuple<>();
			t.add(new NoneTreatment(ts));
			tuples.add(t);
		}
		return tuples;
	}

}
