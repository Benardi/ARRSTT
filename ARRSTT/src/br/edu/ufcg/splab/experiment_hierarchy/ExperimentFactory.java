package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectiveEdgesCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectsCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTTimeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.ExperimentRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.Runnable;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.ExperimentSetUpGeneration;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.ExperimentSetUpInterface;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.ExperimentSetUpSelection;
import br.edu.ufcg.splab.experiment_hierarchy.graph_maskers.InterfaceGraphMaskarator;
import br.edu.ufcg.splab.experiment_hierarchy.graph_maskers.RandomMasker;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.BranchSeparator;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.DVCFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.parser.ReadTGF;

public class ExperimentFactory {
	public final static double MASK_PERCENTAGE = 0.4;
	private DVCFactory dvcFactory;
	
	public ExperimentFactory(){
		dvcFactory = new DVCFactory();
	}
	
	public Experiment buildArrsttGeneration() throws Exception {
		int[] loopCoverages = { 1, 4, 7 };
		BranchSeparator separator = new BranchSeparator();
		
		// selecting the types
		List<DVCType> types = new ArrayList<>();
		types.add(DVCType.TIME);
		types.add(DVCType.SIZE);
		
		List<DependentVariableCollector> collectors = dvcFactory.createCollectorList(types);
		
		ExperimentSetUpInterface setup = new ExperimentSetUpGeneration(separator.getGraphsToRun(), loopCoverages);
		Runnable runner = new ExperimentRunner(collectors);
		
		return new Experiment(setup, runner);
	}
	
	public Experiment buildArrsttSelection() throws Exception {
		
		// selecting the types
		List<DVCType> types = new ArrayList<>();
		types.add(DVCType.TIME);
		types.add(DVCType.SIZE);
		types.add(DVCType.DEFECTIVE_EDGES);
		types.add(DVCType.DEFECTS);
				
		List<DependentVariableCollector> collectors = dvcFactory.createCollectorList(types);		
		
		ExperimentSetUpInterface setup = new ExperimentSetUpSelection(loadGraphs(), 0.5);
		Runnable runner = new ExperimentRunner(collectors);
		
		return new Experiment(setup, runner);
	}
	
	private List<TestSuite> loadGraphs() throws Exception {
		List<InterfaceGraph> allGraphs = new ArrayList<>();
		
		File[] folder = new File("input_examples/").listFiles();
		ReadTGF tgfReader = new ReadTGF();
		for (File file : folder) {
			InterfaceGraph graph = tgfReader.getGraph(file.getAbsolutePath());
			allGraphs.add(graph);
		}
		
		List<InterfaceGraph> maskedGraphs = new ArrayList<>();
		InterfaceGraphMaskarator masker = new RandomMasker();
		
		for (InterfaceGraph graph : allGraphs) {
			maskedGraphs.add(masker.mask(graph, MASK_PERCENTAGE));
		}
		
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		
		for (InterfaceGraph graph : maskedGraphs) {
			InterfaceSearch search = new DepthFirstSearch();
			System.out.println(search.getTestSuite(graph.getRoot(), 0).size());
			testSuites.add(search.getTestSuite(graph.getRoot(), 0));
		}
		System.out.println("---cabou---");
		
		return testSuites;
	}
}
