package br.edu.ufcg.splab.framework.core.setups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.framework.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.framework.core.api.InterfaceSetup;
import br.edu.ufcg.splab.framework.core.artifacts.Artifact;
import br.edu.ufcg.splab.framework.core.dvcs.FailuresByFileCollector;
import br.edu.ufcg.splab.framework.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.framework.core.dvcs.FinalSuiteCollector;
import br.edu.ufcg.splab.framework.core.dvcs.ReductionCollector;
import br.edu.ufcg.splab.framework.core.dvcs.benchmarks.TimeBenchmark;
import br.edu.ufcg.splab.framework.core.dvcs.noexecution.MediaMaxMinCollector;
import br.edu.ufcg.splab.framework.techniques.minimization.builders.RequirementBuilder;
import br.edu.ufcg.splab.framework.techniques.minimization.factories.MinimizationTechniques;
import br.edu.ufcg.splab.framework.techniques.minimization.factories.MinimizationTechniquesFactory;
import br.edu.ufcg.splab.framework.techniques.minimization.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.util.enums.RequirementBuilders;
import br.edu.ufcg.splab.util.factories.RequirementBuilderFactory;
import br.edu.ufcg.splab.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class MyMinimizationSetup implements InterfaceSetup {
	private List<MinimizationTechniques> enumMinimizationTechniques;
	private RequirementBuilders enumBuilder;
	private List<TestSuite> testSuites;
	private File[] failureFiles;
	private int replications;
	
	public MyMinimizationSetup(List<TestSuite> testSuites, List<MinimizationTechniques> enumMinimizationTechniques, RequirementBuilders enumBuilder, File[] failureFiles, int replications) {
		this.enumMinimizationTechniques = enumMinimizationTechniques;
		this.testSuites = testSuites;
		this.failureFiles = failureFiles;
		this.enumBuilder = enumBuilder;
		this.replications = replications;
	}

	@Override
	public List<Artifact> getArtifacts() {
		
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		MinimizationTechniquesFactory minimizationFactory = new MinimizationTechniquesFactory();
		RequirementBuilderFactory reqBuilderFactory = new RequirementBuilderFactory();
		
		List<Artifact> artifacts = new ArrayList<Artifact>();
		
		for (int j = 0; j < testSuites.size(); j++) {
			for (int i = 0; i < enumMinimizationTechniques.size(); i++) {
				for (int k = 0; k <= replications; k++) {
					RequirementBuilder builder = reqBuilderFactory.createRequirementBuilder(testSuites.get(j), enumBuilder);
					InterfaceMinimizationTechnique minimizationTechnique = minimizationFactory.createMinimizationTechnique(enumMinimizationTechniques.get(i), testSuites.get(j), builder.getRequirements());
					
					ExecutableTreatment treatment = treatmentFactory.createMinimization(minimizationTechnique);
					List<InterfaceDvc> dvcs = new ArrayList<InterfaceDvc>();
					dvcs.add(new FailuresByFileCollector(findRightFile(testSuites.get(j))));
					dvcs.add(new ReductionCollector(new TestSuite(testSuites.get(j))));
					dvcs.add(new FinalSizeCollector());
					dvcs.add(new FinalSuiteCollector());
					dvcs.add(new TimeBenchmark());
					dvcs.add(new MediaMaxMinCollector(testSuites.get(j)));
						
					artifacts.add(new Artifact(treatment, dvcs));
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
