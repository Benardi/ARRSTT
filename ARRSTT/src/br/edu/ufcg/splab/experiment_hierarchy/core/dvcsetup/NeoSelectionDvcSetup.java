package br.edu.ufcg.splab.experiment_hierarchy.core.dvcsetup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTFileCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTReductionPercentageCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class NeoSelectionDvcSetup implements InterfaceDvcSetup{
	
	private int algorithmsAmount;
	private List<TestSuite> tSuites;
	
	public NeoSelectionDvcSetup(int algorithmsAmount, List<TestSuite> tSuites){
		this.algorithmsAmount = algorithmsAmount;
		this.tSuites = tSuites;
	}
	
	@Override
	public List<List<DependentVariableCollector>> getDVCs() {
		List<List<DependentVariableCollector>> matches = new ArrayList<>();
		File[] files = getFiles();

		for(int i = 0; i < algorithmsAmount; i++){
			for(int j = 0; j < tSuites.size(); j++){
				List<DependentVariableCollector> match = new ArrayList<>();
				match.add(new ARRSTTFileCollector(files[j]));
				match.add(new ARRSTTReductionPercentageCollector(new TestSuite(tSuites.get(j)))); // usando construtor de copia
				matches.add(match);
			}
		}
		return matches;
	}
	
	/*
	 *  essa eh a parte da GAMBIARRA.
	 *  A gente vai na mao mesmo carregar os arquivos que a gente quer.
	 *  Esse metodo provavelmente vai ficar feio pq temos que OBRIGATORIAMENTE
	 *  criar essa lista pra dar match nos testsuites do setup.
	 *  boa sorte pragente
	 */
	private File[] getFiles(){		
		//TODO VAI SER TENSO VEI
		return null;
	}

}
