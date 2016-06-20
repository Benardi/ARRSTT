package br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.benchmarks;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;

public interface InterfaceBenchmark extends InterfaceDvc {
	public void startBenchmark();
	public void endBenchmark();
}
