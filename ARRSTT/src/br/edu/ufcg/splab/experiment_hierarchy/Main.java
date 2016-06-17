package br.edu.ufcg.splab.experiment_hierarchy;

import java.io.File;

import br.edu.ufcg.splab.experiment_hierarchy.facade.ARRSTTFacade;

public class Main {
	private static ARRSTTFacade facade;
	
	/*
	 *  DVCs:
	 * "DEFECTIVE_EDGES"
	 * "DEFECTS"
	 * "FAILURES"
	 * "SIZE"
	 * "TIME" -> DO NOT USE IT YET
	 * "REDUCTION"
	 * "MEDIA_MAX_MIN"
	 * "MOST_REPEATED_TRANSITION"
	 * "REDUNDANCE"
	 * 
	 *  Generation Techniques:
	 * "BFS"
	 * "DFS"
	 *  
	 *  Selection Techniques:
	 * "BIGGEST"
	 * "SIMILARITY"
	 * "RANDOMIZED"
	 * 
	 *   Minimization Techniques:
	 *  "G"
	 *  "GE"
	 *  "GRE"
	 *  "H";
	 * 
	 */
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
