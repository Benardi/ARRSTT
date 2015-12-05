package br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.builders;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.requirements.ARRSTTTestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

public class ATCoverage implements RequirementBuilder {
	private TestSuite testSuite;
	
	public ATCoverage(TestSuite testSuite) {
		this.testSuite = testSuite;
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
