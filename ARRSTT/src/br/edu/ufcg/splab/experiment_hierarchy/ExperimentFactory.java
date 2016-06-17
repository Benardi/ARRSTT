package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.NeoExperimentRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.NeoSelectionSetup;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.techniques.GETechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.techniques.GRETechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.techniques.GTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.techniques.HTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.BiggestTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.RandomTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.SimilarityTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.SmallestTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ExperimentFactory {
	public final static double MASK_PERCENTAGE = 0.4;
	public static final String LINE_END = System.getProperty("line.separator");
	
	public ExperimentFactory(){
	}
	
	
	public Experiment buildNeoSelection(List<TestSuite> testSuites, File[] files){
		List<InterfaceSelectionTechnique> selectionTechniques = new ArrayList<>();
		selectionTechniques.add(new BiggestTechnique());
		selectionTechniques.add(new SimilarityTechnique());
		selectionTechniques.add(new RandomTechnique());
		selectionTechniques.add(new SmallestTechnique());
		
		double selectionPercentage = 0.8;		
		InterfaceSetup setup = new NeoSelectionSetup(testSuites, selectionTechniques, selectionPercentage, files);
		InterfaceRunner runner = new NeoExperimentRunner(selectionTechniques.size());
		
		return new Experiment(setup, runner);
	}
	
	public Experiment buildNeoMinimization(List<TestSuite> testSuites, File[] files) {
		List<InterfaceMinimizationTechnique> minimizationTechniques = new ArrayList<>();
		return null;
	}
}
