package br.edu.ufcg.splab.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.splab.experiment.core.combinators.ExperimentSetUp;
import br.edu.ufcg.splab.experiment.core.combinators.Combinable;
import br.edu.ufcg.splab.experiment.core.factors.FactorSearch;
import br.edu.ufcg.splab.experiment.core.factors.InterfaceFactor;
import br.edu.ufcg.splab.experiment.core.treatments.InterfaceTreatment;
import br.edu.ufcg.splab.experiment.core.treatments.Treatment;
import br.edu.ufcg.splab.searchs.BreadthFirstSearch;
import br.edu.ufcg.splab.searchs.DepthFirstSearch;
import br.edu.ufcg.splab.searchs.InterfaceSearch;


public class TestCombinator {
	
	private Combinable combinator;
	private List<InterfaceFactor<?>> factors;
	private InterfaceFactor<InterfaceSearch> factor1, factor2, factor3, factor4, factor5;
	private List<InterfaceTreatment<InterfaceSearch>> treatments1, treatments2, treatments3, treatments4, treatments5;
	private InterfaceTreatment<InterfaceSearch> tDfs1, tDfs2, tDfs3, tDfs4, tDfs5, tBfs1, tBfs2, tBfs3, tBfs4, tBfs5;
	private InterfaceSearch dfs1, dfs2, dfs3, dfs4, dfs5, bfs1, bfs2, bfs3, bfs4, bfs5;
	
	
	@Before
	public void createObjs(){
		
		dfs1 = new DepthFirstSearch();
		dfs2 = new DepthFirstSearch();
		dfs3 = new DepthFirstSearch();
		dfs4 = new DepthFirstSearch();
		dfs5 = new DepthFirstSearch();
		
		bfs1 = new BreadthFirstSearch();
		bfs2 = new BreadthFirstSearch();
		bfs3 = new BreadthFirstSearch();
		bfs4 = new BreadthFirstSearch();
		bfs5 = new BreadthFirstSearch();
		
		tDfs1 = new Treatment<>(dfs1);
		tDfs2 = new Treatment<>(dfs2);
		tDfs3 = new Treatment<>(dfs3);
		tDfs4 = new Treatment<>(dfs4);
		tDfs5 = new Treatment<>(dfs5);
		
		tBfs1 = new Treatment<>(bfs1);
		tBfs2 = new Treatment<>(bfs2);
		tBfs3 = new Treatment<>(bfs3);
		tBfs4 = new Treatment<>(bfs4);
		tBfs5 = new Treatment<>(bfs5);
		
		//BFS first
		treatments1 = new ArrayList<>();
		treatments1.add(tBfs1);
		treatments1.add(tDfs1);
		
		treatments2 = new ArrayList<>();
		treatments2.add(tBfs2);
		treatments2.add(tDfs2);
		
		treatments3 = new ArrayList<>();
		treatments3.add(tBfs3);
		
		//DFS first
		treatments4 = new ArrayList<>();
		treatments4.add(tDfs4);
		treatments4.add(tBfs4);
		
		treatments5 = new ArrayList<>();
		treatments5.add(tDfs5);
		
		factor1 = new FactorSearch(treatments1);
		factor2 = new FactorSearch(treatments2);
		factor3 = new FactorSearch(treatments3);
		factor4 = new FactorSearch(treatments4);
		factor5 = new FactorSearch(treatments5);
		
		factors = new ArrayList<>();
		combinator = new ExperimentSetUp(factors);
		
	}
	
	@Test
	public void testEmpty(){
		List<List<InterfaceTreatment<?>>> combination;
		combination = combinator.combine();
		Assert.assertTrue(combination.isEmpty());
	}
	
	@Test
	public void testBinaryFactor(){
		List<List<InterfaceTreatment<?>>> combination;
		
		factors.add(factor1);
		combination = combinator.combine();
		Assert.assertEquals(tBfs1, combination.get(0).get(0));
		
		Assert.assertEquals(tDfs1, combination.get(1).get(0));
		
		factors.add(factor2);
		combination = combinator.combine();
		Assert.assertEquals(tBfs1, combination.get(0).get(0));
		Assert.assertEquals(tBfs2, combination.get(0).get(1));
		
		Assert.assertEquals(tBfs1, combination.get(1).get(0));
		Assert.assertEquals(tDfs2, combination.get(1).get(1));
		
		Assert.assertEquals(tDfs1, combination.get(2).get(0));
		Assert.assertEquals(tBfs2, combination.get(2).get(1));
		
		Assert.assertEquals(tDfs1, combination.get(3).get(0));
		Assert.assertEquals(tDfs2, combination.get(3).get(1));
		
		factors.add(factor4);
		combination = combinator.combine();
		Assert.assertEquals(tBfs1, combination.get(0).get(0));
		Assert.assertEquals(tBfs2, combination.get(0).get(1));
		Assert.assertEquals(tDfs4, combination.get(0).get(2));
		
		Assert.assertEquals(tBfs1, combination.get(1).get(0));
		Assert.assertEquals(tBfs2, combination.get(1).get(1));
		Assert.assertEquals(tBfs4, combination.get(1).get(2));
		
		Assert.assertEquals(tBfs1, combination.get(2).get(0));
		Assert.assertEquals(tDfs2, combination.get(2).get(1));
		Assert.assertEquals(tDfs4, combination.get(2).get(2));
		
		Assert.assertEquals(tBfs1, combination.get(3).get(0));
		Assert.assertEquals(tDfs2, combination.get(3).get(1));
		Assert.assertEquals(tBfs4, combination.get(3).get(2));
		
		Assert.assertEquals(tDfs1, combination.get(4).get(0));
		Assert.assertEquals(tBfs2, combination.get(4).get(1));
		Assert.assertEquals(tDfs4, combination.get(4).get(2));
		
		Assert.assertEquals(tDfs1, combination.get(5).get(0));
		Assert.assertEquals(tBfs2, combination.get(5).get(1));
		Assert.assertEquals(tBfs4, combination.get(5).get(2));
		
		Assert.assertEquals(tDfs1, combination.get(6).get(0));
		Assert.assertEquals(tDfs2, combination.get(6).get(1));
		Assert.assertEquals(tDfs4, combination.get(6).get(2));
		
		Assert.assertEquals(tDfs1, combination.get(7).get(0));
		Assert.assertEquals(tDfs2, combination.get(7).get(1));
		Assert.assertEquals(tBfs4, combination.get(7).get(2));		
				
	}
	
	@Test
	public void testUnaryFactor(){
		List<List<InterfaceTreatment<?>>> combination;
		
		factors.add(factor3);
		combination = combinator.combine();
		Assert.assertEquals(tBfs3, combination.get(0).get(0));
		
		factors.add(factor5);
		combination = combinator.combine();
		Assert.assertEquals(tBfs3, combination.get(0).get(0));
		Assert.assertEquals(tDfs5, combination.get(0).get(1));
	}
	
	@Test
	public void testMixtureFactor1(){
		List<List<InterfaceTreatment<?>>> combination;
		
		factors.add(factor3);
		factors.add(factor5);
		factors.add(factor1);
		combination = combinator.combine();
		Assert.assertEquals(tBfs3, combination.get(0).get(0));
		Assert.assertEquals(tDfs5, combination.get(0).get(1));
		Assert.assertEquals(tBfs1, combination.get(0).get(2));
		
		Assert.assertEquals(tBfs3, combination.get(1).get(0));
		Assert.assertEquals(tDfs5, combination.get(1).get(1));
		Assert.assertEquals(tDfs1, combination.get(1).get(2));	
		
	}
	
	@Test
	public void testMixtureFactor2(){
		List<List<InterfaceTreatment<?>>> combination;
		
		factors.add(factor3);
		factors.add(factor1);
		factors.add(factor5);
		combination = combinator.combine();
		Assert.assertEquals(tBfs3, combination.get(0).get(0));
		Assert.assertEquals(tBfs1, combination.get(0).get(1));
		Assert.assertEquals(tDfs5, combination.get(0).get(2));
		
		Assert.assertEquals(tBfs3, combination.get(1).get(0));
		Assert.assertEquals(tDfs1, combination.get(1).get(1));
		Assert.assertEquals(tDfs5, combination.get(1).get(2));	
		
	}
	
	@Test
	public void testMixtureFactor3(){
		List<List<InterfaceTreatment<?>>> combination;
		
		factors.add(factor1);
		factors.add(factor3);
		factors.add(factor5);
		combination = combinator.combine();
		Assert.assertEquals(tBfs1, combination.get(0).get(0));
		Assert.assertEquals(tBfs3, combination.get(0).get(1));
		Assert.assertEquals(tDfs5, combination.get(0).get(2));
		
		Assert.assertEquals(tDfs1, combination.get(1).get(0));
		Assert.assertEquals(tBfs3, combination.get(1).get(1));
		Assert.assertEquals(tDfs5, combination.get(1).get(2));	
		
	}

}
