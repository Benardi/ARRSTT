package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;

/**
 * This is a complete factorial combinator. This means that
 * it will generate all possible combinations for the treatments. 
 *
 */
public class GenerationSetup implements InterfaceSetup {
    private List<InterfaceGraph> graphs;
    private int[] loopCoverages;
	
	/**
	 * Build a new combinator with a list of super.getFactors(). 
	 * 
	 * @param super.getFactors()
	 * 		The list of super.getFactors() which the treatments are in.
	 */
	public GenerationSetup(List<InterfaceGraph> graphs, int[] loopCoverages) {
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
	public List<Tuple<ExecutableTreatment>> getIndependentVariables() {
		List<Tuple<ExecutableTreatment>> allTrials = new ArrayList<Tuple<ExecutableTreatment>>();
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		//add search factor
		List<GenerationType> searches = new ArrayList<GenerationType>();
		searches.add(GenerationType.DFS);
		searches.add(GenerationType.BFS);
		
		for(InterfaceGraph graph : graphs) {
			for(GenerationType search: searches) {
				for(Integer loopCoverage : loopCoverages) {
					//creates a trial composed of a: search, graph and loop coverage.
					Tuple<ExecutableTreatment> trial = new Tuple<ExecutableTreatment>();
					trial.add(treatmentFactory.createGeneration(search, graph.getRoot(), loopCoverage));
					allTrials.add(trial);
				}
			}
		}
		
		return allTrials;
	}
}