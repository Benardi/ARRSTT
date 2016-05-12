package br.edu.ufcg.splab.experiment_hierarchy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;

public class Main {

	public static void main(String[] args) throws Exception {
		ExperimentFactory factory = new ExperimentFactory();
		try {
			//int[] loopCoverages = { 1, 4, 7 };
			//GenerationType[] generationAlgorithms = {GenerationType.BFS, GenerationType.DFS};
			//Experiment experiment = factory.buildGeneration(loopCoverages, generationAlgorithms);
			//experiment.execute();
			
			//SelectionType[] selectionAlgorithms = {SelectionType.BIGGEST, SelectionType.SIMILARITY, SelectionType.RANDOMIZED};
			List<SelectionType> selectionTechniques = new ArrayList<SelectionType>();
			selectionTechniques.add(SelectionType.BIGGEST);
			selectionTechniques.add(SelectionType.SIMILARITY);
			selectionTechniques.add(SelectionType.RANDOMIZED);
			
			DVCType[] dvcs = {DVCType.FAILURES, DVCType.DEFECTS, DVCType.DEFECTIVE_EDGES, DVCType.SIZE};
			List<DVCType> dvcsForSelection = new ArrayList<DVCType>(Arrays.asList(dvcs));
			
			
			Experiment experiment = factory.buildSelection(selectionTechniques, 1, dvcsForSelection);
			experiment.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
