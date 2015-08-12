package br.edu.ufcg.splab.experiment_hierarchy.core.setup;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.combinators.Combinable;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.graph_maskarator.GraphMaskaratorInterface;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BiggestTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BySimilaritySelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.RandomizedTestCaseSelection;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;

public class ExperimentSetUpSelection implements ExperimentSetUpInterface{
	private static final int LOOP_COVERAGE = 0;
	private List<InterfaceGraph> graphs;
	private GraphMaskaratorInterface maskarator;
	private InterfaceSearch search;
	private double maskPercentage, selectionPercentage;
	
	public ExperimentSetUpSelection(List<InterfaceGraph> graphs, GraphMaskaratorInterface maskarator, double maskPercentage, double selectionPercentage){
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
		List<InterfaceTestCaseSelector> selections = generateSelections(maskedTestSuites.get(0));
		
		//TODO apagar o comentario quando o combinator estiver funcionando
		/*Combinable combinator = new SelectionCombinator(maskedTestSuites, selections);
		return combinator.combine();*/
		
		//apagar esta linha quando tudo estiver pronto
		return null;
	}

	private List<InterfaceGraph> getMaskedGraphs(){
		List<InterfaceGraph> maskedGraphs = new ArrayList<>();
		for(InterfaceGraph graph : graphs){
			maskedGraphs.add(maskarator.maskarate(graph, maskPercentage));
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
	
	private List<InterfaceTestCaseSelector> generateSelections(TestSuite defaultTS) {
		List<InterfaceTestCaseSelector> selections = new ArrayList<>();
		selections.add(new BySimilaritySelector(defaultTS, selectionPercentage));
		selections.add(new BiggestTestCaseSelector(defaultTS, selectionPercentage));
		selections.add(new RandomizedTestCaseSelection(defaultTS, selectionPercentage));
		return selections;
	}

}
