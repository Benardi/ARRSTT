package br.edu.ufcg.splab;

import java.io.File;

import br.edu.ufcg.splab.facade.ARRSTTFacade;

public class Main {
	private static ARRSTTFacade facade;
	
	private static File[] xmlFiles = directoryToPath("extras/xmls");
	
	public static void main(String[] args) throws Exception {
		facade = new ARRSTTFacade();
		
		//experiment1();
		experimentSAST();
		//experiment2();
		//experiment3();
		//experiment4();
	}
	
	public static void experiment1() {
		File[] input = xmlFiles;
		String[] files = {"extras/failure_files/easytoy4_failures.txt"};
		String outputFolder = "experiment_results";
		
		facade.runNeoSelectionExperiment(input, files, outputFolder, 2);
	}
	
	public static void experiment2() {
		File[] input = xmlFiles;
		String[] files = {"extras/failure_files/easytoy4_failures.txt"};
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
	
	private static File[] directoryToPath(String pathToFolder) {
		File file = new File(pathToFolder);
		
		if (file.isDirectory()) {
			return file.listFiles();
		} else {
			throw new RuntimeException("Given file is not a directory");
		}
	}
}
