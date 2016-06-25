package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FailuresByFileCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FinalSuiteCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ReductionCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.benchmarks.TimeBenchmark;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.noexecution.MediaMaxMinCollector;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class MySelectionSetup implements InterfaceSetup{
	private List<InterfaceSelectionTechnique> selectionTechniques;
	private List<TestSuite> testSuites;
	private File[] failureFiles;
	private double selectionPercentage;
	private int replications;
	
	public MySelectionSetup(List<TestSuite> testSuites, List<InterfaceSelectionTechnique> selectionTechniques, double selectionPercentage, File[] failureFiles, int replications) {
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
					
					dvcs.add(new FailuresByFileCollector(findRightFile(testSuites.get(j))));
					dvcs.add(new ReductionCollector(new TestSuite(testSuites.get(j))));
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
	
	private File findRightFile(TestSuite testSuite) {
		File rightFile = null;
		
		if (testSuite.getID().equals("noid")) {
			return null;
		}
		
		for (int i = 0; i < failureFiles.length; i++) {
			if ((testSuite.getID() + "_failures.txt").equalsIgnoreCase(failureFiles[i].getName())) {
				rightFile = failureFiles[i];
			}
		}
		
		return rightFile;
	}
}
