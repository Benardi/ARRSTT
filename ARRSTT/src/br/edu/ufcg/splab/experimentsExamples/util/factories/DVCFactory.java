package br.edu.ufcg.splab.experimentsExamples.util.factories;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.DefectiveEdgesCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.DefectsCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.FailuresCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.ReductionCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.noexecution.MediaMaxMinCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.noexecution.MostRepeatedTransitionCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.noexecution.RedundanceCollector;

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
	
	public IDvc createDefectiveEdgesDvc() {
		return new DefectiveEdgesCollector();
	}
	
	public IDvc createDefectsDvc() {
		return new DefectsCollector();
	}
	
	public IDvc createFailuresDvc() {
		return new FailuresCollector();
	}
	
	public IDvc createSizeDvc() {
		return new FinalSizeCollector();
	}
	
	public IDvc createMediaMaxMinDvc(TestSuite testSuite) {
		return new MediaMaxMinCollector(testSuite);
	}
	
	public IDvc createMostRepeatedTransitionDvc(TestSuite testSuite) {
		return new MostRepeatedTransitionCollector(testSuite);
	}
	
	public IDvc createRedundanceDvc(TestSuite testSuite) {
		return new RedundanceCollector(testSuite);
	}
	
	public IDvc createReductionPercentageDvc(TestSuite testSuite) {
		return new ReductionCollector(testSuite);
	}

}
