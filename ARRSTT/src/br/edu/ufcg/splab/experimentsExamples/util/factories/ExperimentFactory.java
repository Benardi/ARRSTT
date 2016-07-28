package br.edu.ufcg.splab.experimentsExamples.util.factories;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.IRunner;
import br.edu.ufcg.splab.arrsttFramework.ISetup;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.core.experiments.Experiment;
import br.edu.ufcg.splab.experimentsExamples.core.runners.MyExperimentRunner;
import br.edu.ufcg.splab.experimentsExamples.core.setups.MyMinimizationSetup;
import br.edu.ufcg.splab.experimentsExamples.core.setups.MySelectionSetup;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.factories.MinimizationTechniques;
import br.edu.ufcg.splab.experimentsExamples.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.selection.RandomTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.selection.SimilarityTechnique;
import br.edu.ufcg.splab.experimentsExamples.util.enums.RequirementBuilders;

/**
 * This class is responsible for creating a Experiment with it's Setup and Runner
 */
public class ExperimentFactory {
	
	public static final String LINE_END = System.getProperty("line.separator");
	
	public Experiment buildNeoSelection(List<TestSuite> testSuites, File[] files, int replications){
				
		List<InterfaceSelectionTechnique> selectionTechniques = new ArrayList<>();
		selectionTechniques.add(new RandomTechnique());
		selectionTechniques.add(new SimilarityTechnique());
		
		String headerRow = "RANDOM\tSIMILARITY";
		
		double selectionPercentage = 0.5;		
		ISetup setup = new MySelectionSetup(testSuites, selectionTechniques, selectionPercentage, files, replications);
		IRunner runner = new MyExperimentRunner(headerRow, selectionTechniques.size());
		
		return new Experiment(setup, runner);
	}
	
	//Work in progress
	public Experiment buildNeoMinimization(List<TestSuite> testSuites, File[] files, int replications) {
		List<MinimizationTechniques> enumMinimizationTechniques = new ArrayList<MinimizationTechniques>();
		enumMinimizationTechniques.add(MinimizationTechniques.G);
		enumMinimizationTechniques.add(MinimizationTechniques.GE);
		enumMinimizationTechniques.add(MinimizationTechniques.GRE);
		enumMinimizationTechniques.add(MinimizationTechniques.H);
		
		String headerRow = "G\tGE\tGRE\tH";
		
		ISetup setup = new MyMinimizationSetup(testSuites, enumMinimizationTechniques, RequirementBuilders.ATCoverage, files, replications);
		IRunner runner = new MyExperimentRunner(headerRow, enumMinimizationTechniques.size());
		
		return new Experiment(setup, runner);
	}
}
