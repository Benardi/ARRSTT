package br.edu.ufcg.splab.util;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import br.edu.ufcg.splab.util.testcollections.TestCase;

public class Randomizer {
	
	public static TestCase getRandomTestCase(List<TestCase> tCases){
		Random r = new Random();
		int n = r.nextInt(tCases.size());
		return (!tCases.isEmpty()) ? (tCases.get(n)) : (null);
	}
	
	public static TestCase getRandomTestCase(Set<TestCase> tCases) {
		Random r = new Random();
		int n = r.nextInt(tCases.size());
		
		Iterator<TestCase> iterator = tCases.iterator();
		
		for (int i = 0; i < n; i++) {
			iterator.next();
		}
		
		return (iterator.hasNext()) ? (iterator.next()) : (null);
	}
}
