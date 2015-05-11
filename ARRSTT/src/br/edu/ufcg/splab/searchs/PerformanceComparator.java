package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.Date;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.util.TestCase;

public class PerformanceComparator {
	public PerformanceComparator() {
	}

	public long responseTime(InterfaceVertex root, int nLoopCoverage,
			InterfaceSearch method) {
		long startTime = new Date().getTime();
		method.getTestSuite(root, nLoopCoverage);
		long endTime = new Date().getTime();
		long difference = endTime - startTime;
		return difference;

	}

	public InterfaceSearch quickestOne(
			ArrayList<InterfaceSearch> searchMethods, InterfaceVertex root,
			int nLoopCoverage) {
		InterfaceSearch quickestOne = searchMethods.get(0);
		for (int i = 1; i < searchMethods.size(); i++) {
			if (responseTime(root, nLoopCoverage, searchMethods.get(i)) < responseTime(
					root, nLoopCoverage, quickestOne)) {
				quickestOne = searchMethods.get(i);
			}

		}
		return quickestOne;
	}

}
