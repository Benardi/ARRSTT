package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;

import br.edu.ufcg.splab.experiment_hierarchy.facade.ARRSTTFacade;

public class Main {
	private static ARRSTTFacade facade;
	
	public static void main(String[] args) throws Exception {
		facade = new ARRSTTFacade();
		
		//experiment1();
		//experiment2();
		//experiment3();
		experiment4();
	}
	
	public static void experiment1() {
		File[] artifacts = directoryToPath(new File("ARRSTT\\extras\\input_examples\\"));
		String[] dvcs = {"ARRSTT\\extras\\files\\default.txt"};
		
		facade.setOutputFolder("ARRSTT\\experiment_results\\");
		facade.setArtifacts(artifacts);
		
		facade.runNeoSelectionExperiment(dvcs, 0);
	}
	
	public static void experiment2() {
		File[] artifacts = directoryToPath(new File("ARRSTT\\extras\\input_examples\\"));
		String[] dvcs = {"ARRSTT\\extras\\files\\default.txt"};
		
		facade.setOutputFolder("ARRSTT\\experiment_results\\");
		facade.setArtifacts(artifacts);
		
		facade.runNeoMinimizationExperiment(dvcs, 0);
	}
	
	public static void experiment3() {
		File[] artifacts = directoryToPath(new File("extras/input_examples/")); 
		String[] files = {"extras\\files\\easytoy4_fails.txt"};
		
		facade.setOutputFolder("experiment_results\\");
		facade.setArtifacts(artifacts);
		
		facade.runNeoSelectionExperiment(files, 0);
	}
	
	public static void experiment4() {
		String[] artifacts = {"extras/xmls/EasyToy4.testsuite-deep.xml"};  
		String[] files = {"extras/files/easytoy4_fails.txt"};
		
		facade.setOutputFolder("experiment_results/");
		facade.setArtifacts(artifacts);
		
		facade.runNeoMinimizationExperiment(files, 1);
	}
	
	private static File[] directoryToPath(File file) {
		if (file.isDirectory()) {
			return file.listFiles();
		} else {
			throw new RuntimeException("Given file is not a directory");
		}
	}
}
