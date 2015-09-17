package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectiveEdgesCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectsCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTFailuresCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTTimeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;

public class DVCFactory {
	
	public DependentVariableCollector createCollector(DVCType type){
		if(type == DVCType.DEFECTIVE_EDGES){
			return new ARRSTTDefectiveEdgesCollector();
		} else if (type == DVCType.DEFECTS){
			return new ARRSTTDefectsCollector();
		} else if (type == DVCType.FAILURES){
			return new ARRSTTFailuresCollector();
		} else if (type == DVCType.SIZE){
			return new ARRSTTSizeCollector();
		} else if (type == DVCType.TIME){
			return new ARRSTTTimeCollector();
		} else {
			return null;
		}		
	}
	
	public List<DependentVariableCollector> createCollectorList(Iterable<DVCType> types){
		List<DependentVariableCollector> dvcs = new ArrayList<>();
		
		for(DVCType type : types){
			dvcs.add(createCollector(type));
		}
		
		return dvcs;
	}

	public List<DependentVariableCollector> createCollectorList(DVCType... types) {
		List<DependentVariableCollector> dvcs = new ArrayList<>();
		
		for(DVCType type : types){
			dvcs.add(createCollector(type));
		}
		
		return dvcs;
	}
}
