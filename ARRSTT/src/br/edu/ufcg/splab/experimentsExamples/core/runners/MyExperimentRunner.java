package br.edu.ufcg.splab.experimentsExamples.core.runners;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.DataFormater;
import br.edu.ufcg.splab.arrsttFramework.IRunner;
import br.edu.ufcg.splab.arrsttFramework.util.Artifact;
import br.edu.ufcg.splab.arrsttFramework.util.ExperimentDataGroup;
import br.edu.ufcg.splab.experimentsExamples.util.ResultData;

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
public class MyExperimentRunner implements IRunner {
	private DataFormater formater;
	
	/**
	 * MyExperimentRunner's constructor.
	 * @param headerRowText
	 * 			The text in this class' row's header.
	 * @param lineSize
	 * 			How long a line will go.
	 */
	public MyExperimentRunner(DataFormater formater) {
		this.formater = formater;
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
		List<ResultData> results = new ArrayList<>();

		for (Artifact art : artifacts) {
			results.addAll(art.getDVCResults());
		}
		List<ResultData> fileResult = new ArrayList<>();
		List<ResultData> reductionResult = new ArrayList<>();
		List<ResultData> sizeResult = new ArrayList<>();
		List<ResultData> testSuiteResult = new ArrayList<>();
		List<ResultData> timeResult = new ArrayList<>();
		List<ResultData> mmmResult = new ArrayList<>();
		List<ResultData> coverageResult = new ArrayList<>();
		
		for(ResultData data : results){
			if(data.getDvcString().equals("Failures by file")){
				fileResult.add(data);
			} else if(data.getDvcString().equals("Reduction")){
				reductionResult.add(data);
			} else if(data.getDvcString().equals("Final Size")){
				sizeResult.add(data);
			} else if(data.getDvcString().equals("Final Suite")){
				testSuiteResult.add(data);
			} else if(data.getDvcString().equals("Time")){
				timeResult.add(data);
			} else if(data.getDvcString().equals("MediaMaxMin")){
				mmmResult.add(data);
			} else if(data.getDvcString().equals("Coverage")){
				coverageResult.add(data);
			}
		}
		
		
		List<ExperimentDataGroup> finalResults = new ArrayList<>();
		finalResults.add(new ExperimentDataGroup("FailuresByFile_Dvc", formater.format(fileResult).toString()));
		finalResults.add(new ExperimentDataGroup("TSReduction_Dvc", formater.format(reductionResult).toString()));
		finalResults.add(new ExperimentDataGroup("TSFinalSize_Dvc", formater.format(sizeResult).toString()));
		finalResults.add(new ExperimentDataGroup("TSFinal_Dcv", formater.format(testSuiteResult).toString()));
		finalResults.add(new ExperimentDataGroup("Time_Dvc", formater.format(timeResult).toString()));
		finalResults.add(new ExperimentDataGroup("MediaMaxMin_Dvc", formater.format(mmmResult).toString()));
		finalResults.add(new ExperimentDataGroup("Coverage_Dvc", formater.format(coverageResult).toString()));
		
		return finalResults;
	}
	
	public void setFormater(DataFormater formater){
		this.formater = formater;
	}
	
}
