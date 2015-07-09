package br.edu.ufcg.splab.experiment;

import br.edu.ufcg.splab.experiment.core.experiments.TeamExperiment;

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
