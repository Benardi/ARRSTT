package br.edu.ufcg.splab.util.factories;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.framework.core.api.InterfaceRunner;
import br.edu.ufcg.splab.framework.core.api.InterfaceSetup;
import br.edu.ufcg.splab.framework.core.experiments.Experiment;
import br.edu.ufcg.splab.framework.core.runners.MyExperimentRunner;
import br.edu.ufcg.splab.framework.core.setups.MyMinimizationSetup;
import br.edu.ufcg.splab.framework.core.setups.MySelectionSetup;
import br.edu.ufcg.splab.framework.techniques.minimization.factories.MinimizationTechniques;
import br.edu.ufcg.splab.framework.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.framework.techniques.selection.RandomTechnique;
import br.edu.ufcg.splab.framework.techniques.selection.SimilarityTechnique;
import br.edu.ufcg.splab.util.enums.RequirementBuilders;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class ExperimentFactory {
	
	public static final String LINE_END = System.getProperty("line.separator");
	
	public Experiment buildNeoSelection(List<TestSuite> testSuites, File[] files, int replications){
				
		List<InterfaceSelectionTechnique> selectionTechniques = new ArrayList<>();
//		selectionTechniques.add(new BiggestTechnique());
//		selectionTechniques.add(new SmallestTechnique());
		selectionTechniques.add(new RandomTechnique());
		selectionTechniques.add(new SimilarityTechnique());
		
		//String headerRow = "BIGGEST\tSMALLEST\tRANDOM\tSIMILARITY";
		String headerRow = "RANDOM\tSIMILARITY";
		
		double selectionPercentage = 0.5;		
		InterfaceSetup setup = new MySelectionSetup(testSuites, selectionTechniques, selectionPercentage, files, replications);
		InterfaceRunner runner = new MyExperimentRunner(headerRow, selectionTechniques.size());
		
		return new Experiment(setup, runner);
	}
	
	public Experiment buildNeoMinimization(List<TestSuite> testSuites, File[] files, int replications) {
		List<MinimizationTechniques> enumMinimizationTechniques = new ArrayList<MinimizationTechniques>();
		enumMinimizationTechniques.add(MinimizationTechniques.G);
		enumMinimizationTechniques.add(MinimizationTechniques.GE);
		enumMinimizationTechniques.add(MinimizationTechniques.GRE);
		enumMinimizationTechniques.add(MinimizationTechniques.H);
		
		String headerRow = "G\tGE\tGRE\tH";
		
		InterfaceSetup setup = new MyMinimizationSetup(testSuites, enumMinimizationTechniques, RequirementBuilders.ATCoverage, files, replications);
		InterfaceRunner runner = new MyExperimentRunner(headerRow, enumMinimizationTechniques.size());
		
		return new Experiment(setup, runner);
	}
}
