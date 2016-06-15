package br.edu.ufcg.splab.experiment_hierarchy.core.dvcsetup;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;

public class JustDvcSetup implements InterfaceDvcSetup {
	private List<DependentVariableCollector> dvcs;
	
	public JustDvcSetup() {
		dvcs = new ArrayList<DependentVariableCollector>();
	}
	
	
}
