package br.edu.ufcg.splab.experiment_hierarchy.core.dvcs;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.gambiarra.MediaMaxMin;

public class ARRSTTMediaMaxMin implements InterfaceDvc {

	@Override
	public StringBuffer collect(TestSuite testSuite) {
		MediaMaxMin result = calculate(testSuite);
		return new StringBuffer("Media: " + result.getMedia()+ "Max: " + result.getMax() + "Min: " + result.getMin());
	}
	
	private MediaMaxMin calculate(TestSuite ts){
		int min, max, tcsize, sum;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		sum = 0;
		
		
		for (TestCase tc : ts.getTestSuite()) {
			tcsize = tc.size();
			if (tcsize < min)
				min = tcsize;
			if (tcsize > max)
				max = tcsize;
			sum += tcsize;
		}
		double media = (1.0 * sum) / ts.size();
		
		return new MediaMaxMin(media, max, min);
	}

}