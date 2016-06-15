package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.DVCFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ArtifactBuilder {
	private DVCFactory dvcFactory;
	
	public ArtifactBuilder() {
		dvcFactory = new DVCFactory();
	}
	
	public TreatmentArtifact createArtifact(ExecutableTreatment treatment, List<DVCType> enumDvcs) {
		for (DVCType type : enumDvcs) {
			DependentVariableCollector createdDvc = null;
			
			switch(type) {
				case DEFECTIVE_EDGES:
					createdDvc = dvcFactory.createDefectiveEdgesDvc();
					break;
				case FAILURES:
					createdDvc = dvcFactory.createFailuresDvc();
					break;
				case DEFECTS:
					createdDvc = dvcFactory.createDefectsDvc();
					break;
				case MEDIA_MAX_MIN:
					createdDvc = dvcFactory.createMediaMaxMinDvc();
					break;
				case MOST_REPEATED_TRANSITION:
					createdDvc = dvcFactory.createMostRepeatedTransitionDvc();
					break;
				case REDUCTION:
					createdDvc = dvcFactory.createReductionPercentageDvc(testSuite);
					break;
				case REDUNDANCE:
					createdDvc = dvcFactory.createRedundanceDvc();
					break;
				case SIZE:
					createdDvc = dvcFactory.createSizeDvc();
					break;
				default:
					throw new ARRSTTException("DVC " + type + " not found.");
			}
			
			dvcs.add(createdDvc);
		}
	}

	public List<TreatmentArtifact> buildArtifacts(List<TestSuite> targets, List<DVCType> enumDvcs) {
		List<TreatmentArtifact> artifacts = new ArrayList<TreatmentArtifact>();
		
		for (TestSuite testSuite : targets) {
			List<DependentVariableCollector> dvcs = new ArrayList<DependentVariableCollector>();
			
			for (DVCType type : dvcsType) {
				DependentVariableCollector createdDvc = null;
				
				switch(type) {
					case DEFECTIVE_EDGES:
						createdDvc = dvcFactory.createDefectiveEdgesDvc();
						break;
					case FAILURES:
						createdDvc = dvcFactory.createFailuresDvc();
						break;
					case DEFECTS:
						createdDvc = dvcFactory.createDefectsDvc();
						break;
					case MEDIA_MAX_MIN:
						createdDvc = dvcFactory.createMediaMaxMinDvc();
						break;
					case MOST_REPEATED_TRANSITION:
						createdDvc = dvcFactory.createMostRepeatedTransitionDvc();
						break;
					case REDUCTION:
						createdDvc = dvcFactory.createReductionPercentageDvc(testSuite);
						break;
					case REDUNDANCE:
						createdDvc = dvcFactory.createRedundanceDvc();
						break;
					case SIZE:
						createdDvc = dvcFactory.createSizeDvc();
						break;
					default:
						throw new ARRSTTException("DVC " + type + " not found.");
				}
				
				dvcs.add(createdDvc);
			}
			
			artifacts.add(new TreatmentArtifact(testSuite, dvcs));
		}
		
		return artifacts;
	}
}
