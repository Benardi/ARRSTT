package br.edu.ufcg.splab.gambiarra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

public class DataGatherer {
	private List<TestSuite> tsList;
	
	public DataGatherer(List<TestSuite> tsList){
		this.tsList = new ArrayList<>();
		this.tsList = tsList;
	}
	
	public void setTsList(List<TestSuite> tsList){
		this.tsList = tsList;
	}
	
	
	
	// - quantidade de test suites
	public int getTestSuiteQuantity(){
		return tsList.size();
	}
	
	// are we using the test suite id?
	// - quantidade de test cases em todas as testSuites
	public int getTotalTestCaseQuantity(){
		int qnt = 0;
		for(TestSuite ts : tsList){
			qnt += ts.size();
		}
		return qnt;
	}
	
	// - quantidade de test cases em casa test suite
	public Map<TestSuite, Integer> getTestCaseQuantities(){
		Map<TestSuite, Integer> map = new HashMap<>();
		for(TestSuite ts : tsList){
			map.put(ts, ts.size());
		}
		return map;
	}
	
	// - media max e min da quantidade de steps
	public Map<TestSuite, MediaMaxMin> getMediaMaxMins(){
		Map<TestSuite, MediaMaxMin> map = new HashMap<>();
		int min, max, tcsize;
		double sum;
		List<TestCase> tcList;
		for(TestSuite ts : tsList){
			tcList = ts.getTestSuite();
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			sum = 0;
			for(TestCase tc : tcList){
				tcsize = tc.size();
				if(tcsize < min) min = tcsize;
				if(tcsize > max) max = tcsize;
				sum += tcsize;
			}
			map.put(ts, new MediaMaxMin(sum/ts.size(), max, min));
		}
		return map;
	}
	
	// - media max e min total da quantidade de steps 
	public MediaMaxMin getTotalMediaMaxMins(){
		int min, max, tcAmount, tcsize;
		double sum;
		List<TestCase> tcList;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		sum = 0;
		tcAmount = 0;
		for(TestSuite ts : tsList){
			tcList = ts.getTestSuite();
			for(TestCase tc : tcList){
				tcsize = tc.size();
				if(tcsize < min) min = tcsize;
				if(tcsize > max) max = tcsize;
				sum += tcsize;
				tcAmount++;
			}
		}
		return new MediaMaxMin(sum/tcAmount, max, min);
	}
	
	public void getTotalRedundance(){
		//TODO
	}
	
	public void getRedundance(){
		//TODO
	}
	
	public void getTotalMostRepeatedTransition(){
		//TODO
	}
	
	public Map<TestSuite, String> getMostRepeatedTransitions(){
		//TODO
	}
	
	private Map<String, Integer> getTransitionsOccurence(TestSuite ts){
		Map<String, Integer> map = new HashMap<>();
		List<TestCase> tcList = ts.getTestSuite();
		int aux;
		for(TestCase tc : tcList){
			for(InterfaceEdge edge : tc){
				if(map.containsKey(edge.getLabel())){
					aux = map.get(edge.getLabel());
					map.put(edge.getLabel(), aux + 1);
				} else {
					map.put(edge.getLabel(), 1);
				}
			}
		}
		return map;
	}

}
