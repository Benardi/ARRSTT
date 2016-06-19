package br.edu.ufcg.splab.experiment_hierarchy.core.artifacts;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.MinimizationTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class TreatmentArtifact {
	private ExecutableTreatment target;
	private List<InterfaceDvc> dvcs;
	
	public TreatmentArtifact(ExecutableTreatment target, List<InterfaceDvc> dvcs) {
		this.target = target;
		this.dvcs = dvcs;
	}
	
	public StringBuffer getDVCResults(){
		StringBuffer result = new StringBuffer();
		// TESTE
		TestSuite resultTestSuite = target.execute();
		
		for(InterfaceDvc dvc : dvcs){
			result.append(dvc.collect(resultTestSuite) + "/");
		}
		return result;
	}
	
	public ExecutableTreatment getTarget() {
		return target;
	}
	
	public List<InterfaceDvc> getDvcs() {
		return dvcs;
	}

}
