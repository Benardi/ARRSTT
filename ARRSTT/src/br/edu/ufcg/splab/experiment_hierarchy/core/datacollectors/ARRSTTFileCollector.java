package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ARRSTTFileCollector implements DependentVariableCollector{
	
	private File f;
	public ARRSTTFileCollector(File f){
		this.f = f;
	}
	
	@Override
	public StringBuffer collect(TestSuite t) {
		List<String> ids = getIDs();
		int defectiveTCamount = 0;
		for(String id : ids){
			for(TestCase tc : t.getTestSuite()){
				if(tc.getID().equals(id)){
					defectiveTCamount++;
				}
			}
		}
		
		// retorna isso mesmo ou eh porcentagem?
		return new StringBuffer(defectiveTCamount + ""); 
	}
	
	/*
	 * Eu nao sei como que faz pra pegar o arquivo e ver o conteudo dele.
	 * Alguem depois ve no ReadTGF como foi feito e faz isso pra esse metodo.
	 * Lembrando que esse metodo pega os TC IDs que tem dentro do file.
	 */
	private List<String> getIDs(){
		List<String> ids = new ArrayList<>();
		//TODO EVERYTHING
		
		return ids;
	}

}
