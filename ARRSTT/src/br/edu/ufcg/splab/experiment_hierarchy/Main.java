package br.edu.ufcg.splab.experiment_hierarchy;

import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;

public class Main {

	public static void main(String[] args) throws Exception {
		ExperimentFactory factory = new ExperimentFactory();
		try {
			int[] loopCoverages = { 1, 4, 7 };
			GenerationType[] generationAlgorithms = {GenerationType.BFS, GenerationType.DFS};
			Experiment experiment = factory.buildGeneration(loopCoverages, generationAlgorithms);
			experiment.execute();
			
			SelectionType[] selectionAlgorithms = {SelectionType.BIGGEST, SelectionType.SIMILARITY, SelectionType.RANDOMIZED};
			experiment = factory.buildSelection(selectionAlgorithms);
			experiment.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
