package br.edu.ufcg.splab.experiment_hierarchy.core.combinators;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.TreatmentSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.BreadthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;

/**
 * This is a complete factorial combinator. This means that
 * it will generate all possible combinations for the treatments. 
 *
 */
public class ExperimentSetUp implements Combinable {
    private List<Tuple<ExecutableTreatment>> combinatedList;
    private List<InterfaceGraph> graphs;
    private int[] loopCoverages;
	
	/**
	 * Build a new combinator with a list of super.getFactors(). 
	 * 
	 * @param super.getFactors()
	 * 		The list of super.getFactors() which the treatments are in.
	 */
	public ExperimentSetUp(List<InterfaceGraph> graphs, int[] loopCoverages) {
		this.graphs = graphs;
		this.loopCoverages = loopCoverages;
	}
	
	/**
	 * This method do what the combinator is supposed to do.
	 * That is, for each graph it will vary the searches and
	 * loop coverages, generating the combinations that will 
	 * be executed by the runExperiment method.
	 * 
	 * @return
	 * 		A list containing the combinations.
	 */
	@Override
	public List<Tuple<ExecutableTreatment>> combine() {
		List<Tuple<ExecutableTreatment>> combinations = new ArrayList<Tuple<ExecutableTreatment>>();
		List<InterfaceSearch> searches = new ArrayList<InterfaceSearch>();
		searches.add(new DepthFirstSearch());
		searches.add(new BreadthFirstSearch());
		
		for(InterfaceGraph graph : graphs) {
			for(InterfaceSearch search: searches) {
				for(Integer loopCoverage : loopCoverages) {
					Tuple<ExecutableTreatment> combination = new Tuple<ExecutableTreatment>();
					combination.add(new TreatmentSearch(search, graph.getRoot(), loopCoverage, ""));
					combinations.add(combination);
				}
			}
		}
		
		combinatedList = combinations;
		return combinations;
	}
	
	public List<Tuple<ExecutableTreatment>> getCombinations() {
		return this.combinatedList;
	}

}