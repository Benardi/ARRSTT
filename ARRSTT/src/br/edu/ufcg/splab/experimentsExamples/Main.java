package br.edu.ufcg.splab.experimentsExamples;

import java.io.File;

import br.edu.ufcg.splab.facade.ARRSTTFacade;

/**
 * This is a Main created by the ARRSTT team to aid in the execution
 * of experiments. New users can use this class or create it's own main
 * to execute/reproduce experiments.
 */
public class Main {
	private static ARRSTTFacade facade;
	
	
	public static void main(String[] args) throws Exception {
		facade = new ARRSTTFacade();
		experiment1();
		System.out.println("Experiment's execution finished");
	}
	
	/**
	 * This method represents a simple Test Case Selection Experiment.
	 * It selects a single TestSuite from a xml file and apply two selection
	 * algorithms in it. Several data are collected through DVCs, and since
	 * some of them receive a file in the constructor, we also load a file with
	 * the TestSuite's failures.
	 */
	public static void experiment1() {
		/*
		 * Since the facade created by the ARRSTT team receives an array of file,
		 * it's necessary to put the desired TestSuite in an array. The same happens
		 * with the failureFiles.
		 */
		File[] testSuitesFiles = new File[1];
		testSuitesFiles[0] = new File("extras/xmls/EasyToy4.testsuite-deep.xml");
		
		// The failures files must contain the External ID of the defective TestCase
		String[] failureFiles = {"extras/failure_files/EasyToy4.testsuite-deep_failures.txt"};
		String outputFolder = "experiment_results";
		
		facade.runNeoSelectionExperiment(testSuitesFiles, failureFiles, outputFolder, 2);
	}
	
	// Work in progress
	public static void experiment2() {
		File[] input = new File[1];
		input[0] = new File("extras/xmls/EasyToy4.testsuite-deep.xml");
		String[] files = {"extras/failure_files/EasyToy4.testsuite-deep_failures.txt"};
		String outputFolder = "experiment_results";
		
		facade.runNeoMinimizationExperiment(input, files, outputFolder, 1);
	}
	
	
	/**
	 * This method receives a directory's path and return it as an array of Files
	 * @param pathToFolder The directory's path
	 * @return The directory as an array of Files
	 */
	private static File[] directoryToPath(String pathToFolder) {
		File file = new File(pathToFolder);
		
		if (file.isDirectory()) {
			return file.listFiles();
		} else {
			throw new RuntimeException("Given file is not a directory");
		}
	}
}
