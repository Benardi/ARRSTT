package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Arthur Costa		2015-07-12
 * Big Refactoring												Iaron Araujo		2015-08-23
 * 
 */
/**
 * <b>Objective:</b> This is a complete factorial combinator. This means that
 * it will generate all possible combinations for the Generation
 * Experiment's treatments. 
 * <br>
 * <b>Description of use:</b> Used in the Experiment class to generate the
 * necessary for the Runner to work.
 *
 */
public class GenerationSetup implements InterfaceSetup {
    private List<GenerationType> generationAlgorithms;
    private List<InterfaceGraph> graphs;
    private List<Integer> loopCoverages;
	
	/**
	 * GenerationSetup's constructor.
	 * @param graphs
	 * 		The list of graphs that represent one independent variable
	 * 		to the experiment.
	 * @param loopCoverages
	 * 		An array of loop coverage that represents independent variables.
	 * @param generationAlgorithms
	 * 		The list of generation algorithms that represents independent
	 * 		variables.
	 */
	public GenerationSetup(List<InterfaceGraph> graphs, List<Integer> loopCoverages, List<GenerationType> generationAlgorithms) {
		this.graphs = graphs;
		this.loopCoverages = loopCoverages;
		this.generationAlgorithms = generationAlgorithms;
	}
	
	@Override
	/**
	 * <b>Objective:</b> Return the complete factorial independent variables' 
	 * combinations of the ARRSTT generation experiment.
	 * <br>
	 * <b>Example of use:</b> The list of tuples returned can be used
	 * by a Runner that is going to execute the experiment. This
	 * generally happens in the Experiment class. 
	 * 
	 * @return The list of ExecutableTreatment's tuple, that
	 * represents independent variables combinations.
	 */
	public List<Tuple<ExecutableTreatment>> getArtifacts() {
		List<Tuple<ExecutableTreatment>> allTrials = new ArrayList<Tuple<ExecutableTreatment>>();
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		
		for(InterfaceGraph graph : graphs) {
			for(GenerationType search: generationAlgorithms) {
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