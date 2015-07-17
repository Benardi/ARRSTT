package br.edu.ufcg.splab.selections;

import java.util.Random;

import br.edu.ufcg.splab.util.TestSuite;

public class RandomizedTestCaseSelection implements InterfaceTestCaseSelector {
	private TestSuite ts;
	private int howMany;
	private Random randomizer;

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
		while (chosen.size() < howMany) {
			int choice = randomizer.nextInt(ts.size());
			if (!chosen.contains(ts.get(choice))) {
				chosen.add(ts.get(choice));
			}
		}
		return chosen;
	}
}