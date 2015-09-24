package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;
/* Change		Author		Date
 * Creation		Bernardi	2015-05-24
 */
/**
 * Objective: Objects of this class are executable treatments that
 * use an object capable of generating a test suite of a
 * given graph's root.
 * 
 * Description of use: This class can be used in any experiment that 
 * needs graph generation since the execute() method creates a TestSuite.
 */
public class GenerationTreatment implements ExecutableTreatment {
	//TODO The rest of the Javadoc.
	  
	private InterfaceSearch searchObject;
	private InterfaceVertex root;
	private TestSuite testSuite;
	private int loopCoverage;
	
	/**
	 * Creates a GenerationTreatment Object with the generation algorithm,
	 * a graph's root and the loop coverage number
	 * 
	 * @param generationObject
	 * 			The generation algorithm
	 * @param root
	 * 			The root of the graph that represents an execution
	 * @param loopCoverage
	 * 			The number of times a trasition can appear in the TestSuite.
	 */
	public GenerationTreatment(InterfaceSearch generationObject, InterfaceVertex root, int loopCoverage) {
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
	public String getTitle() {
		return "Generation";
	}
	
	@Override
	/**
	 * Objective: This class generates a TestSuite based on the graph
	 * received by construction, the generation algorithm and the loop
	 * coverage.
	 * 
	 * Exemple of use: When the data of a certain generation algorithm, loop
	 * coverage and graph needs to be saved for an experiment, this class
	 * is used and the generation happens through this method.
	 * 
	 * @return the generated TestSuite
	 */
	public TestSuite execute() {
		testSuite = searchObject.getTestSuite(root, loopCoverage);
		return testSuite;
	}
}
