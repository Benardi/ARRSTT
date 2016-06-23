package br.edu.ufcg.splab.experiment_hierarchy.core.runners;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.util.ArresttConstants;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentData;

public class NeoExperimentRunner implements InterfaceRunner{
	private int lineSize;
	private String[] rowHeader;
	
	public NeoExperimentRunner(int lineSize) {
		this.lineSize = lineSize;
		// SET ROW HEADER HERE.
	}
	
	@Override
	public List<ExperimentData> runExperiment(List<TreatmentArtifact> artifacts) {
		List<StringBuffer> results = new ArrayList<>();
		
		for(TreatmentArtifact art : artifacts){
			results.add(art.getDVCResults());
		}
		
		StringBuffer fileResult = new StringBuffer();
		StringBuffer reductionResult = new StringBuffer();
		StringBuffer sizeResult = new StringBuffer();
		StringBuffer testSuiteResult = new StringBuffer();
		StringBuffer timeResult = new StringBuffer();
		StringBuffer mmmResult = new StringBuffer();
		
		List<StringBuffer> output = new ArrayList<StringBuffer>();
		results.add(fileResult);
		results.add(reductionResult);
		results.add(sizeResult);
		results.add(testSuiteResult);
		results.add(timeResult);
		results.add(mmmResult);
		
		buildRowHeader(rowHeader, output);
		
		for(int i = 0; i < results.size(); i++){
			StringBuffer partialResult = results.get(i);
			String aux = partialResult.toString();
			String[] split = aux.split("/");
			
			fileResult.append(split[0] + "\t");
			reductionResult.append(split[1] + "\t");
			sizeResult.append(split[2] + "\t");
			testSuiteResult.append(split[3] + "\t");
			timeResult.append(split[4] + "\t");
			mmmResult.append(split[5] + "\t");
			
			if((i+1) % lineSize == 0) {
				fileResult.append(ArresttConstants.LINE_SEPARATOR);
				reductionResult.append(ArresttConstants.LINE_SEPARATOR);
				sizeResult.append(ArresttConstants.LINE_SEPARATOR);
				testSuiteResult.append(ArresttConstants.LINE_SEPARATOR);
				timeResult.append(ArresttConstants.LINE_SEPARATOR);
				mmmResult.append(ArresttConstants.LINE_SEPARATOR);
			}
		}
		
		List<ExperimentData> finalResults = new ArrayList<>();
		finalResults.add(new ExperimentData("FailuresByFile_DVC", fileResult.toString()));
		finalResults.add(new ExperimentData("Reduction_DVC", reductionResult.toString()));
		finalResults.add(new ExperimentData("FinalSize_DVC", sizeResult.toString()));
		finalResults.add(new ExperimentData("ResultTS_DVC", testSuiteResult.toString()));
		finalResults.add(new ExperimentData("Time_DVC", timeResult.toString()));
		finalResults.add(new ExperimentData("MediaMaxMin_DVC", mmmResult.toString()));
		
		return finalResults;	
	}
	
	private void buildRowHeader(String[] techniquesTitle, List<StringBuffer> allData) {
		for (StringBuffer stringData: allData) { 
			for (int i = 0; i < techniquesTitle.length; i++) {
				stringData.append(techniquesTitle[i] + "/t");
			}
		}
	}
}
