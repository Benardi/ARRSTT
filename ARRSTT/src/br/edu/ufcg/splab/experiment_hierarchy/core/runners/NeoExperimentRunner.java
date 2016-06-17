package br.edu.ufcg.splab.experiment_hierarchy.core.runners;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.util.ArresttConstants;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentData;

public class NeoExperimentRunner implements InterfaceRunner{
	private int lineSize;
	
	public NeoExperimentRunner(int lineSize){
		this.lineSize = lineSize;
	}
	
	@Override
	public List<ExperimentData> runExperiment(List<TreatmentArtifact> artifacts) {
		List<StringBuffer> results = new ArrayList<>();
		
		for(TreatmentArtifact art : artifacts){
			results.add(art.getDVCResults());
		}
		
		StringBuffer fileResult = new StringBuffer();
		StringBuffer reductionResult = new StringBuffer();
		
		for(int i = 0; i < results.size(); i++){
			
			StringBuffer partialResult = results.get(i);
			String aux = partialResult.toString();
			String[] split = aux.split("/");
			
			fileResult.append(split[0] + " ");
			reductionResult.append(split[1] + " ");
			
			if((i+1) % lineSize == 0){
				fileResult.append(ArresttConstants.LINE_SEPARATOR);
				reductionResult.append(ArresttConstants.LINE_SEPARATOR);
			}
		}
		
		List<ExperimentData> finalResults = new ArrayList<>();
		finalResults.add(new ExperimentData("File_DVC", fileResult.toString()));
		finalResults.add(new ExperimentData("Reduction_DVC", reductionResult.toString()));		
		
		return finalResults;	
	}

}
