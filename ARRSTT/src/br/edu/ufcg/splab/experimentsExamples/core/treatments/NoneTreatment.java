package br.edu.ufcg.splab.experimentsExamples.core.treatments;

import br.edu.ufcg.splab.arrsttFramework.IExecutableTreatment;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Documentation												Benardi Nunes		2016-07-12
 * 
 */
/**
 * <b>Objective:</b> This class represents an ARRSTT experiment's executable
 * treatment that is the Test Suite devoid of the effect of any technique
 * whatsoever <br>
 * <b>Description of use:</b> Receives a test suite and returns it.
 *
 */
public class NoneTreatment implements IExecutableTreatment {
	private TestSuite ts;
	
	/**
	 * NoneTreatment's constructor
	 * @param ts
	 * 		The Test Suite
	 */
	public NoneTreatment(TestSuite ts) {
		this.ts = ts;
	}

	/**
	 * <b>Objective:</b> Retrieve the Test Suite given in the object's
	 * construction. <br>
	 */
	@Override
	public TestSuite execute() {
		return ts;
	}

}
