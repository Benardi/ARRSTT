package br.edu.ufcg.splab.framework.core.dvcs.benchmarks;

import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;

public interface InterfaceBenchmark extends InterfaceDvc {
	public void startBenchmark();
	public void endBenchmark();
}
