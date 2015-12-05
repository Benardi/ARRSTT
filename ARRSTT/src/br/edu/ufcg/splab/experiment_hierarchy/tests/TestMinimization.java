package br.edu.ufcg.splab.experiment_hierarchy.tests;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.builders.ATCoverage;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.builders.RequirementBuilder;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.Transition;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.TransitionType;
import br.edu.ufcg.splab.graph_hierarchy.core.vertex.Vertex;
import br.edu.ufcg.splab.graph_hierarchy.parser.ReadTGF;
import br.edu.ufcg.splab.trash.GreedyEssencial;

public class TestMinimization {
	private TestSuite myTS;
	
	@Before
	public void buildTestSuites() {
		InterfaceVertex fromV, toV;
		InterfaceEdge edge;
		InterfaceVertex[] vertexes = {new Vertex("1"), new Vertex("2"), new Vertex("3"), new Vertex("4"), new Vertex("5"), new Vertex("6"),
									  new Vertex("7"), new Vertex("8"), new Vertex("9")};
		// TC1
		TestCase tc1 = new TestCase();
		
		edge = new Transition(vertexes[0], "A", vertexes[1], TransitionType.DEFAULT);
		tc1.add(edge);
		
		edge = new Transition(vertexes[1], "C", vertexes[3], TransitionType.DEFAULT);
		tc1.add(edge);
		
		edge = new Transition(vertexes[3], "E", vertexes[5], TransitionType.DEFAULT);
		tc1.add(edge);
		
		// TC4
		TestCase tc4 = new TestCase();
		
		edge = new Transition(vertexes[0], "B", vertexes[2], TransitionType.DEFAULT);
		tc4.add(edge);
		
		edge = new Transition(vertexes[2], "D", vertexes[4], TransitionType.DEFAULT);
		tc4.add(edge);
		
		edge = new Transition(vertexes[4], "H", vertexes[8], TransitionType.DEFAULT);
		tc4.add(edge);
		
		// TC2
		TestCase tc2 = new TestCase();
		
		fromV = new Vertex("1");
		toV = new Vertex("2");
		edge = new Transition(vertexes[0], "A", vertexes[1], TransitionType.DEFAULT);
		tc2.add(edge);
		
		fromV = toV;
		toV = new Vertex("4");
		edge = new Transition(vertexes[1], "C", vertexes[3], TransitionType.DEFAULT);
		tc2.add(edge);
		
		fromV = toV;
		toV = new Vertex("7");
		edge = new Transition(vertexes[3], "F", vertexes[6], TransitionType.DEFAULT);
		tc2.add(edge);
		
		// TC3
		TestCase tc3 = new TestCase();
		
		edge = new Transition(vertexes[0], "B", vertexes[2], TransitionType.DEFAULT);
		tc3.add(edge);
		
		edge = new Transition(vertexes[2], "D", vertexes[4], TransitionType.DEFAULT);
		tc3.add(edge);
		
		edge = new Transition(vertexes[4], "G", vertexes[7], TransitionType.DEFAULT);
		tc3.add(edge);
		
		myTS = new TestSuite();
		myTS.add(tc1);
		myTS.add(tc2);
		myTS.add(tc3);
		myTS.add(tc4);
		
		//System.out.println(myTS);
		//System.out.println(myTS.get(0).get(0) + " " + myTS.get(1).get(0));
		//System.out.println(myTS.get(0).get(0).equals(myTS.get(1).get(0)));
	}
	
	@Test
	public void testGreedy() {
		//Greedy x = new Greedy(myTS);
		//TestSuite ts = x.execute();
		//System.out.println(ts);
		
		//GreedyEssencial y = new GreedyEssencial(myTS);
		//TestSuite ts = y.execute();
		//System.out.println(ts);
		
		//GreedyEssencialRedundant z = new GreedyEssencialRedundant(myTS);
		//TestSuite ts = z.execute();
		//System.out.println(ts);
		
		try {
			ReadTGF reader = new ReadTGF();
			InterfaceGraph graph = reader.getGraph("");
			InterfaceSearch search = new DepthFirstSearch();
			TestSuite ts = search.getTestSuite(graph.getRoot(), 0);
			System.out.println(ts);
			RequirementBuilder builder = new ATCoverage(ts);
			GreedyEssencial x = new GreedyEssencial(ts, builder.getRequirements());
			TestSuite resultingTS = x.execute();
			System.out.println(resultingTS);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
