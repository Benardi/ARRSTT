package br.edu.ufcg.splab.experiment_hierarchy.core;

import br.edu.ufcg.splab.experiment_hierarchy.core.experiment_rep.TeamExperiment;

public class Main {
	public static void main(String[] args) {
		int[] loopCoverage = {1, 5, 7};
				
		try {
			TeamExperiment myExperiment = new TeamExperiment(loopCoverage);
			myExperiment.runExperiment();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
