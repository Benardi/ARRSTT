package br.edu.ufcg.splab.framework.core.treatments;

import br.edu.ufcg.splab.framework.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.framework.techniques.generation.InterfaceGenerationTechnique;
import br.edu.ufcg.splab.graph.core.InterfaceVertex;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Documentation												Benardi Nunes		2015-05-24
 * 
 */
/**
 * <b>Objective:</b> Objects of this class represent executable treatments and
 * are therefore capable of generating a test suite through the use of a given
 * graph's root. <br>
 * <b>Description of use:</b> This class can be used in any experiment that
 * needs graph generation since the execute() method creates a TestSuite.
 */
public class GenerationTreatment implements ExecutableTreatment {
	// TODO The rest of the Javadoc.

	private InterfaceGenerationTechnique searchObject;
	private InterfaceVertex root;
	private TestSuite testSuite;
	private int loopCoverage;

	/**
	 * Creates a GenerationTreatment Object with the generation algorithm, a
	 * graph's root and the loop coverage number
	 * 
	 * @param generationObject
	 *            The generation algorithm
	 * @param root
	 *            The root of the graph that represents an execution
	 * @param loopCoverage
	 *            The number of times a trasition can appear in the TestSuite.
	 */
	public GenerationTreatment(InterfaceGenerationTechnique generationObject, InterfaceVertex root, int loopCoverage) {
		this.searchObject = generationObject;
		this.loopCoverage = loopCoverage;
		this.root = root;

		testSuite = new TestSuite();
	}

	/**
	 * Returns the number of loop coverage.
	 * 
	 * @return number of loop coverage.
	 */

	public int getLoopCoverage() {
		return loopCoverage;
	}

	/**
	 * Overwrites the number of loop coverage.
	 * 
	 * @param loopCoverage
	 *            the new number of loop coverage.
	 */
	public void setLoopCoverage(int loopCoverage) {
		this.loopCoverage = loopCoverage;
	}

	/**
	 * Return the root associated to the TreatmentSearch
	 * 
	 * @return the root.
	 */
	public InterfaceVertex getRoot() {
		return root;
	}

	/**
	 * Overwrite the graph associated to the TreatmentSearch.
	 * 
	 * @param graph
	 *            the new graph.
	 */
	public void setRoot(InterfaceVertex root) {
		this.root = root;
	}

	/**
	 * 
	 * @return the test suite associated to the TreatmentSearch.
	 */
	public TestSuite getTestSuite() {
		return testSuite;
	}

	@Override
	/**
	 * <b>Objective:</b> This class generates a TestSuite based on the graph
	 * received by construction, the generation algorithm and the loop coverage.
	 * <br>
	 * <b>Exemple of use:</b> When the data of a certain generation algorithm,
	 * loop coverage and graph needs to be saved for an experiment, this class
	 * is used and the generation happens through this method.
	 * 
	 * @return the generated TestSuite
	 */
	public TestSuite execute() {
		testSuite = searchObject.getTestSuite(root, loopCoverage);
		return testSuite;
	}
}
