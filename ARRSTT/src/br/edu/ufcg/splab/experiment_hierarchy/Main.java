package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.experiment_rep.SelectionExperiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiment_rep.TeamExperiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.setup.ExperimentSetUpInterface;
import br.edu.ufcg.splab.experiment_hierarchy.core.setup.ExperimentSetUpSearches;
import br.edu.ufcg.splab.experiment_hierarchy.core.setup.ExperimentSetUpSelection;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.graph_maskarator.RandomMaskarator;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.parser.ReadTGF;

public class Main {

	public static void main(String[] args) throws Exception {
		runGeneration();
	}
	
	public static void runGeneration() {
		try {
			int[] loopCoverages = { 1, 4, 7 };
			TeamExperiment experiment = new TeamExperiment();
			ExperimentSetUpSearches combinator = new ExperimentSetUpSearches(experiment.getGraphs(), loopCoverages);
			List<Tuple<ExecutableTreatment>> combinations = combinator.getIndependentVariables();
			experiment.runExperiment(combinations);
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public static void runSelection() {
		try {
			SelectionExperiment experiment = new SelectionExperiment();
			// Receber test suites como parâmetros ao invés de grafos.
			ExperimentSetUpInterface combinator = new ExperimentSetUpSelection(loadGraphs(), new RandomMaskarator(), 0.4, 0.4);
			experiment.runExperiment(combinator.getIndependentVariables());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static List<InterfaceGraph> loadGraphs() throws Exception{
		List<InterfaceGraph> allGraphs = new ArrayList<>();
		
		File[] folder = new File("input_examples/").listFiles();
		ReadTGF tgfReader = new ReadTGF();
		for (File file : folder) {
			InterfaceGraph graph = tgfReader.getGraph(file.getAbsolutePath());
			allGraphs.add(graph);
		}
		
		return allGraphs;
	}

}
