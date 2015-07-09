package br.edu.ufcg.splab.experiment.core.treatments;

import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.searchs.InterfaceSearch;
import br.edu.ufcg.splab.util.TestSuite;

/**
 * Objects of this class are executable treatments that
 * use an object capable of generating a test suite of a
 * given graph's root.
 *
 */
public class TreatmentSearch implements ExecutableTreatment {
	private InterfaceSearch searchObject;
	private InterfaceVertex root;
	private TestSuite testSuite;
	private int loopCoverage;
	private String title;
	
	/**
	 * Creates a TreatmentSearch Object with all its possible attributes
	 * initialized.
	 * 
	 * @param searchObject
	 * @param graph
	 * @param loopCoverage
	 * @param title
	 */
	public TreatmentSearch(InterfaceSearch searchObject, InterfaceVertex root, int loopCoverage, String title) {
		this.searchObject = searchObject;
		this.loopCoverage = loopCoverage;
		this.title = title;
		this.root = root;
		
		testSuite = new TestSuite();
	}
	
	/**
	 * Creates a TreatmentSearch Object whose attributes lack a Graph.
	 * 
	 * @param searchObject
	 * @param loopCoverage
	 * @param title
	 */
	public TreatmentSearch(InterfaceSearch searchObject, int loopCoverage, String title) {
		this(searchObject, null, loopCoverage, title);
	}
	
	/**
	 * Creates a TreatmentSearch Object which possess only a title.
	 * 
	 * @param title
	 */
	public TreatmentSearch(String title) {
		this(null, null, 0, title);
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
		return title;
	}
	
	/**
	 * Overwrite the title associated to the TreatmentSearch.
	 * 
	 * @param title
	 *            the new title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public TestSuite execute() {
		testSuite = searchObject.getTestSuite(root, loopCoverage);
		return testSuite;
	}
}
