package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.experiment_hierarchy.ExperimentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.io.IOClass;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentData;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-30
 * 
 */

/**
 * <b>Objective:</b> This class is used by the facade to create and run ARRSTT's experiments,
 * such as selection experiment and generation experiment.
 * <br>
 * <b>Description of use:<b> It's only public method is execute() that is responsible for the
 * creation and execution of ARRSTT's experiments.
 *
 */
public class ARRSTTController {	
	private IOClass io;
	private ExperimentFactory experimentFactory;
	
	/**
	 * The controller's constructor. Initializes the needed lists and factories.
	 */
	public ARRSTTController() {
		this.experimentFactory = new ExperimentFactory();
		this.io = new IOClass();
	}
	
	public void runNeoSelectionExperiment(String[] input, String[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoSelection(getInput(input), io.getFiles(dvcFiles), replications);
			List<ExperimentData> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	public void runNeoSelectionExperiment(File[] input, String[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoSelection(getInput(input), io.getFiles(dvcFiles), replications);
			List<ExperimentData> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	public void runNeoSelectionExperiment(File[] input, File[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoSelection(getInput(input), dvcFiles, replications);
			List<ExperimentData> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	public void runNeoMinimizationExperiment(String[] input, String[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoMinimization(getInput(input), io.getFiles(dvcFiles), replications);
			List<ExperimentData> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	public void runNeoMinimizationExperiment(File[] input, String[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoMinimization(getInput(input), io.getFiles(dvcFiles), replications);
			List<ExperimentData> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	public void runNeoMinimizationExperiment(File[] input, File[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoMinimization(getInput(input), dvcFiles, replications);
			List<ExperimentData> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	private List<TestSuite> getInput(String[] paths) {
		try {
			List<TestSuite> input = new ArrayList<TestSuite>();
			input = io.getTestSuites(paths);
			return input;
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to define artifacts. " + e.getMessage());
		}
	}
	
	private List<TestSuite> getInput(File[] files) {
		try {
			List<TestSuite> input = new ArrayList<TestSuite>();
			input = io.getTestSuites(files);
			return input;
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to define artifacts. " + e.getMessage());
		}
	}
}
