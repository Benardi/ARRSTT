package br.edu.ufcg.splab.experiment_hierarchy.minimizations.factories;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.builders.RequirementBuilder;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.GETechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.GRETechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.GTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.HTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class MinimizationTechniquesFactory {
	public InterfaceMinimizationTechnique createMinimizationTechnique(MinimizationType type, TestSuite testSuite, List<TestRequirement> requirements) {
		if (type == MinimizationType.GREEDY) {
			return createGTechnique(testSuite, requirements);
		} else if (type == MinimizationType.GREEDY_ESSENCIAL) {
			return createGETechnique(testSuite, requirements);
		} else if (type == MinimizationType.GREEDY_ESSENCIAL_REDUNDANT) {
			return createGRETechnique(testSuite, requirements);
		} else if (type == MinimizationType.HARROLD) {
			return createHTechnique(testSuite, requirements);
		}
		
		return null;
	}
	
	public InterfaceMinimizationTechnique createMinimizationTechnique(MinimizationType type, TestSuite testSuite, RequirementBuilder builder) {
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
