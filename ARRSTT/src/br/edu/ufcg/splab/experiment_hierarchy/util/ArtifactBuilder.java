package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TestArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.DVCFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ArtifactBuilder {
	private DVCFactory dvcFactory;
	
	public ArtifactBuilder() {
		dvcFactory = new DVCFactory();
	}

	public List<TestArtifact> buildArtifacts(List<TestSuite> targets, String[] rawDvcs) {
		List<TestArtifact> artifacts = new ArrayList<TestArtifact>();
		List<DVCType> dvcsType = getDvcs(rawDvcs);
		
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
			
			artifacts.add(new TestArtifact(testSuite, dvcs));
		}
		
		return artifacts;
	}
	
	private List<DVCType> getDvcs(String[] dvcs) {
		List<DVCType> parsedDvcs = new ArrayList<DVCType>();
		
		for (String dvc : dvcs) {
			parsedDvcs.add(getDvc(dvc));
		}
		
		return parsedDvcs;
	}
	
	private DVCType getDvc(String dvc) {
		try {
			return DVCType.valueOf(dvc);
		} catch(IllegalArgumentException ie) {
			throw new ARRSTTException("DVC " + dvc + " not found.");
		} catch(NullPointerException ne) {
			throw new ARRSTTException("DVC name cannot be null.");
		}
	}
}
