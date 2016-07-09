package br.edu.ufcg.splab.facade;

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
	
	public void runNeoSelectionExperiment(String[] input, String[] dvcFiles, String outputFolder, int replications){
		controller.runNeoSelectionExperiment(input, dvcFiles, outputFolder, replications);
	}
	
	public void runNeoSelectionExperiment(File[] input, String[] dvcFiles, String outputFolder, int replications){
		controller.runNeoSelectionExperiment(input, dvcFiles, outputFolder, replications);
	}
	
	public void runNeoSelectionExperiment(File[] input, File[] dvcFiles, String outputFolder, int replications){
		controller.runNeoSelectionExperiment(input, dvcFiles, outputFolder, replications);
	}
	
	public void runNeoMinimizationExperiment(String[] input, String[] dvcFiles, String outputFolder, int replications){
		controller.runNeoMinimizationExperiment(input, dvcFiles, outputFolder, replications);
	}
	
	public void runNeoMinimizationExperiment(File[] input, String[] dvcFiles, String outputFolder, int replications){
		controller.runNeoMinimizationExperiment(input, dvcFiles, outputFolder, replications);
	}
	
	public void runNeoMinimizationExperiment(File[] input, File[] dvcFiles, String outputFolder, int replications){
		controller.runNeoMinimizationExperiment(input, dvcFiles, outputFolder, replications);
	}
}
