package br.edu.ufcg.splab.experiment_hierarchy.core.artifacts;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;

public class TreatmentArtifact {
	private ExecutableTreatment target;
	private List<DependentVariableCollector> dvcs;
	
	public TreatmentArtifact(ExecutableTreatment target, List<DependentVariableCollector> dvcs) {
		this.target = target;
		this.dvcs = dvcs;
	}
	
	public StringBuffer getDVCResults(){
		StringBuffer result = new StringBuffer();
		for(DependentVariableCollector dvc : dvcs){
			result.append(dvc.collect(target.execute()) + "/");
		}
		return result;
	}
	
	public ExecutableTreatment getTarget() {
		return target;
	}
	
	public List<DependentVariableCollector> getDvcs() {
		return dvcs;
	}

}
