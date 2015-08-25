package br.edu.ufcg.splab.experiment_hierarchy.core.setup;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.TreatmentSelection;
import br.edu.ufcg.splab.experiment_hierarchy.graph_maskers.InterfaceGraphMaskarator;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BySimilaritySelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.RandomizedTestCaseSelection;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;

public class ExperimentSetUpSelection implements ExperimentSetUpInterface{
	private static final int LOOP_COVERAGE = 0;
	private List<InterfaceGraph> graphs;
	private InterfaceGraphMaskarator maskarator;
	private InterfaceSearch search;
	private double maskPercentage, selectionPercentage;
	
	public ExperimentSetUpSelection(List<InterfaceGraph> graphs, InterfaceGraphMaskarator maskarator, double maskPercentage, double selectionPercentage){
		this.graphs = graphs;
		this.maskarator = maskarator;
		this.search = new DepthFirstSearch();
		this.maskPercentage = maskPercentage;
		this.selectionPercentage = selectionPercentage;
	}

	@Override
	public List<Tuple<ExecutableTreatment>> getIndependentVariables() {
		List<InterfaceGraph> maskedGraphs = getMaskedGraphs();
		List<TestSuite> maskedTestSuites = getMaskedTestSuites(maskedGraphs);
		return combine(maskedTestSuites, selectionPercentage);
	}
	
	private List<Tuple<ExecutableTreatment>> combine(List<TestSuite> maskedTestSuites, double selectionPercentage){
		List<Tuple<ExecutableTreatment>> combinations = new ArrayList<>();
		
		List<InterfaceTestCaseSelector> selectionAlgorithms = new ArrayList<InterfaceTestCaseSelector>();
		selectionAlgorithms.add(new BySimilaritySelector());
		selectionAlgorithms.add(new RandomizedTestCaseSelection());
		
		for (InterfaceTestCaseSelector selection : selectionAlgorithms) {
			for (TestSuite ts : maskedTestSuites) {
				Tuple<ExecutableTreatment> combination = new Tuple<ExecutableTreatment>();
				combination.add(new TreatmentSelection(selection, ts, selectionPercentage));
				combinations.add(combination);
			}
		}
		
		return combinations;
		
	}

	private List<InterfaceGraph> getMaskedGraphs(){
		List<InterfaceGraph> maskedGraphs = new ArrayList<>();
		for(InterfaceGraph graph : graphs){
			maskedGraphs.add(maskarator.mask(graph, maskPercentage));
		}
		return maskedGraphs;
	}
	
	private List<TestSuite> getMaskedTestSuites(List<InterfaceGraph> maskedGraphs) {
		List<TestSuite> maskedTestSuites = new ArrayList<>();
		for(InterfaceGraph graph : maskedGraphs){
			maskedTestSuites.add(search.getTestSuite(graph.getRoot(), LOOP_COVERAGE));
		}
		return maskedTestSuites;
		
	}
}
