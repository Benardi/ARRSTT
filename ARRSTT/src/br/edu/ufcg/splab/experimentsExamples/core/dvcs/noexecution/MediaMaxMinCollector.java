package br.edu.ufcg.splab.experimentsExamples.core.dvcs.noexecution;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.util.MediaMaxMin;

/**
 * This DVC is responsible to get the size of a TestSuite's smallest
 * TestCase, biggest TestCase and the media size of TestCases.
 */
public class MediaMaxMinCollector implements IDvc {
	private TestSuite originalSuite;
	
	public MediaMaxMinCollector(TestSuite originalSuite) {
		this.originalSuite = originalSuite;
	}
	
	@Override
	public StringBuffer collect(TestSuite finalSuite) {
		MediaMaxMin result = calculate(originalSuite);
		return new StringBuffer("Media: " + result.getMedia()+ " Max: " + result.getMax() + " Min: " + result.getMin());
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
	
	@Override
	public String getName(){
		return "MediaMaxMin";
	}

}
