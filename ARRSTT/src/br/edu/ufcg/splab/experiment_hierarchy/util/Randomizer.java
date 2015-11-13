package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.util.List;
import java.util.Random;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class Randomizer {
	
	public static TestCase getRandomTestCase(List<TestCase> tCases){
		Random r = new Random();
		int n = r.nextInt(tCases.size());
		return tCases.get(n);
	}
	
	
}
