package br.edu.ufcg.splab.framework.core.dvcs.benchmarks;

import br.edu.ufcg.splab.util.testcollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
public class TimeBenchmark implements InterfaceBenchmark {
	private long time;
	
	public TimeBenchmark() {
		this.time = 0;
	}
	
	@Override
	public void startBenchmark() {
		this.time = System.nanoTime();
	}

	@Override
	public void endBenchmark() {
		time = System.nanoTime() - time;
	}

	@Override
	public StringBuffer collect(TestSuite testSuite) {
		return new StringBuffer(time + "");
	}
}
