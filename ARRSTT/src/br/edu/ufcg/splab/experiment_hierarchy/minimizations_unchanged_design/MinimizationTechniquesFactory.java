package br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.techniques.EssentialTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.techniques.GreedyTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.techniques.Harrold;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.techniques.OneToOneRedundantEssentialTechnique;

public class MinimizationTechniquesFactory {
	public InterfaceMinimizationTechnique createGreedyTechnique(MinimizationStructure structure) {
		return new GreedyTechnique(structure);
	}
	
	public InterfaceMinimizationTechnique createEssentialTechnique(MinimizationStructure structure) {
		return new EssentialTechnique(structure);
	}
	
	public InterfaceMinimizationTechnique createOneToOneRedundantEssentialTechnique(MinimizationStructure structure) {
		return new OneToOneRedundantEssentialTechnique(structure);
	}
	
	public InterfaceMinimizationTechnique createHarroldTechnique(MinimizationStructure structure) {
		return new Harrold(structure);
	}
}
