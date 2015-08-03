package br.edu.ufcg.splab.experiment_hierarchy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.combinators.ExperimentSetUp;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiment_rep.TeamExperiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.factors.Factor;
import br.edu.ufcg.splab.experiment_hierarchy.core.factors.InterfaceFactor;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.searches.BreadthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;

public class Main {

	public static void main(String[] args) throws Exception {
		List<InterfaceFactor> list = new ArrayList<InterfaceFactor>();
		Factor searchs = new Factor();
		BreadthFirstSearch breadth = new BreadthFirstSearch();
		DepthFirstSearch depth = new DepthFirstSearch();
		searchs.addTreatment((ExecutableTreatment) breadth);
		list.add(searchs);
		ExperimentSetUp combinate = new ExperimentSetUp(list);

		List<List<ExecutableTreatment>> combinations = combinate.combine();

		int[] loopCoverages = { 3, 1, 2 };
		TeamExperiment experiment = new TeamExperiment(loopCoverages);
		Iterator<List<ExecutableTreatment>> itr = combinations.iterator();
		while (itr.hasNext()) {
			List<ExecutableTreatment> element = (List<ExecutableTreatment>) itr.next();
			experiment.runExperiment(element);
		}
	}

}
