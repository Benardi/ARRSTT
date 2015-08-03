package br.edu.ufcg.splab.experiment_hierarchy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.combinators.ExperimentSetUpSearches;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiment_rep.TeamExperiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.factors.Factor;
import br.edu.ufcg.splab.experiment_hierarchy.core.factors.InterfaceFactor;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.searches.BreadthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

public class Main {

	public static void main(String[] args) throws Exception {
		//create factor
		Factor searchs = new Factor();
		BreadthFirstSearch breadth = new BreadthFirstSearch();
		DepthFirstSearch depth = new DepthFirstSearch();
		searchs.addTreatment((ExecutableTreatment) breadth);
		
		//add factor
		List<InterfaceFactor> list = new ArrayList<InterfaceFactor>();
		list.add(searchs);		
		ExperimentSetUpSearches combinate = new ExperimentSetUpSearches(list);

		List<Tuple<ExecutableTreatment>> combinations = combinate.combine();

		int[] loopCoverages = { 3, 1, 2 };
		TeamExperiment experiment = new TeamExperiment(loopCoverages);
		Iterator<Tuple<ExecutableTreatment>> itr = combinations.iterator();
		while (itr.hasNext()) {
			List<ExecutableTreatment> element = (List<ExecutableTreatment>) itr.next();
			experiment.runExperiment(element);
		}
	}

}
