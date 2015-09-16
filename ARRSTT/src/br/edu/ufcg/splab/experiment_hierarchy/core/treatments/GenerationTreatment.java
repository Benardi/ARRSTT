package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;

/**
 * Objects of this class are executable treatments that
 * use an object capable of generating a test suite of a
 * given graph's root.
 *
 */
public class GenerationTreatment implements ExecutableTreatment {
	private InterfaceSearch searchObject;
	private InterfaceVertex root;
	private TestSuite testSuite;
	private int loopCoverage;
	
	/**
	 * Creates a TreatmentSearch Object with all its possible attributes
	 * initialized.
	 * 
	 * @param searchObject
	 * @param graph
	 * @param loopCoverage
	 * @param title
	 */
	public GenerationTreatment(InterfaceSearch searchObject, InterfaceVertex root, int loopCoverage) {
		this.searchObject = searchObject;
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
	public String getTitle() {
		return "Generation";
	}
	
	@Override
	public TestSuite execute() {
		testSuite = searchObject.getTestSuite(root, loopCoverage);
		return testSuite;
	}
}
