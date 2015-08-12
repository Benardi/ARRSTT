package br.edu.ufcg.splab.experiment_hierarchy;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.experiment_rep.TeamExperiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.setup.ExperimentSetUpSearches;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

public class Main {

	public static void main(String[] args) throws Exception {

		int[] loopCoverages = { 1, 4, 7 };
		TeamExperiment experiment = new TeamExperiment();
		ExperimentSetUpSearches combinator = new ExperimentSetUpSearches(
				experiment.getGraphs(), loopCoverages);
		List<Tuple<ExecutableTreatment>> combinations = combinator.combine();
		experiment.runExperiment(combinations);

	}

}
