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
	
	public void runNeoSelectionExperiment(String[] paths){
		controller.runNeoSelectionExperiment(paths);
	}
	
	public void runNeoMinimizationExperiment(String[] paths){
		controller.runNeoMinimizationExperiment(paths);
	}
	
	public void setOutputFolder(String path) {
		controller.setOutputFolder(path);
	}
}
