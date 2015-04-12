package br.edu.ufcg.splab.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.searchs.DepthFirstSearch;
import br.edu.ufcg.splab.util.TestCase;

public class TestDepthFirstSearch {
	
	private InterfaceGraph graph;
	private List<TestCase> cases;
	private ReadTGF tgfReader = new ReadTGF();
	private DepthFirstSearch searchObject = new DepthFirstSearch();
	
	
	@Test
	public void testSearchByListSize() throws Exception{
		// Easy toys
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy1.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(2, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy2.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(2, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy3.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(6, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy4.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(4, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_easytoy5.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(2, cases.size());
		
		// Medium toys
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_mediumtoy1.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(4, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_mediumtoy2.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(4, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_mediumtoy3.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(10, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_mediumtoy4.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(7, cases.size());
		
		// Difficult toys
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_difficulttoy1.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(4, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_difficulttoy2.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(6, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_difficulttoy3.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(11, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/iaron_difficulttoy4.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(13, cases.size());
		
		// Real graphs
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/jo_ken_po_exemplo.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(9, cases.size());
		
		graph = tgfReader.getGraph("/ARRSTT/input_examples/Dark_Souls_2_Chest.tgf");
		cases = searchObject.search(graph.getRoot());
		Assert.assertEquals(6, cases.size());
	}

}
