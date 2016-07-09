package br.edu.ufcg.splab.framework.core.setups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.framework.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.framework.core.api.InterfaceSetup;
import br.edu.ufcg.splab.framework.core.artifacts.Artifact;
import br.edu.ufcg.splab.framework.core.dvcs.CoverageCollector;
import br.edu.ufcg.splab.framework.core.dvcs.FailuresByFileCollector;
import br.edu.ufcg.splab.framework.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.framework.core.dvcs.FinalSuiteCollector;
import br.edu.ufcg.splab.framework.core.dvcs.ReductionCollector;
import br.edu.ufcg.splab.framework.core.dvcs.benchmarks.TimeBenchmark;
import br.edu.ufcg.splab.framework.core.dvcs.noexecution.MediaMaxMinCollector;
import br.edu.ufcg.splab.framework.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

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
	public List<Artifact> getArtifacts() {		
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		List<Artifact> artifacts = new ArrayList<Artifact>();
		

			for (int j = 0; j < testSuites.size(); j++) {
				for (int k = 0; k <= replications; k++) {
					for (int i = 0; i < selectionTechniques.size(); i++) {

					ExecutableTreatment treatment = treatmentFactory.createSelection(selectionTechniques.get(i), testSuites.get(j), selectionPercentage);
					
					List<InterfaceDvc> dvcs = new ArrayList<InterfaceDvc>();
					
					dvcs.add(new FailuresByFileCollector(failureFiles[j]));
					dvcs.add(new ReductionCollector(new TestSuite(testSuites.get(j))));
					dvcs.add(new FinalSizeCollector());
					dvcs.add(new FinalSuiteCollector());
					dvcs.add(new TimeBenchmark());
					dvcs.add(new MediaMaxMinCollector(testSuites.get(j)));
					dvcs.add(new CoverageCollector(new TestSuite(testSuites.get(j))));
					
					artifacts.add(new Artifact(treatment, dvcs));
				}
			}
		}
		
		return artifacts;
	}
}
