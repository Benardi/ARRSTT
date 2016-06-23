package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.NeoExperimentRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.NeoMinimizationSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.NeoSelectionSetup;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.factories.MinimizationTechniques;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.BiggestTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.RandomTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.SimilarityTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.SmallestTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.RequirementBuilders;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ExperimentFactory {
	public final static double MASK_PERCENTAGE = 0.4;
	public static final String LINE_END = System.getProperty("line.separator");
	
	public Experiment buildNeoSelection(List<TestSuite> testSuites, File[] files, int replications){
		List<InterfaceSelectionTechnique> selectionTechniques = new ArrayList<>();
		selectionTechniques.add(new BiggestTechnique());
		selectionTechniques.add(new SmallestTechnique());
		selectionTechniques.add(new RandomTechnique());
		selectionTechniques.add(new SimilarityTechnique());
		
		double selectionPercentage = 0.4;		
		InterfaceSetup setup = new NeoSelectionSetup(testSuites, selectionTechniques, selectionPercentage, files, replications);
		InterfaceRunner runner = new NeoExperimentRunner(selectionTechniques.size());
		
		return new Experiment(setup, runner);
	}
	
	public Experiment buildNeoMinimization(List<TestSuite> testSuites, File[] files, int replications) {
		List<MinimizationTechniques> enumMinimizationTechniques = new ArrayList<MinimizationTechniques>();
		enumMinimizationTechniques.add(MinimizationTechniques.G);
		enumMinimizationTechniques.add(MinimizationTechniques.GE);
		enumMinimizationTechniques.add(MinimizationTechniques.GRE);
		enumMinimizationTechniques.add(MinimizationTechniques.H);
		
		InterfaceSetup setup = new NeoMinimizationSetup(testSuites, enumMinimizationTechniques, RequirementBuilders.ATCoverage, files, replications);
		InterfaceRunner runner = new NeoExperimentRunner(enumMinimizationTechniques.size());
		
		return new Experiment(setup, runner);
	}
}
