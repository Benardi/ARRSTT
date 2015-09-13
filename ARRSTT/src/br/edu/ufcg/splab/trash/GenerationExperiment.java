package br.edu.ufcg.splab.trash;

import java.io.IOException;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.BranchSeparator;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentFile;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;

/**
 * This is the class that should execute the specific experiment made on the
 * ARRSTT project.
 */
public class GenerationExperiment {
	public static final String LINE_END = System.getProperty("line.separator");

	/**
	 * This object is used to produce a list of graphs with the same amount of
	 * low on branch graphs and high on branch graphs.
	 */
	private BranchSeparator separator;
	/**
	 * The list of graphs to be evaluated by the experiment. This list is filled
	 * with the output of the separator.
	 */
	private List<InterfaceGraph> graphs;
	
	/**
	 * The file cointaining the time data of the executions
	 */
	private ExperimentFile timeFile;
	/**
	 * The file containing the sizes of the Test Suites generated
	 */
	private ExperimentFile tsSizeFile;
	
	private DependentVariableCollector dvc;

	/**
	 * Build a new TeamExperiment passing all the loop coverages.
	 * 
	 * @param loopCoverages
	 *            The loop coverages in which the searches will run.
	 * @throws Exception
	 */
	public GenerationExperiment() throws Exception {
		this.dvc = new GenerationCollector();
		this.separator = new BranchSeparator();
		this.graphs = separator.getGraphsToRun();
		this.timeFile = new ExperimentFile("Times");
		this.tsSizeFile = new ExperimentFile("Sizes");
	}

	/**
	 * This method takes care of generating all the output data of this
	 * particular experiment.
	 * 
	 * @throws Exception
	 */
	public void runExperiment(List<Tuple<ExecutableTreatment>> combinations)
			throws Exception {

		int count = 0;
		for (Tuple<ExecutableTreatment> combination : combinations) {
			for (ExecutableTreatment treatment : combination) {
				dvc.collect(treatment);
				
				// Probably will go to formatter later.
				count += 1;
				if (count == 6) {
					timeFile.appendContent(LINE_END);
					tsSizeFile.appendContent(LINE_END);
					count = 0;
				}
			}
		}

		saveFiles();
	}

	private void saveFiles() throws IOException {
		timeFile.save();
		tsSizeFile.save();
	}

	public List<InterfaceGraph> getGraphs() {
		return graphs;
	}
}
