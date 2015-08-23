package br.edu.ufcg.splab.experiment_hierarchy.selections;

import java.util.Random;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class RandomizedTestCaseSelection implements InterfaceTestCaseSelector {
	private Random randomizer;

	public RandomizedTestCaseSelection() {
		this.randomizer = new Random();
	}


	@Override
	public TestSuite select(TestSuite testSuite, Double percentage) {
		int howMany = getAmountOfTestCases(testSuite, percentage);

		TestSuite chosen = new TestSuite();
		//It may reach an infinite loop if it 
		// simply draws the same TC over and over.
		// It is highly unlikely, but not impossible. 
		// Try to manage an updated removal by removing 
		// the TC in each draw. Note that you may need
		// an auxiliary TestSuite for that.
		while (chosen.size() < howMany) {
			int choice = randomizer.nextInt(testSuite.size());
			if (!chosen.contains(testSuite.get(choice))) {
				chosen.add(testSuite.get(choice));
			}
		}
		return chosen;
	}
	
	private int getAmountOfTestCases(TestSuite ts, Double percentage) {
		return (int) Math.ceil(ts.size() * percentage);
	}
}