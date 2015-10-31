package br.edu.ufcg.splab.experiment_hierarchy.minimizations.builders;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;

public interface RequirementBuilder {
	public List<TestRequirement> getRequirements();
}
