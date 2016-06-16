package br.edu.ufcg.splab.experiment_hierarchy.core.runners;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentData;

public class NeoSelectionRunner implements InterfaceRunner{
	public static final String LINE_END = System.getProperty("line.separator");
	private int lineSize;
	
	public NeoSelectionRunner(int lineSize){
		this.lineSize = lineSize;
	}
	
	
	/*
	 * Como vai ficar o output disso com o modulo de IO?
	 * Vou deixar ja os stringbuffers prontos pra poupar trabalho
	 */
	@Override
	public List<ExperimentData> runExperiment(List<TreatmentArtifact> artifacts) {
		List<StringBuffer> results = new ArrayList<>();
		for(TreatmentArtifact art : artifacts){
			results.add(art.getDVCResults());
		}
		StringBuffer fileResult = new StringBuffer();
		StringBuffer reductionResult = new StringBuffer();
		
		//StringBuffer partialResult : results
		for(int i = 0; i < results.size(); i++){
			
			StringBuffer partialResult = results.get(i);
			String aux = partialResult.toString();
			String[] split = aux.split("/");
			
			fileResult.append(split[0] + " ");
			reductionResult.append(split[1] + " ");
			
			if((i+1) % lineSize == 0){
				fileResult.append(LINE_END);
				reductionResult.append(LINE_END);
			}
		}
		
		//List<String> finalResults = new ArrayList<>();
		//finalResults.add(fileResult.toString());
		//finalResults.add(reductionResult.toString());
		
		List<ExperimentData> finalResults = new ArrayList<>();
		finalResults.add(new ExperimentData("File_DVC", fileResult.toString()));
		finalResults.add(new ExperimentData("Reduction_DVC", reductionResult.toString()));		
		
		
		return finalResults;
		
		
	}

}
