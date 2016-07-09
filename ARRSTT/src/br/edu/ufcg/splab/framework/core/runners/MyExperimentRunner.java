package br.edu.ufcg.splab.framework.core.runners;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.framework.core.api.InterfaceRunner;
import br.edu.ufcg.splab.framework.core.artifacts.Artifact;
import br.edu.ufcg.splab.util.ArresttConstants;
import br.edu.ufcg.splab.util.ExperimentDataGroup;

public class MyExperimentRunner implements InterfaceRunner{
	private int lineSize;
	private String headerRowText;
	
	public MyExperimentRunner(String headerRowText, int lineSize){
		this.lineSize = lineSize;
		this.headerRowText = headerRowText;
	}
	
	@Override
	public List<ExperimentDataGroup> runExperiment(List<Artifact> artifacts) {
		List<StringBuffer> results = new ArrayList<>();
		
		for(Artifact art : artifacts){
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
		
		for(int i = 0; i < results.size(); i++){
			
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
			
			if((i+1) % lineSize == 0){
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

	private void writeHeaderRow(StringBuffer...stringBuffers) {
		for (int i = 0; i < stringBuffers.length; i++) {
			stringBuffers[i].append(headerRowText + ArresttConstants.LINE_SEPARATOR);
		}
	}
}
