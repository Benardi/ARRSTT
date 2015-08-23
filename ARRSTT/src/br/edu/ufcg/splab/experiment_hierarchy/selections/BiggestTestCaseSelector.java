package br.edu.ufcg.splab.experiment_hierarchy.selections;

import java.util.Collections;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.util.comparators.SizeComparator;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class BiggestTestCaseSelector implements InterfaceTestCaseSelector{
	
	public BiggestTestCaseSelector() {

	}

	private int getQuantity(TestSuite testSuite, double percentage) {
		return (int) Math.ceil(testSuite.size() * percentage);
	}

	@Override
	public TestSuite select(TestSuite testSuite, Double percentage) {
		int quantityOfTC;
		quantityOfTC = getQuantity(testSuite ,percentage);
		
		TestSuite copy = new TestSuite(testSuite);
		TestSuite selections = new TestSuite();
		
		Collections.sort((List)copy, new SizeComparator());
		
		for(int i = 0; i < quantityOfTC; i++)
			selections.add(copy.get(copy.size() - 1 - i));
		
		return selections;
	}

}