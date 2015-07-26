package br.edu.ufcg.splab.experimentHierarchy.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.ufcg.splab.experimentHierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experimentHierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.parser.ReadTGF;

public class TestDepthFirstSearch {
	
	private InterfaceGraph graph;
	private List<TestCase> cases;
	private ReadTGF tgfReader = new ReadTGF();
	private DepthFirstSearch searchObject = new DepthFirstSearch();
	
	
	@Test
	public void testSearchByListSize() throws Exception{
		// Easy toys
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy1.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(2, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy2.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(2, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy3.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(6, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy4.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(4, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy5.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(2, cases.size());
		
		// Medium toys
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_mediumtoy1.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(4, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_mediumtoy2.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(4, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_mediumtoy3.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(10, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_mediumtoy4.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(7, cases.size());
		
		// Difficult toys
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_difficulttoy1.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(4, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_difficulttoy2.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(6, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_difficulttoy3.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(10, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_difficulttoy4.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(12, cases.size());
		
		// Real graphs
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/jo_ken_po_exemplo.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(9, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/Dark_Souls_2_Chest.tgf");
		cases = searchObject.getTestSuite(graph.getRoot(), 0);
		Assert.assertEquals(7, cases.size());
	}

}
