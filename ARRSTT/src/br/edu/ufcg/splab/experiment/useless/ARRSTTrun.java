package br.edu.ufcg.splab.experiment.useless;

import java.util.List;

import br.edu.ufcg.splab.searchs.InterfaceSearch;

public class ARRSTTrun {
	private List<List<Long>> times;
	public ARRSTTrun(int replication) {
		
	}
	
	public void run(InterfaceSearch search,int measurement , int loopCoverage){
		//lista de tempo de execuçao
		
		// pega tempo aqui:
		search.getTestSuite(measurement, loopCoverage);
		// pega tempo aqui:
		
		//adiciona o tempo numa litsa
		
		//adiciona a lista na matriz times.
		
	}

}
