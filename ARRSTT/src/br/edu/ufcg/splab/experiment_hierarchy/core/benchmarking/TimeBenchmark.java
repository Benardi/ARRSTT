package br.edu.ufcg.splab.experiment_hierarchy.core.benchmarking;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
public class TimeBenchmark implements InterfaceBenchmark {
	private long initialTime;
	
	public TimeBenchmark() {
		this.initialTime = 0;
	}
	
	@Override
	public void startBenchmark() {
		this.initialTime = System.nanoTime();
	}

	@Override
	public String endBenchmark() {
		return (System.nanoTime() - initialTime) + "";
	}
	
	
	
}
