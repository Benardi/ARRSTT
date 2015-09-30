package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.ExperimentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectiveEdgesCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectsCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTFailuresCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTTimeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.ExperimentType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-30
 * 
 */

public class ARRSTTFacade {
	public static final String[] EXPERIMENT_TYPES = {"GENERATION", "SELECTION"};
	public static final String[] GENERATION_TREATMENTS = {"BFS", "DFS"};
	public static final String[] SELECTION_TREATMENTS = {"RANDOMIZED", "BIGGEST", "SIMILARITY"};
	public static final String[] DVC_TYPES = {"TIME", "SIZE", "DEFECTS", "DEFECTIVE_TRANSITIONS", "FAILURES"};
	
	private ExperimentType experimentType;
	private List<GenerationType> generationTreatments;
	private List<SelectionType> selectionTreatments;
	private List<Integer> loopCoverages;
	//private List<DependentVariableCollector> dvcs;
	private double selectPercentage;
	//private double maskPercentage;
	
	public ARRSTTFacade() {
		generationTreatments = new ArrayList<GenerationType>();
		selectionTreatments = new ArrayList<SelectionType>();
		loopCoverages = new ArrayList<Integer>();
		//dvcs = new ArrayList<DependentVariableCollector>();
	}
	
	public void selectExperiment(String experimentName) {
		if (experimentName.equals(EXPERIMENT_TYPES[0])) {
			experimentType = ExperimentType.GENERATION;
		} else if (experimentName.equals(EXPERIMENT_TYPES[1])) {
			experimentType = ExperimentType.SELECTION;
		}
	}
	
	public void addGenerationTreatment(String treatmentName) {
		if (treatmentName.equals(GENERATION_TREATMENTS[0])) {
			generationTreatments.add(GenerationType.BFS);
		} else if (treatmentName.equals(GENERATION_TREATMENTS[1])) {
			generationTreatments.add(GenerationType.DFS);
		}
	}
	
	public void addSelectionTreatment(String treatmentName) {
		if (treatmentName.equals(SELECTION_TREATMENTS[0])) {
			selectionTreatments.add(SelectionType.RANDOMIZED);
		} else if (treatmentName.equals(SELECTION_TREATMENTS[1])) {
			selectionTreatments.add(SelectionType.BIGGEST);
		} else if (treatmentName.equals(SELECTION_TREATMENTS[2])) {
			selectionTreatments.add(SelectionType.SIMILARITY);
		}
	}
	
	public void addLoopCoverage(String loopCoverage) {
		loopCoverages.add(Integer.parseInt(loopCoverage));
	}
	
	public void addSelectPercentage(double selectPercentage) {
		this.selectPercentage = selectPercentage;
	}
	
	/*public void addMaskPercentage(double maskPercentage) {
		this.maskPercentage = Double.parseDouble(maskPercentage);
	}*/
	
	/*public void addGenerationDvcs(String dvcType) {
		if (dvcType.equals(DVC_TYPES[0])) {
			dvcs.add(new ARRSTTTimeCollector());
		} else if (dvcType == DVC_TYPES[1]) {
			dvcs.add(new ARRSTTSizeCollector());
		}
	}
	
	public void addSelectionDvcs(String dvcType) {
		if (dvcType.equals(DVC_TYPES[0])) {
			dvcs.add(new ARRSTTTimeCollector());
		} else if (dvcType == DVC_TYPES[1]) {
			dvcs.add(new ARRSTTSizeCollector());
		} else if (dvcType == DVC_TYPES[2]) {
			dvcs.add(new ARRSTTDefectsCollector());
		} else if (dvcType == DVC_TYPES[3]) {
			dvcs.add(new ARRSTTDefectiveEdgesCollector());
		} else if (dvcType == DVC_TYPES[4]) {
			dvcs.add(new ARRSTTFailuresCollector());
		}
	}*/
	
	public void executeExperiment() throws Exception {
		ExperimentFactory factory = new ExperimentFactory();
		
		if (experimentType == ExperimentType.GENERATION) {
			GenerationType[] generationAlgorithms = new GenerationType[generationTreatments.size()];
			
			for (int i = 0; i < generationAlgorithms.length; i++) {
				generationAlgorithms[i] = generationTreatments.get(i);
			}
			
			int[] loopCoverages = new int[this.loopCoverages.size()];
			
			for (int i = 0; i < loopCoverages.length; i++) {
				loopCoverages[i] = this.loopCoverages.get(i);
			}
			
			factory.buildGeneration(loopCoverages, generationAlgorithms).execute();
		} else if (experimentType == ExperimentType.SELECTION) {
			SelectionType[] selectionAlgorithms = new SelectionType[selectionTreatments.size()];
			
			for (int i = 0; i < selectionAlgorithms.length; i++) {
				selectionAlgorithms[i] = selectionTreatments.get(i);
			}
			
			factory.buildSelection(selectionAlgorithms, selectPercentage).execute();
		}
	}
}
