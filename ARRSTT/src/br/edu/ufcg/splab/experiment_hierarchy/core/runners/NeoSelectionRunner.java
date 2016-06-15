package br.edu.ufcg.splab.experiment_hierarchy.core.runners;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TreatmentArtifact;

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
	public void runExperiment(List<TreatmentArtifact> artifacts) {
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
			
			fileResult.append(split[0]);
			reductionResult.append(split[1]);
			
			if((i+1) % lineSize == 0){
				fileResult.append(LINE_END);
				reductionResult.append(LINE_END);
			}
		}
		
		//temos os resultados de 2 dvcs aqui, o fileResult e o reductionResult. Ainda nao sei o que vamos fazer com ele.
		
	}

}
