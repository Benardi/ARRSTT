package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectiveEdgesCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectsCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTFailuresCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTMediaMaxMin;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTMostRepeatedTransitionCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTRedundanceCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-09-16
 * 
 */
/**
 * <b>Objective:</b> This class covers all necessary procedure involved in the process
 * of generating all the possible dependent variable collectors.
 * <br>
 * <b>Description of use:</b> Receives a type and returns a collector of the respective
 * type, this process can be repeated as the collectors are put in a List.
 */
public class DVCFactory {
	
	public DependentVariableCollector createDefectiveEdgesDvc() {
		return new ARRSTTDefectiveEdgesCollector();
	}
	
	public DependentVariableCollector createDefectsDvc() {
		return new ARRSTTDefectsCollector();
	}
	
	public DependentVariableCollector createFailuresDvc() {
		return new ARRSTTFailuresCollector();
	}
	
	public DependentVariableCollector createSizeDvc() {
		return new ARRSTTSizeCollector();
	}
	
	public DependentVariableCollector createMediaMaxMinDvc() {
		return new ARRSTTMediaMaxMin();
	}
	
	public DependentVariableCollector createMostRepeatedTransitionDvc() {
		return new ARRSTTMostRepeatedTransitionCollector();
	}
	
	public DependentVariableCollector createRedundanceDvc() {
		return new ARRSTTRedundanceCollector();
	}
	
	public DependentVariableCollector createReductionPercentageDvc(TestSuite testSuite) {
		return new ARRSTTRedundanceCollector();
	}

}
