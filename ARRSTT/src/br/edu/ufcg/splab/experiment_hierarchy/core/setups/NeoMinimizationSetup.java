package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FileCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ReductionPercentageCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FinalSuiteCollector;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.builders.RequirementBuilder;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.factories.MinimizationTechniques;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.factories.MinimizationTechniquesFactory;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.RequirementBuilders;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.RequirementBuilderFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.TreatmentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class NeoMinimizationSetup implements InterfaceSetup {
	private List<MinimizationTechniques> enumMinimizationTechniques;
	private RequirementBuilders enumBuilder;
	private List<TestSuite> testSuites;
	private File[] failureFiles;
	
	public NeoMinimizationSetup(List<TestSuite> testSuites, List<MinimizationTechniques> enumMinimizationTechniques, RequirementBuilders enumBuilder, File[] failureFiles) {
		this.enumMinimizationTechniques = enumMinimizationTechniques;
		this.testSuites = testSuites;
		this.failureFiles = failureFiles;
		this.enumBuilder = enumBuilder;
	}

	@Override
	public List<TreatmentArtifact> getArtifacts() {
		TreatmentFactory treatmentFactory = new TreatmentFactory();
		MinimizationTechniquesFactory minimizationFactory = new MinimizationTechniquesFactory();
		RequirementBuilderFactory reqBuilderFactory = new RequirementBuilderFactory();
		
		List<TreatmentArtifact> artifacts = new ArrayList<TreatmentArtifact>();
		
		for (int i = 0; i < enumMinimizationTechniques.size(); i++) {
			for (int j = 0; j < testSuites.size(); j++) {
				RequirementBuilder builder = reqBuilderFactory.createRequirementBuilder(testSuites.get(j), enumBuilder);
				InterfaceMinimizationTechnique minimizationTechnique = minimizationFactory.createMinimizationTechnique(enumMinimizationTechniques.get(i), testSuites.get(j), builder.getRequirements());
				
				ExecutableTreatment treatment = treatmentFactory.createMinimization(minimizationTechnique);
				
				List<InterfaceDvc> dvcs = new ArrayList<InterfaceDvc>();
				dvcs.add(new FileCollector(failureFiles[j])); // Replace for -> failuresFiles[j]
				dvcs.add(new ReductionPercentageCollector(new TestSuite(testSuites.get(j))));
				dvcs.add(new FinalSizeCollector());
				dvcs.add(new FinalSuiteCollector());
					
				artifacts.add(new TreatmentArtifact(treatment, dvcs));
			}
		}
		
		return artifacts;
	}
}
