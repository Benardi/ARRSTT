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
	public static List<TestSuite> inputstatic;
	private IOClass io;
	private String outputFolder;
	private ExperimentFactory experimentFactory;
	private List<TestSuite> input;
	
	/**
	 * The controller's constructor. Initializes the needed lists and factories.
	 */
	public ARRSTTController() {
		this.experimentFactory = new ExperimentFactory();
		this.io = new IOClass();
		this.input = new ArrayList<TestSuite>();
	}
	
	public void setInput(String[] paths) {
		try {
			input = io.getTestSuites(paths);
			inputstatic = input;
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to define artifacts. " + e.getMessage());
		}
	}
	
	public void setInput(File[] files) {
		try {
			input = io.getTestSuites(files);
			inputstatic = input;
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to define artifacts. " + e.getMessage());
		}
	}
	
	public void runNeoSelectionExperiment(String[] paths, int replications){
		try{
			Experiment experiment = experimentFactory.buildNeoSelection(input, io.getFiles(paths), replications);
			List<ExperimentData> datas = experiment.execute();
			io.saveData(datas, outputFolder);
		} catch (Exception e){
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to setup Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	public void runNeoMinimizationExperiment(String[] paths, int replications) {
		try {
			Experiment experiment = experimentFactory.buildNeoMinimization(input, io.getFiles(paths), replications);
			List<ExperimentData> datas = experiment.execute();
			io.saveData(datas, outputFolder);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to setup Neo Selection Experiment. " + e.getMessage());
		}
	}
	
	public void setOutputFolder(String path) {
		this.outputFolder = path;
	}
}
