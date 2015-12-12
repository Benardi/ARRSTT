package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.ExperimentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.factories.MinimizationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.ReqBuilderType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-30
 * 
 */

/**
 * <b>Objective:</b> This class is used by the facade to create and run ARRSTT's experiments,
 * such as selection experiment and generation experiment.
 * <br>
 * <b>Description of use:<b> It's only public method is execute() that is responsible for the
 * creation and execution of ARRSTT's experiments.
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
	private List<MinimizationType> minimizationTreatments;
	private List<Integer> loopCoverages;
	private List<DVCType> dvcs;
	private ReqBuilderType builder;
	private double selectPercentage;
	//private double maskPercentage;
	private ExperimentFactory factory;
	
	/**
	 * The controller's constructor. Initializes the needed lists and factories.
	 */
	public ARRSTTController() {
		generationTreatments = new ArrayList<GenerationType>();
		selectionTreatments = new ArrayList<SelectionType>();
		minimizationTreatments = new ArrayList<MinimizationType>();
		loopCoverages = new ArrayList<Integer>();
		dvcs = new ArrayList<DVCType>();
		factory = new ExperimentFactory();
	}
	
	/**
	 * <b>Objective:<b> This method creates and executes a certain experiment. It
	 * receives a list of String lists, each one containing vital information about
	 * the experiment's attributes, such as which experiment is going to be created
	 * and executed and the independent variables.
	 * <br>
	 * <b>Exemple of use:<b> This method is used in the ARRSTTFacade.
	 * @param inputs
	 * 			The list of String lists containing the necessary information to create
	 * and execute the experiments.
	 * @throws Exception An exception is throwed if the experiment type in the inputs
	 * list is invalid.
	 */
	public void execute(List<List<String>> inputs) throws Exception {		
		switch(inputs.get(0).get(0).toLowerCase()) {
			case "generation":
				buildGeneration(inputs);
				break;
			case "selection":
				buildSelection(inputs);
				break;
			case "minimization":
				buildMinimization(inputs);
				break;
			default:
				throw new Exception("Invalid experiment type.");
		}
		
		executeExperiment();
	}
	
	private void buildGeneration(List<List<String>> inputs) throws Exception {
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
			this.addDvcs(dvc);
		}
		
		experiment = factory.buildGeneration(this.loopCoverages, this.generationTreatments, this.dvcs);
	}
	
	private void buildSelection(List<List<String>> inputs) throws Exception {
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
			this.addDvcs(dvc);
		}
		
		experiment = factory.buildSelection(selectionTreatments, selectPercentage, this.dvcs);
	}
	
	private void buildMinimization(List<List<String>> inputs) throws Exception {
		// TÉCNICA DE GERAÇÃO (BFS, DFS) / TÉCNICA DE MINIMIZAÇÃO (G, GE, GRE, H) / REQUIREMENT BUILDER (AP, AT)
		List<String> minimizationAlgorithms = inputs.get(1);
		List<String> requirementBuilders = inputs.get(2);
		List<String> dvcs = inputs.get(3);
		
		for (String minimizationAlgorithm : minimizationAlgorithms) {
			this.addMinimizationTreatment(minimizationAlgorithm);
		}
		
		for (String requirementBuilder : requirementBuilders) {
			this.addRequirementBuilder(requirementBuilder);
		}
		
		for (String dvc : dvcs) {
			this.addDvcs(dvc);
		}
		
		experiment = factory.buildMinimization(minimizationTreatments, builder, this.dvcs);
	}
	
	private void executeExperiment() {
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
			selectionTreatments.add(SelectionType.RANDOMIZED);
		} else if (treatmentName.equals("biggest")) {
			selectionTreatments.add(SelectionType.BIGGEST);
		} else if (treatmentName.equals("similarity")) {
			selectionTreatments.add(SelectionType.SIMILARITY);
		}
	}
	
	private void addMinimizationTreatment(String treatmentName) {
		if (treatmentName.equals("G")) {
			minimizationTreatments.add(MinimizationType.GREEDY);
		} else if (treatmentName.equals("GE")) {
			minimizationTreatments.add(MinimizationType.GREEDY_ESSENCIAL);
		} else if (treatmentName.equals("GRE")) {
			minimizationTreatments.add(MinimizationType.GREEDY_ESSENCIAL_REDUNDANT);
		} else if (treatmentName.equals("H")) {
			minimizationTreatments.add(MinimizationType.HARROLD);
		}
	}
	
	private void addRequirementBuilder(String builderName) {
		if (builderName.equals("AP")) {
			builder = ReqBuilderType.APCoverage;
		} else if (builderName.equals("AT")) {
			builder = ReqBuilderType.ATCoverage;
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
	
	private void addDvcs(String dvcType) {
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
		} else if (dvcType.equals(DVCType.REDUCTION)) {
			dvcs.add(DVCType.REDUCTION);
		}
	}
}
