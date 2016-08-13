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
	public Experiment setup(List<TestSuite> testSuites, File[] files, int replications) {
		
		List<InterfaceSelectionTechnique> selectionTechniques = new ArrayList<>();
		selectionTechniques.add(new RandomTechnique());
		selectionTechniques.add(new SimilarityTechnique());
		
		String headerRow = "RANDOM\tSIMILARITY";
		
		double selectionPercentage = 0.5;		
		ISetup setup = new MySelectionSetup(testSuites, selectionTechniques, selectionPercentage, files, replications);
		IRunner runner = new MyExperimentRunner(new DefaultFormater());
		
		return new Experiment(setup, runner);
	}
	
	public void run() {
		
	}
}
