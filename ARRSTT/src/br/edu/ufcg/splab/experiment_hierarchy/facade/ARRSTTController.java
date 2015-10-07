package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.ExperimentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-30
 * 
 */

public class ARRSTTController {	
	public static final String[] EXPERIMENT_TYPES = {"GENERATION", "SELECTION"};
	public static final String[] GENERATION_TREATMENTS = {"BFS", "DFS"};
	public static final String[] SELECTION_TREATMENTS = {"RANDOMIZED", "BIGGEST", "SIMILARITY"};
	public static final String[] DVC_TYPES = {"TIME", "SIZE", "DEFECTS", "DEFECTIVE_TRANSITIONS", "FAILURES"};
	
	private Experiment experiment;
	private List<GenerationType> generationTreatments;
	private List<SelectionType> selectionTreatments;
	private List<Integer> loopCoverages;
	private List<DVCType> dvcs;
	private double selectPercentage;
	//private double maskPercentage;
	private ExperimentFactory factory;
	
	public ARRSTTController() {
		generationTreatments = new ArrayList<GenerationType>();
		selectionTreatments = new ArrayList<SelectionType>();
		loopCoverages = new ArrayList<Integer>();
		dvcs = new ArrayList<DVCType>();
		factory = new ExperimentFactory();
	}
	
	public void buildGeneration(List<List<String>> inputs) throws Exception {
		List<String> algorithms = inputs.get(1);
		List<String> loopCoverages = inputs.get(2);
		List<String> dvcs = inputs.get(3);
		
		for (String algorithm : algorithms) {
			this.addGenerationTreatment(algorithm);
		}
		
		for (String loopCoverage : loopCoverages) {
			this.addLoopCoverage(loopCoverage);
		}
		
		for (String dvc : dvcs) {
			this.addGenerationDvcs(dvc);
		}
		
		experiment = factory.buildGeneration(this.loopCoverages, this.generationTreatments, this.dvcs);
	}
	
	public void buildSelection(List<List<String>> inputs) throws Exception {
		List<String> algorithms = inputs.get(1);
		List<String> selectionPercentages = inputs.get(2);
		List<String> dvcs = inputs.get(3);
		
		for (String algorithm : algorithms) {
			this.addSelectionTreatment(algorithm);
		}
		
		for (String selectPercentage : selectionPercentages) {
			this.addSelectPercentage(selectPercentage);
		}
		
		/*for (String maskPercentage : maskPercentages) {
			this.addMaskPercentage(maskPercentage);
		}*/
		
		for (String dvc : dvcs) {
			this.addSelectionDvcs(dvc);
		}
		
		System.out.println(Arrays.toString(inputs.toArray()));
		experiment = factory.buildSelection(selectionTreatments, selectPercentage, this.dvcs);
	}
	
	public void executeExperiment() {
		experiment.execute();
	}
	
	private void addGenerationTreatment(String treatmentName) {
		if (treatmentName.equals(GENERATION_TREATMENTS[0])) {
			generationTreatments.add(GenerationType.BFS);
		} else if (treatmentName.equals(GENERATION_TREATMENTS[1])) {
			generationTreatments.add(GenerationType.DFS);
		}
	}
	
	private void addSelectionTreatment(String treatmentName) {
		if (treatmentName.equals("random")) {
			System.out.println("olá pessoas");
			selectionTreatments.add(SelectionType.RANDOMIZED);
		} else if (treatmentName.equals("biggest")) {
			selectionTreatments.add(SelectionType.BIGGEST);
		} else if (treatmentName.equals("similarity")) {
			selectionTreatments.add(SelectionType.SIMILARITY);
		}
	}
	
	private void addLoopCoverage(String loopCoverage) {
		loopCoverages.add(Integer.parseInt(loopCoverage));
	}
	
	private void addSelectPercentage(String selectPercentage) {
		this.selectPercentage = Double.parseDouble(selectPercentage);
	}
	
	/*public void addMaskPercentage(String maskPercentage) {
		this.maskPercentage = Double.parseDouble(maskPercentage);
	}*/
	
	public void addGenerationDvcs(String dvcType) {
		dvcType = dvcType.toUpperCase();
		
		if (dvcType.equals("TIME")) {
			System.out.println("olá pessoas");
			dvcs.add(DVCType.TIME);
		} else if (dvcType.equals("SIZE")) {
			dvcs.add(DVCType.SIZE);
		}
	}
	
	public void addSelectionDvcs(String dvcType) {
		dvcType = dvcType.toUpperCase();
		
		if (dvcType.equals("TIME")) {
			dvcs.add(DVCType.TIME);
		} else if (dvcType.equals("SIZE")) {
			dvcs.add(DVCType.SIZE);
		} else if (dvcType.equals("DEFECTS")) {
			dvcs.add(DVCType.DEFECTS);
		} else if (dvcType.equals("DEFECTIVE EDGES")) {
			dvcs.add(DVCType.DEFECTIVE_EDGES);
		} else if (dvcType.equals("FAILURES")) {
			dvcs.add(DVCType.FAILURES);
		}
	}
}
