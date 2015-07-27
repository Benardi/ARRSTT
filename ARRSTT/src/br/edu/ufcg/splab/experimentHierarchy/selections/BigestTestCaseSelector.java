package br.edu.ufcg.splab.experimentHierarchy.selections;

import java.util.Collections;
import java.util.List;

import br.edu.ufcg.splab.experimentHierarchy.util.comparators.SizeComparator;
import br.edu.ufcg.splab.experimentHierarchy.util.testcollections.TestSuite;

public class BigestTestCaseSelector implements InterfaceTestCaseSelector{
	private TestSuite testSuite;
	private int quantityOfCases;
	
	public BigestTestCaseSelector(TestSuite testSuite, double percentage) {
		this.testSuite = testSuite;
		this.quantityOfCases = getQuantity(percentage);
	}

	private int getQuantity(double percentage) {
		return (int) Math.ceil(testSuite.size() * percentage);
	}

	@Override
	public TestSuite select() {
		TestSuite copy = new TestSuite(testSuite);
		TestSuite selections = new TestSuite();
		
		Collections.sort((List)copy, new SizeComparator());
		
		for(int i = 0; i < quantityOfCases; i++)
			selections.add(copy.get(copy.size() - 1 - i));
		
		return selections;
	}
}