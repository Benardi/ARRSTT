package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.NeoSelectionRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.NeoSelectionSetup;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BiggestTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BySimilaritySelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.RandomizedTestCaseSelection;
import br.edu.ufcg.splab.experiment_hierarchy.selections.SmallestTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ExperimentFactory {
	public final static double MASK_PERCENTAGE = 0.4;
	public static final String LINE_END = System.getProperty("line.separator");
	
	public ExperimentFactory(){
	}
	
	
	public Experiment buildNeoSelection(List<TestSuite> testSuites, File[] files){
		List<InterfaceTestCaseSelector> selectionAlgorithms = new ArrayList<>();
		double selectionPercentage = 0.8;
		
		selectionAlgorithms.add(new BiggestTestCaseSelector());
		selectionAlgorithms.add(new BySimilaritySelector());
		selectionAlgorithms.add(new RandomizedTestCaseSelection());
		selectionAlgorithms.add(new SmallestTestCaseSelector());
		
		InterfaceSetup setup = new NeoSelectionSetup(selectionAlgorithms, selectionPercentage, testSuites, files);
		InterfaceRunner runner = new NeoSelectionRunner(selectionAlgorithms.size());
		
		return new Experiment(setup, runner);
	}
	
	
	//==================================================================================================================================================
	/*
	public Experiment buildSelection(List<TestArtifact> artifacts, List<SelectionType> selectionAlgorithms, double selectionPercentage) throws Exception {
		List<TestSuite> testSuites = suiteList(artifacts);
		InterfaceSetup setup = new SelectionSetup(testSuites, selectionPercentage, selectionAlgorithms);
		InterfaceRunner runner = new DefaultRunner(collectors, testSuites.size());
		
		return new Experiment(setup, runner);
	}
	
	public Experiment buildMinimization(List<TestArtifact> artifacts, List<MinimizationType> minimizationAlgorithms, ReqBuilderType builder) throws Exception{
		List<TestSuite> testSuites = suiteList(artifacts);
		InterfaceSetup setup = new MinimizationSetup(testSuites, minimizationAlgorithms, builder);
		InterfaceRunner runner = new DefaultRunner(collectors, testSuites.size());
		
		return new Experiment(setup, runner);
	}
	
	public Experiment buildNone(List<TestArtifact> artifacts) throws Exception{
		List<TestSuite> testSuites = suiteList(artifacts);
		InterfaceSetup setup = new NoneSetup(testSuites);
		InterfaceRunner runner = new DefaultRunner(collectors, testSuites.size());
		
		return new Experiment(setup, runner);
	}
	
	// SHOULD BE DELETED AFTER REFACTORING
	private List<TestSuite> suiteList(List<TestArtifact> artifacts) {
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		for (TestArtifact artifact : artifacts) {
			testSuites.add(artifact.getTarget());
		}
		
		return testSuites;
	}*/

}
