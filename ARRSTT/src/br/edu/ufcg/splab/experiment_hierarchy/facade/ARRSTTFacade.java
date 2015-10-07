package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.util.List;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-30
 * 
 */

public class ARRSTTFacade {
	public void execute(List<List<String>> inputs) throws Exception {
		ARRSTTController controller = new ARRSTTController();
		
		switch(inputs.get(0).get(0).toLowerCase()) {
			case "generation":
				controller.buildGeneration(inputs);
				break;
			case "selection":
				controller.buildSelection(inputs);
				break;
			default:
				throw new Exception("Invalid experiment type.");
		}
		
		controller.executeExperiment();
	}
}
