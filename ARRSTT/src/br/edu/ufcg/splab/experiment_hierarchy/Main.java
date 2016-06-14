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
	 *  "GREEDY"
	 *  "GREEDY_ESSENCIAL"
	 *  "GREEDY_ESSENCIAL_REDUNDANT"
	 *  "HARROLD";
	 * 
	 */
	public static void main(String[] args) throws Exception {
		facade = new ARRSTTFacade();
		
		experiment1();
	}
	
	public static void experiment1() {
		String[] artifacts = {"input_examples\\iaron_easytoy1.tgf"};
		String[] techniques = {"BIGGEST", "SIMILARITY"};
		String[] dvcs = {"SIZE", "FAILURES"};
		
		facade.setOutputFolder("experiment_results/");
		facade.setArtifacts(artifacts);
		
		facade.setupSelectionExperiment(techniques, dvcs, 0.9);
		facade.execute(dvcs);
	}
	
	public static void experiment2() {
		String[] techniques = {"BIGGEST", "SIMILARITY"};
		String[] dvcs = {"SIZE", "FAILURES"};
		
		facade.setOutputFolder("experiment_results/");
		facade.setArtifacts(directoryToPath(new File("input_examples/")));
		
		facade.setupSelectionExperiment(techniques, dvcs, 0.9);
		facade.execute(dvcs);
	}
	
	private static File[] directoryToPath(File file) {
		if (file.isDirectory()) {
			return file.listFiles();
		} else {
			throw new RuntimeException("Given file is not a directory");
		}
	}
}
