package br.edu.ufcg.splab.experiment_hierarchy.core.runners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentFile;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

public class DefaultRunner implements InterfaceRunner {
	private List<DependentVariableCollector> dvcs;
	private List<StringBuffer> stringBuffers;

	public DefaultRunner(List<DependentVariableCollector> dvcs) {
		this.dvcs = dvcs;
		this.stringBuffers = new ArrayList<StringBuffer>();
		
		for (int i = 0; i < dvcs.size(); i++) {
			stringBuffers.add(new StringBuffer());
		}
	}
	
	public void runExperiment(List<Tuple<ExecutableTreatment>> combinations) {
		for (Tuple<ExecutableTreatment> combination : combinations) {
			for (int i = 0; i < dvcs.size(); i++) {
				dvcs.get(i).collect(combination, stringBuffers.get(i));
			}				
		}
		
		saveBuffers();
	}
	
	public List<StringBuffer> getStringBuffers() {
		return stringBuffers;
	}
	
	public void saveBuffers() {
		int n = 0;
		
		for (StringBuffer buffer: stringBuffers) {
			try {
				ExperimentFile file = new ExperimentFile("file" + n);
				file.appendContent(buffer);
				file.save();
				n++;
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
