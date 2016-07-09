package br.edu.ufcg.splab.facade;

import java.io.File;


/**
 * A facade created by the ARRSTT team to improve the experiment's executions and design
 * New users can use and extend this class to create/reproduce experiments, but the usage
 * of this class is not obligatory.
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
	
	//Work in progress
	public void runNeoMinimizationExperiment(String[] input, String[] dvcFiles, String outputFolder, int replications){
		controller.runNeoMinimizationExperiment(input, dvcFiles, outputFolder, replications);
	}
	//Work in progress
	public void runNeoMinimizationExperiment(File[] input, String[] dvcFiles, String outputFolder, int replications){
		controller.runNeoMinimizationExperiment(input, dvcFiles, outputFolder, replications);
	}
	//Work in progress
	public void runNeoMinimizationExperiment(File[] input, File[] dvcFiles, String outputFolder, int replications){
		controller.runNeoMinimizationExperiment(input, dvcFiles, outputFolder, replications);
	}
}
