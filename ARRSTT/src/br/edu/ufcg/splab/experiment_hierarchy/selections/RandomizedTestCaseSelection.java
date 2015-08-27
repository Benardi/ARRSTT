package br.edu.ufcg.splab.experiment_hierarchy.selections;

import java.util.Random;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class RandomizedTestCaseSelection implements InterfaceTestCaseSelector {
	private Random randomizer;

	public RandomizedTestCaseSelection() {
		this.randomizer = new Random();
	}

	@Override
	public TestSuite select(TestSuite testSuite, Double percentage) {
		int howMany = getAmountOfTestCases(testSuite, percentage);
		TestSuite helper = new TestSuite();
		helper.addAll(testSuite);
		TestSuite chosen = new TestSuite();

		while (chosen.size() < howMany) {
			int choice = randomizer.nextInt(helper.size());
			if (!chosen.contains(helper.get(choice))) {
				TestCase theOne = helper.get(choice);
				chosen.add(theOne);
				helper.remove(theOne);

			}
		}
		return chosen;
	}

	private int getAmountOfTestCases(TestSuite ts, Double percentage) {
		return (int) Math.ceil(ts.size() * percentage);
	}
}