package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ARRSTTFileCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ARRSTTReductionPercentageCollector;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class NeoSelectionSetup implements InterfaceSetup{
	private List<InterfaceSelectionTechnique> selectionTechniques;
	private List<TestSuite> testSuites;
	private File[] failureFiles;
	private double selectionPercentage;
	
	public NeoSelectionSetup(List<TestSuite> testSuites, List<InterfaceSelectionTechnique> selectionTechniques, double selectionPercentage, File[] failureFiles) {
		this.selectionTechniques = selectionTechniques;
		this.selectionPercentage = selectionPercentage;
		this.testSuites = testSuites;
		this.failureFiles = failureFiles;
	}
	
	@Override
	public List<TreatmentArtifact> getArtifacts() {		
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		List<TreatmentArtifact> artifacts = new ArrayList<TreatmentArtifact>();
		
		for (int i = 0; i < selectionTechniques.size(); i++) {
			for (int j = 0; j < testSuites.size(); j++) {
				ExecutableTreatment treatment = treatmentFactory.createSelection(selectionTechniques.get(i), testSuites.get(j), selectionPercentage);
				
				List<InterfaceDvc> dvcs = new ArrayList<InterfaceDvc>();
				dvcs.add(new ARRSTTFileCollector(failureFiles[0]));
				dvcs.add(new ARRSTTReductionPercentageCollector(new TestSuite(testSuites.get(j))));
				
				artifacts.add(new TreatmentArtifact(treatment, dvcs));
			}
		}
		
		return artifacts;
	}
}
