package br.edu.ufcg.splab.experimentsExamples.core.dvcs.noexecution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;

//WORK IN PROGRESS
public class MostRepeatedTransitionCollector implements IDvc {
	private TestSuite originalSuite;
	
	public MostRepeatedTransitionCollector(TestSuite originalSuite) {
		this.originalSuite = originalSuite;
	}
	
	@Override
	public StringBuffer collect(TestSuite finalSuite) {
		String transition = getMostRepeatedTransition(originalSuite);
		return new StringBuffer(transition);
	}
	
	
	//I had to modify this method so it could return a single transition
	private String getMostRepeatedTransition(TestSuite ts) {
		List<InterfaceEdge> mostRepeated = new ArrayList<>();
		int max = 0;
		int occurrence;
		Map<InterfaceEdge, Integer> map = getTransitionsOccurrence(ts);
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
		String result;
		if(mostRepeated.isEmpty()){
			result = "";
		} else {
			result = mostRepeated.get(0).toString();
		}
		return result;
	}
	
	private Map<InterfaceEdge, Integer> getTransitionsOccurrence(TestSuite ts) {
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
	
	@Override
	public String getName(){
		return "Most Repeated Transition";
	}

}
