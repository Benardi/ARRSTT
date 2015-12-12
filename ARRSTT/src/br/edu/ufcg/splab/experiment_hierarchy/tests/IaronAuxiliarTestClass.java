package br.edu.ufcg.splab.experiment_hierarchy.tests;


import br.edu.ufcg.splab.experiment_hierarchy.minimizations.builders.ATCoverage;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.builders.RequirementBuilder;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.factories.MinimizationTechniquesFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;
import br.edu.ufcg.splab.graph_hierarchy.parser.ReadTGF;

public class IaronAuxiliarTestClass {

	public static void main(String[] args) throws Exception {
		ReadTGF reader = new ReadTGF();
		InterfaceSearch search = new DepthFirstSearch();
		
		InterfaceGraph graph = reader.getGraph("input_examples/full_of_branches.tgf");
		
		TestSuite original = search.getTestSuite(graph.getRoot(), 0);
		//System.out.println(original);
		RequirementBuilder builder = new ATCoverage(original);
		MinimizationTechniquesFactory fac = new MinimizationTechniquesFactory();
		InterfaceMinimizationTechnique tec = fac.createGRETechnique(original, builder);
		TestSuite result = tec.minimize();
		System.out.println(result);

	}

}
