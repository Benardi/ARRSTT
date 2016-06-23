package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;

import br.edu.ufcg.splab.experiment_hierarchy.facade.ARRSTTFacade;

public class Main {
	private static ARRSTTFacade facade;
	
	private static File[] tgfFiles = directoryToFiles("extras/input_examples");
	private static File[] xmlFiles = directoryToFiles("extras/xmls");
	
	public static void main(String[] args) throws Exception {
		facade = new ARRSTTFacade();
		
		experiment1();
		//experiment2();
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
	
	private static File[] directoryToFiles(String pathToFolder) {
		File file = new File(pathToFolder);
		
		if (file.isDirectory()) {
			return file.listFiles();
		} else {
			throw new RuntimeException("Given file is not a directory");
		}
	}
}
