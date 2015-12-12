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
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.MinimizationSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.SelectionSetup;
import br.edu.ufcg.splab.experiment_hierarchy.maskarators.InterfaceGraphMaskarator;
import br.edu.ufcg.splab.experiment_hierarchy.maskarators.RandomMasker;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.factories.MinimizationType;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.BranchSeparator;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.ReqBuilderType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
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
	
	public Experiment buildGeneration(List<Integer> loopCoverages, List<GenerationType> generationAlgorithms, List<DVCType> dvcTypes) throws Exception {
		BranchSeparator separator = new BranchSeparator();
		List<DependentVariableCollector> collectors = dvcFactory.createCollectorList(dvcTypes);
		InterfaceSetup setup = new GenerationSetup(separator.getGraphsToRun(), loopCoverages, generationAlgorithms);
		InterfaceRunner runner = new DefaultRunner(collectors, 6);
		
		return new Experiment(setup, runner);
	}
	
	public Experiment buildSelection(List<SelectionType> selectionAlgorithms, double selectionPercentage, List<DVCType> dvcTypes) throws Exception {
		List<DependentVariableCollector> collectors = dvcFactory.createCollectorList(dvcTypes);
		InterfaceSetup setup = new SelectionSetup(loadGraphs(), selectionPercentage, selectionAlgorithms);
		InterfaceRunner runner = new DefaultRunner(collectors, loadGraphs().size());
		
		return new Experiment(setup, runner);
	}
	
	public Experiment buildMinimization(List<MinimizationType> minimizationAlgorithms, ReqBuilderType builder, List<DVCType> dvcTypes) throws Exception{
		List<TestSuite> testSuites = loadGraphsWithoutMasking();
		List<DependentVariableCollector> collectors = dvcFactory.createCollectorList(dvcTypes);
		
		InterfaceSetup setup = new MinimizationSetup(testSuites, minimizationAlgorithms, builder);
		InterfaceRunner runner = new DefaultRunner(collectors, testSuites.size());
		
		return new Experiment(setup, runner);
	}
	
	//vai pro controller
	private List<TestSuite> loadGraphs() throws Exception {
		List<InterfaceGraph> allGraphs = new ArrayList<>();
		File[] folder = new File("input_examples/").listFiles();
		ReadTGF tgfReader = new ReadTGF();
		System.out.println(folder[0]);
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
			testSuites.add(search.getTestSuite(graph.getRoot(), 0));
		}
		
		return testSuites;
	}
	
	private List<TestSuite> loadGraphsWithoutMasking() throws Exception {
		List<InterfaceGraph> allGraphs = new ArrayList<>();
		File[] folder = new File("input_examples/").listFiles();
		ReadTGF tgfReader = new ReadTGF();
		
		for (File file : folder) {
			InterfaceGraph graph = tgfReader.getGraph(file.getAbsolutePath());
			allGraphs.add(graph);
		}
		
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		
		for (InterfaceGraph graph : allGraphs) {
			InterfaceSearch search = new DepthFirstSearch();
			testSuites.add(search.getTestSuite(graph.getRoot(), 0));
		}
		
		return testSuites;
	}
}
