package br.edu.ufcg.splab.experiment_hierarchy.core.experiment_rep;

import java.io.IOException;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.ErrorStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentFile;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/**
 * This is the class that should execute the specific experiment made on the
 * ARRSTT project.
 */
public class SelectionExperiment {
	public static final String LINE_END = System.getProperty("line.separator");

    private ExperimentFile failureFile;
	private ExperimentFile timeFile;
	private ExperimentFile defectFile;
	private ExperimentFile tsSizeFile;

	/**
	 * Build a new TeamExperiment passing all the loop coverages.
	 * 
	 * @param loopCoverages
	 *            The loop coverages in which the searches will run.
	 * @throws Exception
	 */
	public SelectionExperiment() throws Exception {
	    this.failureFile = new ExperimentFile("Failure");
	    this.timeFile = new ExperimentFile("Time");
	    this.defectFile = new ExperimentFile("Defect");
	    this.tsSizeFile = new ExperimentFile("TSSizes");
	}

	/**
	 * This method takes care of generating all the output data of this
	 * particular experiment.
	 * 
	 * @throws Exception
	 */
	public void runExperiment(List<Tuple<ExecutableTreatment>> combinations)
			throws Exception {

		int count = 0;
		for (Tuple<ExecutableTreatment> combination : combinations) {
			for (ExecutableTreatment treatment : combination) {
				Long initTime = System.nanoTime();
		        TestSuite testSuite = treatment.execute();
		        Long endTime = System.nanoTime();

		        Long timeDif = (endTime - initTime);
		
		        ErrorStructure errorStructure = new ErrorStructure(testSuite);
		    
		        timeFile.appendContent(timeDif + "\t");
		        failureFile.appendContent(errorStructure.countFails() + "\t");
		        defectFile.appendContent(errorStructure.countDefects() + "\t");
		        tsSizeFile.appendContent(testSuite.size() + "\t");
				
				// Probably will go to formatter later.
				count += 1;
				if (count == 31) {
					timeFile.appendContent(LINE_END);
					failureFile.appendContent(LINE_END);
					defectFile.appendContent(LINE_END);
					tsSizeFile.appendContent(LINE_END);
					count = 0;
				}
			}
		}

		saveFiles();
	}

	private void saveFiles() throws IOException {
		timeFile.save();
		failureFile.save();
		defectFile.save();
		tsSizeFile.save();
	}
}

