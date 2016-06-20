package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.io.File;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-30
 * Transfered it's logic to the controller						Iaron Araújo		2015-10-20
 */

public class ARRSTTFacade {
	private ARRSTTController controller;
	
	public ARRSTTFacade() {
		this.controller = new ARRSTTController();
	}
	
	public void setArtifacts(String[] paths) {
		controller.setInput(paths);
	}
	
	public void setArtifacts(File[] files) {
		controller.setInput(files);
	}
	
	public void runNeoSelectionExperiment(String[] paths, int replications){
		controller.runNeoSelectionExperiment(paths, replications);
	}
	
	public void runNeoMinimizationExperiment(String[] paths, int replications){
		controller.runNeoMinimizationExperiment(paths, replications);
	}
	
	public void setOutputFolder(String path) {
		controller.setOutputFolder(path);
	}
}
