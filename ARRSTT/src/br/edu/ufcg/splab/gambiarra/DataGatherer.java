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

	public DataGatherer(List<TestSuite> tsList) {
		this.tsList = new ArrayList<>();
		this.tsList = tsList;
	}

	public void setTsList(List<TestSuite> tsList) {
		this.tsList = tsList;
	}

	// - quantidade de test suites
	public int getTestSuiteQuantity() {
		return tsList.size();
	}

	// are we using the test suite id?
	// - quantidade de test cases em todas as testSuites
	public int getTotalTestCaseQuantity() {
		int qnt = 0;
		for (TestSuite ts : tsList) {
			qnt += ts.size();
		}
		return qnt;
	}

	// - quantidade de test cases em casa test suite
	public Map<TestSuite, Integer> getTestCaseQuantities() {
		Map<TestSuite, Integer> map = new HashMap<>();
		for (TestSuite ts : tsList) {
			map.put(ts, ts.size());
		}
		return map;
	}

	// - media max e min da quantidade de steps
	public Map<TestSuite, MediaMaxMin> getMediaMaxMins() {
		Map<TestSuite, MediaMaxMin> map = new HashMap<>();
		int min, max, tcsize;
		double sum;
		List<TestCase> tcList;
		for (TestSuite ts : tsList) {
			tcList = ts.getTestSuite();
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			sum = 0;
			for (TestCase tc : tcList) {
				tcsize = tc.size();
				if (tcsize < min)
					min = tcsize;
				if (tcsize > max)
					max = tcsize;
				sum += tcsize;
			}
			map.put(ts, new MediaMaxMin(sum / ts.size(), max, min));
		}
		return map;
	}

	// - media max e min total da quantidade de steps
	public MediaMaxMin getTotalMediaMaxMins() {
		int min, max, tcAmount, tcsize;
		double sum;
		List<TestCase> tcList;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		sum = 0;
		tcAmount = 0;
		for (TestSuite ts : tsList) {
			tcList = ts.getTestSuite();
			for (TestCase tc : tcList) {
				tcsize = tc.size();
				if (tcsize < min)
					min = tcsize;
				if (tcsize > max)
					max = tcsize;
				sum += tcsize;
				tcAmount++;
			}
		}
		return new MediaMaxMin(sum / tcAmount, max, min);
	}

	public int getTotalRedundance() {
		int howRedudant = 0;
		for (int i = 0; i < tsList.size(); i++) {
			TestSuite tsSuite = tsList.get(i);
			Map<String, Integer> map = this.getTransitionsOccurrence(tsSuite);
			for (int j = 0; j < tsSuite.size(); j++) {
				TestCase tsCase = tsSuite.get(j);
				List<InterfaceEdge> transitions = tsCase.getTestCase();
				for (int z = 0; z < transitions.size(); z++) {
					InterfaceEdge thisOne = transitions.get(z);
					int value = map.get(thisOne.getLabel());
					/*
					 * Iaron aqui: Alterei o valor abaixo pra 1, e fiz howRedundant += value -1
					 * Fiz isso pois só é redundante quando ele aparece mais de uma vez
					 */
					if (value >= 1) {
						howRedudant += value - 1;
					}
				}

			}
		}
		return howRedudant;
	}

	public void getRedundance() {
			
	}

	public InterfaceEdge getTotalMostRepeatedTransition() {
		InterfaceEdge mostRepeated = null;

		for (int i = 0; i < this.tsList.size(); i++) {
			TestSuite tsSuite = tsList.get(i);
			Map<String, Integer> map = this.getTransitionsOccurrence(tsSuite);
			for (int j = 0; j < tsSuite.size(); j++) {
				TestCase tsCase = tsSuite.get(j);
				List<InterfaceEdge> transitions = tsCase.getTestCase();
				for (int z = 0; z < transitions.size(); z++) {
					InterfaceEdge thisOne = transitions.get(z);
					int value = map.get(thisOne.getLabel());
					if (mostRepeated == null || value > map.get(mostRepeated.getLabel())) {
						mostRepeated = thisOne;
					}
				}

			}
		}
		return mostRepeated;

	}

	public InterfaceEdge getMostRepeatedTransition(TestSuite ts) {
		Map<String, Integer> map = this.getTransitionsOccurrence(ts);
		InterfaceEdge mostRepeated = null;

			for (int i = 0; i < ts.size(); i++) {
				TestCase tsCase = ts.get(i);
				List<InterfaceEdge> transitions = tsCase.getTestCase();
				for (int j = 0; j < transitions.size(); j++) {
					InterfaceEdge thisOne = transitions.get(j);
					int value = map.get(thisOne.getLabel());
					if (mostRepeated == null || value > map.get(mostRepeated.getLabel())) {
						mostRepeated = thisOne;
					}
				}

			}
		
		return mostRepeated;

	}

	public Map<String, Integer> getMostRepeatedTransitions() {
		Map<String, Integer> theMap = new HashMap<>();
		for (int i = 0; i < this.tsList.size(); i++) {
			TestSuite ts = tsList.get(i);
			Map<String, Integer> map = this.getTransitionsOccurrence(ts);
			InterfaceEdge edge= this.getMostRepeatedTransition(ts);
			theMap.put(edge.getLabel(),map.get(edge.getLabel()));

		}
		return theMap;
	}

	public Map<String, Integer> getTransitionsOccurrence(TestSuite ts) {
		Map<String, Integer> map = new HashMap<>();
		List<TestCase> tcList = ts.getTestSuite();
		int aux;
		for (TestCase tc : tcList) {
			for (InterfaceEdge edge : tc) {
				if (map.containsKey(edge.getLabel())) {
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
