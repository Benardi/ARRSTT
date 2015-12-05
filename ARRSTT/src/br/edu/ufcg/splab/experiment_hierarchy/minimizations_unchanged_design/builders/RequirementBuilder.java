package br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.builders;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.requirements.TestRequirement;

public interface RequirementBuilder {
	public List<TestRequirement> getRequirements();
}
