package br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.builders;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.requirements.TestRequirement;



public interface RequirementBuilder {
	public List<TestRequirement> getRequirements();
}
