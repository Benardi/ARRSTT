package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.DefectiveEdgesCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.DefectsCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FailuresCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.ReductionCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.noexecution.MediaMaxMinCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.noexecution.MostRepeatedTransitionCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.dvcs.noexecution.RedundanceCollector;
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
		return new DefectiveEdgesCollector();
	}
	
	public InterfaceDvc createDefectsDvc() {
		return new DefectsCollector();
	}
	
	public InterfaceDvc createFailuresDvc() {
		return new FailuresCollector();
	}
	
	public InterfaceDvc createSizeDvc() {
		return new FinalSizeCollector();
	}
	
	public InterfaceDvc createMediaMaxMinDvc(TestSuite testSuite) {
		return new MediaMaxMinCollector(testSuite);
	}
	
	public InterfaceDvc createMostRepeatedTransitionDvc(TestSuite testSuite) {
		return new MostRepeatedTransitionCollector(testSuite);
	}
	
	public InterfaceDvc createRedundanceDvc(TestSuite testSuite) {
		return new RedundanceCollector(testSuite);
	}
	
	public InterfaceDvc createReductionPercentageDvc(TestSuite testSuite) {
		return new ReductionCollector(testSuite);
	}

}
