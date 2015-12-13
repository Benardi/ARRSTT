package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.ExperimentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.factories.MinimizationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.ExperimentType;
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
	private Experiment experiment;
	private List<GenerationType> generationTreatments;
	private List<SelectionType> selectionTreatments;
	private List<MinimizationType> minimizationTreatments;
	private List<Integer> loopCoverages;
	private List<DVCType> dvcs;
	private ReqBuilderType builder;
	private double selectionPercentage;
	//private double maskPercentage;
	private ExperimentFactory factory;
	private ExperimentType experimentType;
	
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
		String experimentString = inputs.get(0).get(0).toUpperCase();
		
		switch(experimentString) {
			case "GENERATION":
				this.experimentType = ExperimentType.GENERATION;
				buildGeneration(inputs);
				break;
			case "SELECTION":
				this.experimentType = ExperimentType.SELECTION;
				buildSelection(inputs);
				break;
			case "MINIMIZATION":
				this.experimentType = ExperimentType.MINIMIZATION;
				buildMinimization(inputs);
				break;
			default:
				throw new RuntimeException("Experiment Type Not Found");
		}
		
		executeExperiment();
	}
	
	private void buildGeneration(List<List<String>> inputs) throws Exception {
		List<String> generationTreatments = inputs.get(1);
		List<String> loopCoverages = inputs.get(2);
		List<String> dvcs = inputs.get(3);
		
		for (String generationTreatment : generationTreatments) {
			this.addTreatment(generationTreatment);
		}
		
		for (String loopCoverage : loopCoverages) {
			this.addLoopCoverage(loopCoverage);
		}
		
		for (String dvc : dvcs) {
			this.addDvc(dvc);
		}
		
		experiment = factory.buildGeneration(this.loopCoverages, this.generationTreatments, this.dvcs);
	}
	
	private void addLoopCoverage(String loopCoverage) {
		loopCoverages.add(Integer.parseInt(loopCoverage));
	}
	
	private void buildSelection(List<List<String>> inputs) throws Exception {
		List<String> selectionTreatments = inputs.get(1);
		List<String> selectionPercentages = inputs.get(2);
		List<String> dvcs = inputs.get(3);
		
		for (String selectionTreatment : selectionTreatments) {
			this.addTreatment(selectionTreatment);
		}
		
		for (String selectionPercentage : selectionPercentages) {
			this.addSelectionPercentage(selectionPercentage);
		}
		
		/*for (String maskPercentage : maskPercentages) {
			this.addMaskPercentage(maskPercentage);
		}*/
		
		for (String dvc : dvcs) {
			this.addDvc(dvc);
		}
		
		experiment = factory.buildSelection(this.selectionTreatments, selectionPercentage, this.dvcs);
	}
	
	private void addSelectionPercentage(String percentage) {
		this.selectionPercentage = Double.parseDouble(percentage);
	}
	
	/*public void addMaskPercentage(String maskPercentage) {
		this.maskPercentage = Double.parseDouble(maskPercentage);
	}*/
	
	private void buildMinimization(List<List<String>> inputs) throws Exception {
		List<String> minimizationTreatments = inputs.get(1);
		List<String> builder = inputs.get(2);
		List<String> dvcs = inputs.get(3);
		
		for (String minimizationTreatment : minimizationTreatments) {
			addTreatment(minimizationTreatment);
		}
		
		for (String requirementBuilder : builder) {
			addRequirementBuilder(requirementBuilder);
		}
		
		for (String dvc : dvcs) {
			addDvc(dvc);
		}
		
		experiment = factory.buildMinimization(this.minimizationTreatments, this.builder, this.dvcs);
	}
	
	private void addRequirementBuilder(String builderString) {
		switch(builderString) {
			case "AP":
				this.builder = ReqBuilderType.APCoverage;
				break;
			case "AT":
				this.builder = ReqBuilderType.ATCoverage;
				break;
			default:
				throw new RuntimeException("Requirement Builder Not Found");
		}
	}
	
	private void addTreatment(String treatmentString) {
		switch(experimentType) {
			case MINIMIZATION:
				addMinimizationTreatment(treatmentString);
				break;
			case SELECTION:
				addSelectionTreatment(treatmentString);
				break;
			case GENERATION:
				addGenerationTreatment(treatmentString);
				break;
			default:
				throw new RuntimeException("Experiment Type Not Found");
		}
	}
	
	private void addGenerationTreatment(String treatmentString) {
		treatmentString = treatmentString.toUpperCase();
		
		switch(treatmentString) {
			case "BFS":
				this.generationTreatments.add(GenerationType.BFS);
				break;
			case "DFS":
				this.generationTreatments.add(GenerationType.DFS);
				break;
			default:
				throw new RuntimeException("Generation Treatment Not Found");
		}
	}
	
	private void addSelectionTreatment(String treatmentString) {
		treatmentString = treatmentString.toUpperCase();
		
		switch(treatmentString) {
			case "RANDOM":
				this.selectionTreatments.add(SelectionType.RANDOMIZED);
				break;
			case "BIGGEST":
				this.selectionTreatments.add(SelectionType.BIGGEST);
				break;
			case "SIMILARITY":
				this.selectionTreatments.add(SelectionType.SIMILARITY);
				break;
			default:
				throw new RuntimeException("Selection Treatment Not Found");
		}
	}
	
	private void addMinimizationTreatment(String treatmentString) {
		treatmentString = treatmentString.toUpperCase();
		
		switch(treatmentString) {
			case "G":
				this.minimizationTreatments.add(MinimizationType.GREEDY);
				break;
			case "GE":
				this.minimizationTreatments.add(MinimizationType.GREEDY_ESSENCIAL);
				break;
			case "GRE":
				this.minimizationTreatments.add(MinimizationType.GREEDY_ESSENCIAL_REDUNDANT);
				break;
			case "H":
				this.minimizationTreatments.add(MinimizationType.HARROLD);
				break;
			default:
				throw new RuntimeException("Minimization Treatment Not Found");
		}
	}
	
	private void addDvc(String dvcString) {
		dvcString = dvcString.toUpperCase();
		
		switch(dvcString) { 
			case "SIZE":
				dvcs.add(DVCType.SIZE);
				break;
			case "DEFECTS":
				dvcs.add(DVCType.DEFECTS);
				break;
			case "DEFECTIVE EDGES":
				dvcs.add(DVCType.DEFECTIVE_EDGES);
				break;
			case "FAILURES":
				dvcs.add(DVCType.FAILURES);
				break;
			case "REDUCTION":
				dvcs.add(DVCType.REDUCTION);
				break;
			default:
				throw new RuntimeException("DVC Not Found");
		}
	}
	
	private void executeExperiment() {
		experiment.execute();
	}
}
