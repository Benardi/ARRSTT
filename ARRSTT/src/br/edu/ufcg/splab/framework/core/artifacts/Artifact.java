package br.edu.ufcg.splab.framework.core.artifacts;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.framework.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.framework.core.dvcs.benchmarks.InterfaceBenchmark;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class Artifact {
	private ExecutableTreatment target;
	private List<InterfaceDvc> dvcs;
	private List<InterfaceBenchmark> benchmarks;
	
	public Artifact(ExecutableTreatment target, List<InterfaceDvc> dvcs) {
		this.target = target;
		this.dvcs = dvcs;
		this.benchmarks = createBenchmarkList(dvcs);
	}
	
	public StringBuffer getDVCResults(){
		StringBuffer result = new StringBuffer();
		
		for (InterfaceBenchmark benchmark : benchmarks) {
			benchmark.startBenchmark();
		}
		
		TestSuite resultTestSuite = target.execute();
		
		for (InterfaceBenchmark benchmark : benchmarks) {
			benchmark.endBenchmark();
		}
		
		for(InterfaceDvc dvc : dvcs){
			result.append(dvc.collect(resultTestSuite).toString().replaceAll(",", ".") + "meu_divisor");
		}
		return result;
	}
	
	public ExecutableTreatment getTarget() {
		return target;
	}
	
	public List<InterfaceDvc> getDvcs() {
		return dvcs;
	}

	private List<InterfaceBenchmark> createBenchmarkList(List<InterfaceDvc> dvcs) {
		List<InterfaceBenchmark> benchmarks = new ArrayList<InterfaceBenchmark>();
		
		for (InterfaceDvc dvc : dvcs) {
			if (dvc instanceof InterfaceBenchmark) {
				benchmarks.add((InterfaceBenchmark) dvc);
			}
		}
		
		return benchmarks;
	}
}
