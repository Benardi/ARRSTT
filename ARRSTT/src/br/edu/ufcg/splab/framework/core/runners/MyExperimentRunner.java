package br.edu.ufcg.splab.framework.core.runners;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.framework.core.api.InterfaceRunner;
import br.edu.ufcg.splab.framework.core.artifacts.Artifact;
import br.edu.ufcg.splab.util.ArresttConstants;
import br.edu.ufcg.splab.util.ExperimentDataGroup;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Documentation												José Benardi		2016-07-12
 * 
 */
/**
 * <b>Objective:</b> This class represents a module capable of executing
 * techniques in all its instances according to an experimental design
 * previously set. <br>
 * <b>Description of use:</b> This class is used to instance Runners in order to
 * execute ExperimentDataGroups.
 *
 */
public class MyExperimentRunner implements InterfaceRunner {
	private int lineSize;
	private String headerRowText;
	
	/**
	 * MyExperimentRunner's constructor.
	 * @param headerRowText
	 * 			The text in this class' row's header.
	 * @param lineSize
	 * 			How long a line will go.
	 */
	public MyExperimentRunner(String headerRowText, int lineSize) {
		this.lineSize = lineSize;
		this.headerRowText = headerRowText;
	}

	/**
	 * <b>Objective:</b> Generates an experiment's result. <br>
	 * <b>Example of use:</b> In the ARRSTT Experiment this method is used to
	 * generate results from a group of artifacts.
	 * 
	 * @param artifacts
	 * 
	 * @return The experiment's result.
	 */
	@Override
	public List<ExperimentDataGroup> runExperiment(List<Artifact> artifacts) {
		List<StringBuffer> results = new ArrayList<>();

		for (Artifact art : artifacts) {
			results.add(art.getDVCResults());
		}
		StringBuffer fileResult = new StringBuffer();
		StringBuffer reductionResult = new StringBuffer();
		StringBuffer sizeResult = new StringBuffer();
		StringBuffer testSuiteResult = new StringBuffer();
		StringBuffer timeResult = new StringBuffer();
		StringBuffer mmmResult = new StringBuffer();
		StringBuffer coverageResult = new StringBuffer();

		writeHeaderRow(fileResult, reductionResult, sizeResult, testSuiteResult, timeResult, mmmResult, coverageResult);

		for (int i = 0; i < results.size(); i++) {

			StringBuffer partialResult = results.get(i);
			String aux = partialResult.toString();
			String[] split = aux.split("meu_divisor");

			fileResult.append(split[0] + "\t");
			reductionResult.append(split[1] + "\t");
			sizeResult.append(split[2] + "\t");
			testSuiteResult.append(split[3] + "\t");
			timeResult.append(split[4] + "\t");
			mmmResult.append(split[5] + "\t");
			coverageResult.append(split[6] + "\t");

			if ((i + 1) % lineSize == 0) {
				fileResult.append(ArresttConstants.LINE_SEPARATOR);
				reductionResult.append(ArresttConstants.LINE_SEPARATOR);
				sizeResult.append(ArresttConstants.LINE_SEPARATOR);
				testSuiteResult.append(ArresttConstants.LINE_SEPARATOR);
				timeResult.append(ArresttConstants.LINE_SEPARATOR);
				mmmResult.append(ArresttConstants.LINE_SEPARATOR);
				coverageResult.append(ArresttConstants.LINE_SEPARATOR);
			}
		}

		List<ExperimentDataGroup> finalResults = new ArrayList<>();
		finalResults.add(new ExperimentDataGroup("FailuresByFile_Dvc", fileResult.toString()));
		finalResults.add(new ExperimentDataGroup("TSReduction_Dvc", reductionResult.toString()));
		finalResults.add(new ExperimentDataGroup("TSFinalSize_Dvc", sizeResult.toString()));
		finalResults.add(new ExperimentDataGroup("TSFinal_Dcv", testSuiteResult.toString()));
		finalResults.add(new ExperimentDataGroup("Time_Dvc", timeResult.toString()));
		finalResults.add(new ExperimentDataGroup("MediaMaxMin_Dvc", mmmResult.toString()));
		finalResults.add(new ExperimentDataGroup("Coverage_Dvc", coverageResult.toString()));

		return finalResults;
	}
	
	/**
	 * <b>Objective:</b> Create a new line with its header. <br>
	 * <b>Example of use:</b> In this class this method is used to separate lines
	 * 
	 * @param stringBuffers
	 * 				The string buffer used to construct the result.
	 */
	private void writeHeaderRow(StringBuffer... stringBuffers) {
		for (int i = 0; i < stringBuffers.length; i++) {
			stringBuffers[i].append(headerRowText + ArresttConstants.LINE_SEPARATOR);
		}
	}
}
