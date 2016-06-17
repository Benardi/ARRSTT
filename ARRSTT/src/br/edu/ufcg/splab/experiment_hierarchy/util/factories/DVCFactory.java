package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ARRSTTDefectiveEdgesCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ARRSTTDefectsCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ARRSTTFailuresCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ARRSTTMediaMaxMin;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ARRSTTMostRepeatedTransitionCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ARRSTTRedundanceCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ARRSTTSizeCollector;
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
	
	public InterfaceDvc createDefectiveEdgesDvc() {
		return new ARRSTTDefectiveEdgesCollector();
	}
	
	public InterfaceDvc createDefectsDvc() {
		return new ARRSTTDefectsCollector();
	}
	
	public InterfaceDvc createFailuresDvc() {
		return new ARRSTTFailuresCollector();
	}
	
	public InterfaceDvc createSizeDvc() {
		return new ARRSTTSizeCollector();
	}
	
	public InterfaceDvc createMediaMaxMinDvc() {
		return new ARRSTTMediaMaxMin();
	}
	
	public InterfaceDvc createMostRepeatedTransitionDvc() {
		return new ARRSTTMostRepeatedTransitionCollector();
	}
	
	public InterfaceDvc createRedundanceDvc() {
		return new ARRSTTRedundanceCollector();
	}
	
	public InterfaceDvc createReductionPercentageDvc(TestSuite testSuite) {
		return new ARRSTTRedundanceCollector();
	}

}
