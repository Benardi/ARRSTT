package br.edu.ufcg.splab.experimentsExamples.util.factories;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.builders.APCoverage;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.builders.ATCoverage;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.builders.RequirementBuilder;
import br.edu.ufcg.splab.experimentsExamples.util.enums.RequirementBuilders;


public class RequirementBuilderFactory {
	public RequirementBuilder createRequirementBuilder(TestSuite testSuite, RequirementBuilders enumReq) {
		if (enumReq == RequirementBuilders.APCoverage) {
			return createAPBuilder(testSuite);
		} else if (enumReq == RequirementBuilders.ATCoverage) {
			return createATBuilder(testSuite);
		} else {
			return null;
		}
	}
	
	public RequirementBuilder createATBuilder(TestSuite testSuite) {
		return new ATCoverage(testSuite);
	}
	
	public RequirementBuilder createAPBuilder(TestSuite testSuite) {
		return new APCoverage(testSuite);
	}
}
