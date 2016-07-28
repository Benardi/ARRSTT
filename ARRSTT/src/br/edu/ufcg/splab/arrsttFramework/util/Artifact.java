package br.edu.ufcg.splab.arrsttFramework.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.IExecutableTreatment;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.benchmarks.InterfaceBenchmark;
import br.edu.ufcg.splab.experimentsExamples.util.ArresttConstants;
import br.edu.ufcg.splab.experimentsExamples.util.ResultData;

public class Artifact {
	private IExecutableTreatment target;
	private List<IDvc> dvcs;
	private List<InterfaceBenchmark> benchmarks;
	
	public Artifact(IExecutableTreatment target, List<IDvc> dvcs) {
		this.target = target;
		this.dvcs = dvcs;
		this.benchmarks = createBenchmarkList(dvcs);
	}
	
	public List<ResultData> getDVCResults(){
		List<ResultData> resultPairs = new ArrayList<>();
		
		for (InterfaceBenchmark benchmark : benchmarks) {
			benchmark.startBenchmark();
		}
		
		TestSuite resultTestSuite = target.execute();
		
		for (InterfaceBenchmark benchmark : benchmarks) {
			benchmark.endBenchmark();
		}
		
		for(IDvc dvc : dvcs){
			resultPairs.add(new ResultData(target.getName() ,dvc.collect(resultTestSuite).toString().replaceAll(",", "."), dvc.getName()));
		}
		return resultPairs;
	}
	
	public IExecutableTreatment getTarget() {
		return target;
	}
	
	public List<IDvc> getDvcs() {
		return dvcs;
	}

	private List<InterfaceBenchmark> createBenchmarkList(List<IDvc> dvcs) {
		List<InterfaceBenchmark> benchmarks = new ArrayList<InterfaceBenchmark>();
		
		for (IDvc dvc : dvcs) {
			if (dvc instanceof InterfaceBenchmark) {
				benchmarks.add((InterfaceBenchmark) dvc);
			}
		}
		
		return benchmarks;
	}
}
