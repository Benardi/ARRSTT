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
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class NeoMinimizationSetup implements InterfaceSetup {
	private List<InterfaceMinimizationTechnique> minimizationTechniques;
	private List<TestSuite> testSuites;
	private File[] failureFiles;
	
	public NeoMinimizationSetup(List<TestSuite> testSuites, List<InterfaceMinimizationTechnique> minimizationTechniques, File[] failureFiles) {
		this.minimizationTechniques = minimizationTechniques;
		this.testSuites = testSuites;
		this.failureFiles = failureFiles;
	}

	@Override
	public List<TreatmentArtifact> getArtifacts() {
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		List<TreatmentArtifact> artifacts = new ArrayList<TreatmentArtifact>();
		
		for (int i = 0; i < minimizationTechniques.size(); i++) {
			for (int j = 0; j < testSuites.size(); j++) {
				ExecutableTreatment treatment = treatmentFactory.createMinimization(minimizationTechniques.get(i));
				
				List<InterfaceDvc> dvcs = new ArrayList<InterfaceDvc>();
				dvcs.add(new ARRSTTFileCollector(failureFiles[j]));
				dvcs.add(new ARRSTTReductionPercentageCollector(new TestSuite(testSuites.get(j))));
				
				artifacts.add(new TreatmentArtifact(treatment, dvcs));
			}
		}
		
		return artifacts;
	}
}
