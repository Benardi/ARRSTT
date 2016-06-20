package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FileCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FinalSuiteCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ReductionPercentageCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.benchmarks.TimeBenchmark;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.noexecution.MediaMaxMinCollector;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class NeoSelectionSetup implements InterfaceSetup{
	private List<InterfaceSelectionTechnique> selectionTechniques;
	private List<TestSuite> testSuites;
	private File[] failureFiles;
	private double selectionPercentage;
	private int replications;
	
	public NeoSelectionSetup(List<TestSuite> testSuites, List<InterfaceSelectionTechnique> selectionTechniques, double selectionPercentage, File[] failureFiles, int replications) {
		this.selectionTechniques = selectionTechniques;
		this.selectionPercentage = selectionPercentage;
		this.testSuites = testSuites;
		this.failureFiles = failureFiles;
		this.replications = replications;
	}
	
	@Override
	public List<TreatmentArtifact> getArtifacts() {		
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		List<TreatmentArtifact> artifacts = new ArrayList<TreatmentArtifact>();
		
		for (int j = 0; j < testSuites.size(); j++) {
			for (int i = 0; i < selectionTechniques.size(); i++) {
				for (int k = 0; k <= replications; k++) {
					ExecutableTreatment treatment = treatmentFactory.createSelection(selectionTechniques.get(i), testSuites.get(j), selectionPercentage);
					
					List<InterfaceDvc> dvcs = new ArrayList<InterfaceDvc>();
					dvcs.add(new FileCollector(failureFiles[0]));
					dvcs.add(new ReductionPercentageCollector(new TestSuite(testSuites.get(j))));
					dvcs.add(new FinalSizeCollector());
					dvcs.add(new FinalSuiteCollector());
					dvcs.add(new TimeBenchmark());
					dvcs.add(new MediaMaxMinCollector(testSuites.get(j)));
					
					artifacts.add(new TreatmentArtifact(treatment, dvcs));
				}
			}
		}
		
		return artifacts;
	}
}
