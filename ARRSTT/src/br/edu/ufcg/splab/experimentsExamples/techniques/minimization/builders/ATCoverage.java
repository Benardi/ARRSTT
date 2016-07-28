package br.edu.ufcg.splab.experimentsExamples.techniques.minimization.builders;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.requirements.ARRSTTTestRequirement;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.requirements.TestRequirement;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;

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
