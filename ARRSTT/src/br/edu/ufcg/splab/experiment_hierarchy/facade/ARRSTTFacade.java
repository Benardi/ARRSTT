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
		controller.setArtifacts(paths);
	}
	
	public void setArtifacts(File[] files) {
		controller.setArtifacts(files);
	}
	
	public void setupGenerationExperiment(String[] techniques, String[] dvcs, Integer[] loopCoverages) {
		controller.setupGenerationExperiment(techniques, dvcs, loopCoverages);
	}
	
	public void setupSelectionExperiment(String[] techniques, String[] dvcs, double selPercentage) {
		controller.setupSelectionExperiment(techniques, dvcs, selPercentage);
	}
	
	public void setupMinimizationExperiment(String[] techniques, String[] dvcs, String coverage) {
		controller.setupMinimizationExperiment(techniques, dvcs, coverage);
	}
	
	public void setupNoneExperiment(String[] dvcs) {
		controller.setupNoneExperiment(dvcs);
	}
	
	public void execute(String[] dvcs) {
		controller.execute(dvcs);
	}
	
	public void setOutputFolder(String path) {
		controller.setOutputFolder(path);
	}
}
