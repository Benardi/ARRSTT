package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms.EAlgorithm;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms.GAlgorithm;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms.HAlgorithm;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms.InterfaceMinimizationAlgorithm;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms.REAlgorithm;

public class MinimizationAlgorithmFactory {
	public InterfaceMinimizationAlgorithm createGreedyAlgorithm() {
		return new GAlgorithm();
	}
	
	public InterfaceMinimizationAlgorithm createEssentialAlgorithm() {
		return new EAlgorithm();
	}
	
	public InterfaceMinimizationAlgorithm createEssentialRedundantAlgorithm() {
		return new REAlgorithm();
	}
	
	public InterfaceMinimizationAlgorithm createHarroldAlgorithm() {
		return new HAlgorithm();
	}
}
