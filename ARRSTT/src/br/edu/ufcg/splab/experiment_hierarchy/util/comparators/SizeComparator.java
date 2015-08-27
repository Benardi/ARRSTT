package br.edu.ufcg.splab.experiment_hierarchy.util.comparators;

import java.util.Comparator;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/**
 * Comparator of TestSuites.
 *
 */
public class SizeComparator implements Comparator<TestSuite>{

	@Override
	/**
	 * It returns the first TestSuite size minus the second one's size.
	 */
	public int compare(TestSuite ts1, TestSuite ts2) {
		return (ts1.size() - ts2.size()) ;
	}
	
}
