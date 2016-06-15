package br.edu.ufcg.splab.experiment_hierarchy;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.Artifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TestArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.DefaultRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.MinimizationSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.NoneSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.SelectionSetup;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.factories.MinimizationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.ReqBuilderType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ExperimentFactory {
	public final static double MASK_PERCENTAGE = 0.4;
	public static final String LINE_END = System.getProperty("line.separator");
	
	public ExperimentFactory(){
	}
	
	// THIS IS GONNA HAVE TO BE CHANGED A LOT TO WORK.
	/*public Experiment buildGeneration(List<Integer> loopCoverages, List<GenerationType> generationAlgorithms) throws Exception {
		BranchSeparator separator = new BranchSeparator();
		List<DependentVariableCollector> collectors = dvcFactory.createCollectorList(dvcTypes);
		InterfaceSetup setup = new GenerationSetup(separator.getGraphsToRun(), loopCoverages, generationAlgorithms);
		InterfaceRunner runner = new DefaultRunner(collectors, 6);
		
		return new Experiment(setup, runner);
	}*/
	
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
	}
	
	/*private List<TestSuite> loadGraphs() throws Exception {
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
		
		putGraphsInformationInFile(maskedGraphs);
		
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		
		for (InterfaceGraph graph : maskedGraphs) {
			InterfaceSearch search = new DepthFirstSearch();
			testSuites.add(search.getTestSuite(graph.getRoot(), 0));
		}
		
		return testSuites;
	}
	
	//I AM HERE
	private void putGraphsInformationInFile(List<InterfaceGraph> maskedGraphs) {
		int errorAmount;
		StringBuffer information = new StringBuffer();
		String defectiveLabel = "ERROR";
		int counter = 0;
		
		for(InterfaceGraph g : maskedGraphs){
			errorAmount = 0;
			
			// Write TGF of Graph
			WriteTGF writer = new WriteTGF();
			
			try {
				writer.putInTGF(g, counter + "");
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			counter++;
			
			for(InterfaceEdge edge : g.getEdges()){
				if(edge.getLabel().equals(defectiveLabel)){
					errorAmount++;
				}
			}
			information.append(errorAmount + " ");
		}
		information.append(LINE_END);
		
		//put to file
		try {
			ExperimentFile file = new ExperimentFile("Graphs Defects Information");
			file.appendContent(information);
			file.save();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
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
	}*/
}
