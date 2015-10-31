package br.edu.ufcg.splab.experiment_hierarchy.tests;

import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;
import br.edu.ufcg.splab.graph_hierarchy.parser.ReadTGF;
import br.edu.ufcg.splab.trash.GreedyStructure;
import br.edu.ufcg.splab.trash.ReqTracerAllTransitionsCoverage;

public class TestReqTracer {
	public static void main(String[] args) {
		try {
			ReadTGF reader = new ReadTGF();
			InterfaceGraph graph = reader.getGraph("C:\\Users\\Wesley\\git\\application-of-reproducibility-research-with-software-testing\\ARRSTT\\input_examples\\iaron_easytoy4.tgf");
			InterfaceSearch search = new DepthFirstSearch();
			TestSuite ts = search.getTestSuite(graph.getRoot(), 0);
			
			ReqTracerAllTransitionsCoverage coverager = new ReqTracerAllTransitionsCoverage(ts);
			GreedyStructure gs = new GreedyStructure(coverager.getMap());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
