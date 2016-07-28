package br.edu.ufcg.splab.experimentsExamples.core.dvcs.benchmarks;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;

/**
 * This DVC is responsible for getting the execution time of
 * an algorithm's execution.
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
