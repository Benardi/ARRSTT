package br.edu.ufcg.splab.framework.techniques.minimization.builders;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.framework.techniques.minimization.requirements.ARRSTTTestRequirement;
import br.edu.ufcg.splab.framework.techniques.minimization.requirements.TestRequirement;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.util.testcollections.TestCase;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class ATCoverage implements RequirementBuilder {
	private TestSuite testSuite;
	
	public ATCoverage(TestSuite ortestSuite) {
		
		this.testSuite = new TestSuite(ortestSuite);
	}

	@Override
	public List<TestRequirement> getRequirements() {
		List<TestRequirement> requirements = new ArrayList<TestRequirement>();
		
		for (TestCase testCase : testSuite) {
			for (InterfaceEdge edge : testCase) {
				requirements.add(new ARRSTTTestRequirement(edge));
			}
		}
		
		return requirements;
	}
	
	
}
