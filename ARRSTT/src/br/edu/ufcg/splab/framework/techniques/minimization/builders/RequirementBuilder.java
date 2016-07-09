package br.edu.ufcg.splab.framework.techniques.minimization.builders;

import java.util.List;

import br.edu.ufcg.splab.framework.techniques.minimization.requirements.TestRequirement;



public interface RequirementBuilder {
	public List<TestRequirement> getRequirements();
}
