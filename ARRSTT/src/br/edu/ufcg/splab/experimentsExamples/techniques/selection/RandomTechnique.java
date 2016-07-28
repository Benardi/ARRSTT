package br.edu.ufcg.splab.experimentsExamples.techniques.selection;

import java.util.Random;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Bernardi Nunes		2015-08-16
 * 
 */
/**
 * <b>Objective:</b> Generate a sub set that is generated by members of a bigger set
 * selected through a random pattern.
 * <br>
 * <b>Description of use:</b> In the Experiment Factory this class is used in the
 * process of building a selection.
 *
 */
public class RandomTechnique implements InterfaceSelectionTechnique {
	private Random randomizer;

	public RandomTechnique() {
		this.randomizer = new Random();
	}

	@Override
	public TestSuite select(TestSuite testSuite, Double percentage) {
		int howMany = getAmountOfTestCases(testSuite, 1 - percentage);
		
		TestSuite helper = new TestSuite();
		helper.addAll(testSuite.getTestSuite());
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

	/**
	 * <b>Objective:</b> Calculate the dimension of the smaller test suite.
	 * <br>
	 * <b>Exemple of use:</b> This method is used on the select method to help
	 * build the new test suite.
	 *
	 * @param ts
	 *            the original test suite
	 * @param percentage
	 *            the desired percentage of test case.
	 * @return how many shall be selected.
	 */
	private int getAmountOfTestCases(TestSuite ts, Double percentage) {
		return (int) Math.ceil(ts.size() * percentage);
	}
	
	public String getName(){
		return "Random";
	}
}