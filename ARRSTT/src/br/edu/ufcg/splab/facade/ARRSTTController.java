package br.edu.ufcg.splab.facade;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.util.ExperimentDataGroup;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.experimentsExamples.core.experiments.Experiment;
import br.edu.ufcg.splab.experimentsExamples.util.factories.ExperimentFactory;
import br.edu.ufcg.splab.io.IOClass;

/**
 * A controller created by the ARRSTT team to improve the experiment's executions and design
 * New users can use and extend this class to create/reproduce experiments, but the usage
 * of this class is not obligatory.
 */
public class ARRSTTController {	
	private IOClass io;// This object handles the experiments' Input and Output
	private ExperimentFactory experimentFactory;
	

	public ARRSTTController() {
		this.experimentFactory = new ExperimentFactory();
		this.io = new IOClass();
	}
	
	public void runNeoSelectionExperiment(String[] input, String[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoSelection(getInput(input), io.getFiles(dvcFiles), replications);
			List<ExperimentDataGroup> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	public void runNeoSelectionExperiment(File[] input, String[] dvcFiles, String outputFolder, int replications) {
		try {
			List<TestSuite> testSuites = getInput(input);
			File[] failureFiles = io.getFiles(dvcFiles);
			Experiment experiment = experimentFactory.buildNeoSelection(testSuites, failureFiles, replications);
			List<ExperimentDataGroup> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	public void runNeoSelectionExperiment(File[] input, File[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoSelection(getInput(input), dvcFiles, replications);
			List<ExperimentDataGroup> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	//Work in progress
	public void runNeoMinimizationExperiment(String[] input, String[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoMinimization(getInput(input), io.getFiles(dvcFiles), replications);
			List<ExperimentDataGroup> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	//Work in progress
	public void runNeoMinimizationExperiment(File[] input, String[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoMinimization(getInput(input), io.getFiles(dvcFiles), replications);
			List<ExperimentDataGroup> outputData = experiment.execute();
			io.saveData(outputData, outputFolder);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to run Neo Selection Experiment. " + e.getMessage());
		}
	}
	//Work in progress
	public void runNeoMinimizationExperiment(File[] input, File[] dvcFiles, String outputFolder, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoMinimization(getInput(input), dvcFiles, replications);
			List<ExperimentDataGroup> outputData = experiment.execute();
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
