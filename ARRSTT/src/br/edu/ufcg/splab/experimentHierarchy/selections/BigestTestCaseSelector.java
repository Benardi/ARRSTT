package br.edu.ufcg.splab.experimentHierarchy.selections;

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
	
	private int getMaxTestCaseBySize(TestSuite testSuite) {
		int max = 0;
		for (int i = 0; i < testSuite.size(); i++)
			if (testSuite.get(i).size() > testSuite.get(max).size())
				max = i;
		
		return max;
	}

	@Override
	public TestSuite select() {
		int quantChosen = 0;
		TestSuite copy = new TestSuite(testSuite);
		TestSuite chosen = new TestSuite();
		
		while (quantChosen != quantityOfCases) {
			int max = getMaxTestCaseBySize(copy);
			chosen.add(copy.get(max));
			copy.remove(max);
			quantChosen++;
		}
		
		return chosen;
	}
}