package br.edu.ufcg.splab.gambiarra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

public class DataGathererSingleTS {
	private TestSuite ts;
	
	public DataGathererSingleTS(TestSuite ts){
		this.ts = ts;
	}
	
	public void setTestSuite(TestSuite ts){
		this.ts = ts;
	}
	
	public int getTestCaseQuantity() {
		return ts.size();
	}

	public MediaMaxMin getTotalMediaMaxMins() {
		int min, max, tcsize, sum;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		sum = 0;
		
		
		for (TestCase tc : ts.getTestSuite()) {
			tcsize = tc.size();
			if (tcsize < min)
				min = tcsize;
			if (tcsize > max)
				max = tcsize;
			sum += tcsize;
		}
		double media = (1.0 * sum) / ts.size();
		
		return new MediaMaxMin(media, max, min);
	}


	public double getRedundance() {
		int transitionsQnt = 0;
		Set<InterfaceEdge> uniqueLabels = new HashSet<>();
		for(TestCase tc: ts.getTestSuite()){
			transitionsQnt += tc.size();
			uniqueLabels.addAll(tc.getTestCase());
		}
		
		// tem que fazer - 1 no final?
		double redundance = (1.0 * transitionsQnt)/ uniqueLabels.size();
		return redundance;
		
	}


	public List<InterfaceEdge> getMostRepeatedTransitions() {
		List<InterfaceEdge> mostRepeated = new ArrayList<>();
		int max = 0;
		int occurrence;
		Map<InterfaceEdge, Integer> map = getTransitionsOccurrence();
		Set<InterfaceEdge> keys = map.keySet();
		
		for(InterfaceEdge edge: keys){
			occurrence = map.get(edge);
			if(occurrence > max){
				max = occurrence;
				mostRepeated = new ArrayList<>();
				mostRepeated.add(edge);
			} else if(occurrence == max){
				mostRepeated.add(edge);
			}
		}
		return mostRepeated;
	}


	public Map<InterfaceEdge, Integer> getTransitionsOccurrence() {
		Map<InterfaceEdge, Integer> map = new HashMap<>();
		Integer aux;
		for (TestCase tc : ts.getTestSuite()) {
			for (InterfaceEdge edge : tc.getTestCase()) {
				if (map.containsKey(edge)) {
					aux = map.get(edge);
					map.put(edge, aux + 1);
				} else {
					map.put(edge, 1);
				}
			}
		}
		return map;
	}
	
	// vou fazer da forma ineficiente mesmo
	public double getCoverage(List<InterfaceEdge> transitions){
		int tcThatCovers = 0;
		boolean covers;
		for(TestCase tc : ts.getTestSuite()){
			covers = true;
			for(InterfaceEdge edge : transitions){
				if(!tc.contains(edge)){
					covers = false;
					break;
				}
			}
			if(covers) tcThatCovers++;
		}
		
		double coverage = (1.0 * tcThatCovers) / ts.size();
		return coverage;
	}
}
