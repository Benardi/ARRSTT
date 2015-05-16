package br.edu.ufcg.splab.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.searchs.BreadthFirstSearch;
import br.edu.ufcg.splab.searchs.DepthFirstSearch;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

public class SearchsByPathSizeTestCase {
	private InterfaceSearch searchObject1;
	private InterfaceSearch searchObject2;
	private ReadTGF tgfReader;
	
	private InterfaceGraph loopytoy1;
	private InterfaceGraph loopytoy2;
	private InterfaceGraph loopytoy3;
	private InterfaceGraph loopytoy4;
	private InterfaceGraph loopytoy5;
	private InterfaceGraph loopytoy6;
	private InterfaceGraph loopytoy7;
	private InterfaceGraph loopytoy8;
	
	private InterfaceGraph iaronEasytoy1;
	private InterfaceGraph iaronEasytoy2;
	private InterfaceGraph iaronEasytoy3;
	private InterfaceGraph iaronEasytoy4;
	private InterfaceGraph iaronEasytoy5;
	
	private InterfaceGraph iaronMediumtoy1;
	private InterfaceGraph iaronMediumtoy2;
	private InterfaceGraph iaronMediumtoy3;
	private InterfaceGraph iaronMediumtoy4;
	
	private InterfaceGraph iaronDifficulttoy1;
	private InterfaceGraph iaronDifficulttoy2;
	private InterfaceGraph iaronDifficulttoy3;
	private InterfaceGraph iaronDifficulttoy4;
	
	private InterfaceGraph simpleExample;
	private InterfaceGraph sonicHedgehog;
	private InterfaceGraph lifeNutshell;
	private InterfaceGraph darkSoulsChest;
	
	
	@Before
	public void setUp() throws Exception {
		tgfReader = new ReadTGF();
		
		// Loading loopytoys.
		loopytoy1 = tgfReader.getGraph("input_examples/loopytoy1.tgf");
		loopytoy2 = tgfReader.getGraph("input_examples/loopytoy2.tgf");
		loopytoy3 = tgfReader.getGraph("input_examples/loopytoy3.tgf");
		loopytoy4 = tgfReader.getGraph("input_examples/loopytoy4.tgf");
		loopytoy5 = tgfReader.getGraph("input_examples/loopytoy5.tgf");
		loopytoy6 = tgfReader.getGraph("input_examples/loopytoy6.tgf");
		loopytoy7 = tgfReader.getGraph("input_examples/loopytoy7.tgf");
		loopytoy8 = tgfReader.getGraph("input_examples/loopytoy8.tgf");
		
		// Loading iaron graphs.
		iaronEasytoy1 = tgfReader.getGraph("input_examples/iaron_easytoy1.tgf");
		iaronEasytoy2 = tgfReader.getGraph("input_examples/iaron_easytoy2.tgf");
		iaronEasytoy3 = tgfReader.getGraph("input_examples/iaron_easytoy3.tgf");
		iaronEasytoy4 = tgfReader.getGraph("input_examples/iaron_easytoy4.tgf");
		iaronEasytoy5 = tgfReader.getGraph("input_examples/iaron_easytoy5.tgf");
		
		iaronMediumtoy1 = tgfReader.getGraph("input_examples/iaron_mediumtoy1.tgf");
		iaronMediumtoy2 = tgfReader.getGraph("input_examples/iaron_mediumtoy2.tgf");
		iaronMediumtoy3 = tgfReader.getGraph("input_examples/iaron_mediumtoy3.tgf");
		iaronMediumtoy4 = tgfReader.getGraph("input_examples/iaron_mediumtoy4.tgf");
		
		iaronDifficulttoy1 = tgfReader.getGraph("input_examples/iaron_difficulttoy1.tgf");
		iaronDifficulttoy2 = tgfReader.getGraph("input_examples/iaron_difficulttoy2.tgf");
		iaronDifficulttoy3 = tgfReader.getGraph("input_examples/iaron_difficulttoy3.tgf");
		iaronDifficulttoy4 = tgfReader.getGraph("input_examples/iaron_difficulttoy4.tgf");
		
		// Loading real graphs.
		simpleExample = tgfReader.getGraph("input_examples/simple_example.tgf");
		sonicHedgehog = tgfReader.getGraph("input_examples/sonic_hedgehog.tgf");
		lifeNutshell = tgfReader.getGraph("input_examples/life_nutshell.tgf");
		darkSoulsChest = tgfReader.getGraph("input_examples/Dark_Souls_2_Chest.tgf");
	}
	
	@Test
	public void testDfsNoLoop() {
		searchObject1 = new DepthFirstSearch();
		int loopCoverage = 0;
		
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(6, searchObject1.getTestSuite(iaronEasytoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronEasytoy4.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy5.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronMediumtoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronMediumtoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(10, searchObject1.getTestSuite(iaronMediumtoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(iaronMediumtoy4.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronDifficulttoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(6, searchObject1.getTestSuite(iaronDifficulttoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(10, searchObject1.getTestSuite(iaronDifficulttoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(12, searchObject1.getTestSuite(iaronDifficulttoy4.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(simpleExample.getRoot(), loopCoverage).size());
		Assert.assertEquals(128, searchObject1.getTestSuite(sonicHedgehog.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(lifeNutshell.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(darkSoulsChest.getRoot(), loopCoverage).size());
	}
	
	@Test
	public void testBfsNoLoop() {
		searchObject1 = new BreadthFirstSearch();
		int loopCoverage = 0;
		
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(6, searchObject1.getTestSuite(iaronEasytoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronEasytoy4.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy5.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronMediumtoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronMediumtoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(10, searchObject1.getTestSuite(iaronMediumtoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(iaronMediumtoy4.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronDifficulttoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(6, searchObject1.getTestSuite(iaronDifficulttoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(10, searchObject1.getTestSuite(iaronDifficulttoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(12, searchObject1.getTestSuite(iaronDifficulttoy4.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(simpleExample.getRoot(), loopCoverage).size());
		Assert.assertEquals(128, searchObject1.getTestSuite(sonicHedgehog.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(lifeNutshell.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(darkSoulsChest.getRoot(), loopCoverage).size());
	}
	
	@Test
	public void testDfs0LoopCoverage() {
		searchObject1 = new DepthFirstSearch();
		int loopCoverage = 0;
		
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy4.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy5.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy6.getRoot(), loopCoverage).size());
		Assert.assertEquals(5, searchObject1.getTestSuite(loopytoy7.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(loopytoy8.getRoot(), loopCoverage).size());
	}
	
	@Test
	public void testBfs0LoopCoverage() {
		searchObject1 = new BreadthFirstSearch();
		int loopCoverage = 0;
		
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy4.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy5.getRoot(), loopCoverage).size());
		Assert.assertEquals(1, searchObject1.getTestSuite(loopytoy6.getRoot(), loopCoverage).size());
		Assert.assertEquals(5, searchObject1.getTestSuite(loopytoy7.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(loopytoy8.getRoot(), loopCoverage).size());
	}
	
	@Test
	public void testDfs1LoopCoverage() {
		searchObject1 = new DepthFirstSearch();
		int loopCoverage = 1;
		
		// Graphs with no loops.
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(6, searchObject1.getTestSuite(iaronEasytoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronEasytoy4.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy5.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronMediumtoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronMediumtoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(10, searchObject1.getTestSuite(iaronMediumtoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(iaronMediumtoy4.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronDifficulttoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(6, searchObject1.getTestSuite(iaronDifficulttoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(10, searchObject1.getTestSuite(iaronDifficulttoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(12, searchObject1.getTestSuite(iaronDifficulttoy4.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(simpleExample.getRoot(), loopCoverage).size());
		Assert.assertEquals(128, searchObject1.getTestSuite(sonicHedgehog.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(lifeNutshell.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(darkSoulsChest.getRoot(), loopCoverage).size());
		
		// Graphs with loops.
		Assert.assertEquals(2, searchObject1.getTestSuite(loopytoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(3, searchObject1.getTestSuite(loopytoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(3, searchObject1.getTestSuite(loopytoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(loopytoy4.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(loopytoy5.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(loopytoy6.getRoot(), loopCoverage).size());
		Assert.assertEquals(9, searchObject1.getTestSuite(loopytoy7.getRoot(), loopCoverage).size());
		Assert.assertEquals(19, searchObject1.getTestSuite(loopytoy8.getRoot(), loopCoverage).size());
	}
	
	@Test
	public void testBfs1LoopCoverage() {
		searchObject1 = new BreadthFirstSearch();
		int loopCoverage = 1;
		
		// Graphs with no loops.
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(6, searchObject1.getTestSuite(iaronEasytoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronEasytoy4.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(iaronEasytoy5.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronMediumtoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronMediumtoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(10, searchObject1.getTestSuite(iaronMediumtoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(iaronMediumtoy4.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(iaronDifficulttoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(6, searchObject1.getTestSuite(iaronDifficulttoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(10, searchObject1.getTestSuite(iaronDifficulttoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(12, searchObject1.getTestSuite(iaronDifficulttoy4.getRoot(), loopCoverage).size());
		
		Assert.assertEquals(4, searchObject1.getTestSuite(simpleExample.getRoot(), loopCoverage).size());
		Assert.assertEquals(128, searchObject1.getTestSuite(sonicHedgehog.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(lifeNutshell.getRoot(), loopCoverage).size());
		Assert.assertEquals(7, searchObject1.getTestSuite(darkSoulsChest.getRoot(), loopCoverage).size());
		
		// Graphs with loops.
		Assert.assertEquals(2, searchObject1.getTestSuite(loopytoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(3, searchObject1.getTestSuite(loopytoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(3, searchObject1.getTestSuite(loopytoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(loopytoy4.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(loopytoy5.getRoot(), loopCoverage).size());
		Assert.assertEquals(2, searchObject1.getTestSuite(loopytoy6.getRoot(), loopCoverage).size());
		Assert.assertEquals(9, searchObject1.getTestSuite(loopytoy7.getRoot(), loopCoverage).size());
		Assert.assertEquals(19, searchObject1.getTestSuite(loopytoy8.getRoot(), loopCoverage).size());
	}
	
	@Test
	public void testEquality2LoopCoverage() {
		searchObject1 = new BreadthFirstSearch();
		searchObject2 = new DepthFirstSearch();
		int loopCoverage = 2;
		
		// Graphs with loops.
		Assert.assertEquals(searchObject2.getTestSuite(loopytoy1.getRoot(), loopCoverage).size(), searchObject1.getTestSuite(loopytoy1.getRoot(), loopCoverage).size());
		Assert.assertEquals(searchObject2.getTestSuite(loopytoy2.getRoot(), loopCoverage).size(), searchObject1.getTestSuite(loopytoy2.getRoot(), loopCoverage).size());
		Assert.assertEquals(searchObject2.getTestSuite(loopytoy3.getRoot(), loopCoverage).size(), searchObject1.getTestSuite(loopytoy3.getRoot(), loopCoverage).size());
		Assert.assertEquals(searchObject2.getTestSuite(loopytoy4.getRoot(), loopCoverage).size(), searchObject1.getTestSuite(loopytoy4.getRoot(), loopCoverage).size());
		Assert.assertEquals(searchObject2.getTestSuite(loopytoy5.getRoot(), loopCoverage).size(), searchObject1.getTestSuite(loopytoy5.getRoot(), loopCoverage).size());
		Assert.assertEquals(searchObject2.getTestSuite(loopytoy6.getRoot(), loopCoverage).size(), searchObject1.getTestSuite(loopytoy6.getRoot(), loopCoverage).size());
		Assert.assertEquals(searchObject2.getTestSuite(loopytoy7.getRoot(), loopCoverage).size(), searchObject1.getTestSuite(loopytoy7.getRoot(), loopCoverage).size());
		Assert.assertEquals(searchObject2.getTestSuite(loopytoy8.getRoot(), loopCoverage).size(), searchObject1.getTestSuite(loopytoy8.getRoot(), loopCoverage).size());
	}
}
