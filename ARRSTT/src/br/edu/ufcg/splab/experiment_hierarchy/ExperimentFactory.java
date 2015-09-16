package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.DefaultRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.GenerationSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.SelectionSetup;
import br.edu.ufcg.splab.experiment_hierarchy.maskarators.InterfaceGraphMaskarator;
import br.edu.ufcg.splab.experiment_hierarchy.maskarators.RandomMasker;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.BranchSeparator;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.DVCFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;
import br.edu.ufcg.splab.graph_hierarchy.parser.ReadTGF;

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
		
		InterfaceSetup setup = new GenerationSetup(separator.getGraphsToRun(), loopCoverages);
		InterfaceRunner runner = new DefaultRunner(collectors);
		
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
		
		InterfaceSetup setup = new SelectionSetup(loadGraphs(), 0.5);
		InterfaceRunner runner = new DefaultRunner(collectors);
		
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
