package br.edu.ufcg.splab.experimentHierarchy.selections;

import java.util.Random;

import br.edu.ufcg.splab.experimentHierarchy.util.testcollections.TestSuite;

public class RandomizedTestCaseSelection implements InterfaceTestCaseSelector {
	private TestSuite ts;
	private int howMany;
	private Random randomizer;

	//Great Creator pattern. Good code organization. Well done.
	public RandomizedTestCaseSelection(TestSuite ts, Double percentage) {
		this.ts = ts;
		this.howMany = getAmountOfTestCases(ts, percentage);
		this.randomizer = new Random();
	}

	private int getAmountOfTestCases(TestSuite ts, Double percentage) {
		return (int) Math.ceil(ts.size() * percentage);
	}

	@Override
	public TestSuite select() {

		TestSuite chosen = new TestSuite();
		//It may reach an infinite loop if it 
		// simply draws the same TC over and over.
		// It is highly unlikely, but not impossible. 
		// Try to manage an updated removal by removing 
		// the TC in each draw. Note that you may need
		// an auxiliary TestSuite for that.
		while (chosen.size() < howMany) {
			int choice = randomizer.nextInt(ts.size());
			if (!chosen.contains(ts.get(choice))) {
				chosen.add(ts.get(choice));
			}
		}
		return chosen;
	}
}