package br.edu.ufcg.splab.experimentsExamples.techniques.minimization.factories;

import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.builders.RequirementBuilder;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.requirements.TestRequirement;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.techniques.GETechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.techniques.GRETechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.techniques.GTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.techniques.HTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.techniques.InterfaceMinimizationTechnique;

public class MinimizationTechniquesFactory {
	public InterfaceMinimizationTechnique createMinimizationTechnique(MinimizationTechniques type, TestSuite testSuite, List<TestRequirement> requirements) {
		if (type == MinimizationTechniques.G) {
			return createGTechnique(testSuite, requirements);
		} else if (type == MinimizationTechniques.GE) {
			return createGETechnique(testSuite, requirements);
		} else if (type == MinimizationTechniques.GRE) {
			return createGRETechnique(testSuite, requirements);
		} else if (type == MinimizationTechniques.H) {
			return createHTechnique(testSuite, requirements);
		}
		
		return null;
	}
	
	public InterfaceMinimizationTechnique createMinimizationTechnique(MinimizationTechniques type, TestSuite testSuite, RequirementBuilder builder) {
		return createMinimizationTechnique(type, testSuite, builder.getRequirements());
	}
	
	public InterfaceMinimizationTechnique createGTechnique(TestSuite testSuite, RequirementBuilder builder) {
		return new GTechnique(testSuite, builder.getRequirements());
	}
	
	public InterfaceMinimizationTechnique createGTechnique(TestSuite testSuite, List<TestRequirement> requirements) {
		return new GTechnique(testSuite, requirements);
	}
	
	public InterfaceMinimizationTechnique createGETechnique(TestSuite testSuite, RequirementBuilder builder) {
		return new GETechnique(testSuite, builder.getRequirements());
	}
	
	public InterfaceMinimizationTechnique createGETechnique(TestSuite testSuite, List<TestRequirement> requirements) {
		return new GETechnique(testSuite, requirements);
	}
	
	public InterfaceMinimizationTechnique createGRETechnique(TestSuite testSuite, RequirementBuilder builder) {
		return new GRETechnique(testSuite, builder.getRequirements());
	}
	
	public InterfaceMinimizationTechnique createGRETechnique(TestSuite testSuite, List<TestRequirement> requirements) {
		return new GRETechnique(testSuite, requirements);
	}
	
	public InterfaceMinimizationTechnique createHTechnique(TestSuite testSuite, RequirementBuilder builder) {
		return new HTechnique(testSuite, builder.getRequirements());
	}
	
	public InterfaceMinimizationTechnique createHTechnique(TestSuite testSuite, List<TestRequirement> requirements) {
		return new HTechnique(testSuite, requirements);
	}
}
