package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.util.List;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-30
 * Transfered it's logic to the controller						Iaron Araújo		2015-10-20
 */

public class ARRSTTFacade {
	public void execute(List<List<String>> inputs) throws Exception {
		ARRSTTController controller = new ARRSTTController();
		controller.execute(inputs);
	}
}
