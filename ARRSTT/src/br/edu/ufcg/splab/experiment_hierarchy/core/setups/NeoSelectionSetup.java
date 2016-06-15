package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcsetup.InterfaceDvcSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcsetup.NeoSelectionDvcSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class NeoSelectionSetup implements InterfaceSetup{
	private List<SelectionType> selectionAlgorithms;
	private double selectionPercentage;
	private List<TestSuite> testSuites;
	
	@Override
	public List<TreatmentArtifact> getArtifacts() {
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		InterfaceDvcSetup dvcsetup = new NeoSelectionDvcSetup(selectionAlgorithms.size(), testSuites);
		
		List<ExecutableTreatment> treatments = new ArrayList<>();
		for (SelectionType selection : selectionAlgorithms) {
			for (TestSuite ts : testSuites) {
				treatments.add(treatmentFactory.createSelection(selection, ts, selectionPercentage));
			}
		}
		List<List<DependentVariableCollector>> dvcMatches = dvcsetup.getDVCs();
		
		if(dvcMatches.size() != treatments.size()) System.out.println("LASCOOOOOOOOOOOU"); // flag pra testar
		
		List<TreatmentArtifact> artifacts = new ArrayList<>();
		for(int i = 0; i < treatments.size(); i++){
			artifacts.add(new TreatmentArtifact(treatments.get(i), dvcMatches.get(i)));
		}

		return artifacts;
	}

}
