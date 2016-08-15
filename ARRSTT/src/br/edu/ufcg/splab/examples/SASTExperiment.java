package br.edu.ufcg.splab.examples;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.Experiment;
import br.edu.ufcg.splab.arrsttFramework.IRunner;
import br.edu.ufcg.splab.arrsttFramework.ISetup;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.core.formaters.DefaultFormater;
import br.edu.ufcg.splab.experimentsExamples.core.runners.MyExperimentRunner;
import br.edu.ufcg.splab.experimentsExamples.core.setups.MySelectionSetup;
import br.edu.ufcg.splab.experimentsExamples.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.selection.RandomTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.selection.SimilarityTechnique;

public class SASTExperiment {
	public Experiment createExperiment() {
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		File[] defectFiles = new File[1];
		int replications = 10;
		
		ISetup sastSetup = createSetup(testSuites, defectFiles, replications);
		IRunner sastRunner = createRunner();
		return new Experiment(sastSetup, sastRunner);
	}
	
	public ISetup createSetup(List<TestSuite> testSuites, File[] files, int replications) {
		List<InterfaceSelectionTechnique> selectionTechniques = new ArrayList<>();
		selectionTechniques.add(new RandomTechnique());
		selectionTechniques.add(new SimilarityTechnique());
		
		double selectionPercentage = 0.5;		
		return new MySelectionSetup(testSuites, selectionTechniques, selectionPercentage, files, replications);
	}
	
	public IRunner createRunner() {
		return new MyExperimentRunner(new DefaultFormater());
	}
}
