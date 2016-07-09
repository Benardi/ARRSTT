package br.edu.ufcg.splab;

import java.io.File;

import br.edu.ufcg.splab.facade.ARRSTTFacade;

public class Main {
	private static ARRSTTFacade facade;
	
	
	public static void main(String[] args) throws Exception {
		facade = new ARRSTTFacade();
		experiment1();
	}
	
	public static void experiment1() {
		File[] input = new File[1];
		input[0] = new File("extras/xmls/EasyToy4.testsuite-deep.xml");
		String[] files = {"extras/failure_files/EasyToy4.testsuite-deep_failures.txt"};
		String outputFolder = "experiment_results";
		
		facade.runNeoSelectionExperiment(input, files, outputFolder, 2);
	}
	
	// This method is still a work in progress
	public static void experiment2() {
		File[] input = new File[1];
		input[0] = new File("extras/xmls/EasyToy4.testsuite-deep.xml");
		String[] files = {"extras/failure_files/EasyToy4.testsuite-deep_failures.txt"};
		String outputFolder = "experiment_results";
		
		facade.runNeoMinimizationExperiment(input, files, outputFolder, 1);
	}
	
	public static void experimentSAST() {
		String folder = "extras/experiment_sast/";
		String testSuiteFolder = "testsuites/";
		String failuresFolder = "failures/";
		String[] objects = {"Campaign","Library","InitialScreen","Settings"};
		
		File[] xmlFiles = new File[objects.length];
		String[] failuresFilePath = new String[objects.length];
		
		for (int i = 0; i < failuresFilePath.length; i++) {
			failuresFilePath[i] = folder+failuresFolder+objects[i]+"_failures.txt";
		}
		for (int i = 0; i < xmlFiles.length; i++) {
			xmlFiles[i] = new File(folder+testSuiteFolder+objects[i]+".xml");
		}
		
		String outputFolder = "experiment_sast_results";
		
		facade.runNeoSelectionExperiment(xmlFiles, failuresFilePath, outputFolder, 99);
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
