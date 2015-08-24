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
	public int compare(TestSuite obj1, TestSuite obj2) {
		TestSuite list1 = (TestSuite) obj1;
		TestSuite list2 = (TestSuite) obj2;
		
		return (list1.size() - list2.size()) ;
	}
	
}
