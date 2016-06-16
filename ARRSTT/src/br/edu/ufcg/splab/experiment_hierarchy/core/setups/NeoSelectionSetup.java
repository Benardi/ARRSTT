package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTFileCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTReductionPercentageCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcsetup.InterfaceDvcSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcsetup.NeoSelectionDvcSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class NeoSelectionSetup implements InterfaceSetup{
	private List<InterfaceTestCaseSelector> selectionAlgorithms;
	private double selectionPercentage;
	private List<TestSuite> testSuites;
	private File[] files;
	
	public NeoSelectionSetup(List<InterfaceTestCaseSelector> selectionAlgorithms, double selectionPercentage, List<TestSuite> testSuites, File[] files){
		this.selectionAlgorithms = selectionAlgorithms;
		this.selectionPercentage = selectionPercentage;
		this.testSuites = testSuites;
		this.files = files;
	}
	
	@Override
	public List<TreatmentArtifact> getArtifacts() {		
		List<ExecutableTreatment> treatments = getTreatments();
		List<List<DependentVariableCollector>> dvcMatches = getDVCs(selectionAlgorithms.size());
		
		if(dvcMatches.size() != treatments.size()) throw new ARRSTTException("DVCs' and Treatments' sizes didn't match");
	
		List<TreatmentArtifact> artifacts = new ArrayList<>();
		for(int i = 0; i < treatments.size(); i++){
			artifacts.add(new TreatmentArtifact(treatments.get(i), dvcMatches.get(i)));
		}

		return artifacts;
	}
	
	private List<ExecutableTreatment> getTreatments(){
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		List<ExecutableTreatment> treatments = new ArrayList<>();
		for (InterfaceTestCaseSelector selection : selectionAlgorithms) {
			for (TestSuite ts : testSuites) {
				treatments.add(treatmentFactory.createSelection(selection, ts, selectionPercentage));
			}
		}
		return treatments;
	}
	
	private List<List<DependentVariableCollector>> getDVCs(int algorithmsAmount) {
		List<List<DependentVariableCollector>> matches = new ArrayList<>();

		for(int i = 0; i < algorithmsAmount; i++){
			for(int j = 0; j < testSuites.size(); j++){
				List<DependentVariableCollector> match = new ArrayList<>();
				match.add(new ARRSTTFileCollector(files[j]));
				match.add(new ARRSTTReductionPercentageCollector(new TestSuite(testSuites.get(j)))); // usando construtor de copia
				matches.add(match);
			}
		}
		return matches;
	}

}
