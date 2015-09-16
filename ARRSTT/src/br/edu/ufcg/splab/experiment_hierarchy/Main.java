package br.edu.ufcg.splab.experiment_hierarchy;

import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;

public class Main {

	public static void main(String[] args) throws Exception {
		ExperimentFactory factory = new ExperimentFactory();
		try {
			Experiment experiment = factory.buildArrsttGeneration();
			experiment.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
