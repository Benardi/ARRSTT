package br.edu.ufcg.splab.experiment_hierarchy.core.artifacts;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;

public class TreatmentArtifact {
	private ExecutableTreatment target;
	private List<InterfaceDvc> dvcs;
	
	public TreatmentArtifact(ExecutableTreatment target, List<InterfaceDvc> dvcs) {
		this.target = target;
		this.dvcs = dvcs;
	}
	
	public StringBuffer getDVCResults(){
		StringBuffer result = new StringBuffer();
		for(InterfaceDvc dvc : dvcs){
			result.append(dvc.collect(target.execute()) + "/");
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
