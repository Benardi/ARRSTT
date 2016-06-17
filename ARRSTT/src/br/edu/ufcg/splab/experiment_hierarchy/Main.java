package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;

import br.edu.ufcg.splab.experiment_hierarchy.facade.ARRSTTFacade;

public class Main {
	private static ARRSTTFacade facade;
	
	public static void main(String[] args) throws Exception {
		facade = new ARRSTTFacade();
		
		experiment1();
		//experiment2();
	}
	
	public static void experiment1() {
		File[] artifacts = directoryToPath(new File("extras\\input_examples"));
		String[] dvcs = {"SIZE", "FAILURES"};
		
		facade.setOutputFolder("experiment_results/");
		facade.setArtifacts(artifacts);
		
		facade.runNeoSelectionExperiment(dvcs);
	}
	
	public static void experiment2() {
		File[] artifacts = directoryToPath(new File("extras\\input_examples"));
		String[] dvcs = {"SIZE", "FAILURES"};
		
		facade.setOutputFolder("experiment_results/");
		facade.setArtifacts(artifacts);
		
		facade.runNeoMinimizationExperiment(dvcs);
	}
	
	private static File[] directoryToPath(File file) {
		if (file.isDirectory()) {
			return file.listFiles();
		} else {
			throw new RuntimeException("Given file is not a directory");
		}
	}
}
