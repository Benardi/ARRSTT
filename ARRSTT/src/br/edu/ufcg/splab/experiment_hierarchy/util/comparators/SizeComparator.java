package br.edu.ufcg.splab.experiment_hierarchy.util.comparators;

import java.util.Comparator;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class SizeComparator implements Comparator<TestSuite>{

	@Override
	public int compare(TestSuite obj1, TestSuite obj2) {
		TestSuite list1 = (TestSuite) obj1;
		TestSuite list2 = (TestSuite) obj2;
		
		if (list1.size() < list2.size())
			return -1;
		else if (list1.size() > list2.size())
			return 1;
		else return 0;
	}
	
}
