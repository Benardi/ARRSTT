package br.edu.ufcg.splab.experiment_hierarchy.core.benchmarking;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;

public interface InterfaceBenchmark extends InterfaceDvc {
	public void startBenchmark();
	public void endBenchmark();
}
