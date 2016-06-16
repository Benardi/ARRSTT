package br.edu.ufcg.splab.experiment_hierarchy.core.benchmarking;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
public class ARRSTTTimeCollector implements InterfaceBenchmark {
	private long time;
	
	public ARRSTTTimeCollector() {
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

	/*@Override
	public StringBuffer collect(Void v) {
		return new StringBuffer(time + "");
	}*/

	@Override
	public StringBuffer collect(TestSuite t) {
		// TODO Auto-generated method stub
		return null;
	}
}
