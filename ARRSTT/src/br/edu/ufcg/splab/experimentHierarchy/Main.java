package br.edu.ufcg.splab.experimentHierarchy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ufcg.splab.experimentHierarchy.core.combinators.ExperimentSetUp;
import br.edu.ufcg.splab.experimentHierarchy.core.experiment_rep.TeamExperiment;
import br.edu.ufcg.splab.experimentHierarchy.core.factors.Factor;
import br.edu.ufcg.splab.experimentHierarchy.core.factors.InterfaceFactor;
import br.edu.ufcg.splab.experimentHierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experimentHierarchy.searches.BreadthFirstSearch;
import br.edu.ufcg.splab.experimentHierarchy.searches.DepthFirstSearch;

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
