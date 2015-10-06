package br.edu.ufcg.splab.experiment_hierarchy.searches;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-05-07
 * 
 */
/**
 * <b>Objective:</b> This interface represents a TestSuite generation algorithm that
 * is based on graph searches.
 * <br>
 * <b>Description of use:</b> This interface is used to generate a TestSuite from a graph.
 *
 */
public interface InterfaceSearch {
	/**
	 * <b>Objective:</b> Generates a graph's TestSuite.
	 * <br>
	 * <b>Exemple of use:</b> In the ARRSTT Generation experiment to compare TestSuite's
	 * generation algorithms.
	 * @param root
	 * 			The graph's root.
	 * @param loopCoverage
	 * 			The loop coverage considered to generate the TestSuite.
	 * @return The graph's TestSuite.
	 */
	public TestSuite getTestSuite(InterfaceVertex root, int loopCoverage);
	
	@Deprecated
	public String getName();
}