package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.GenerationTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.SelectionTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;

public class TreatmentFactory {
	public ExecutableTreatment createSelection(SelectionType type, TestSuite testSuite, double percentage) {
		//cria o selection type
		// chamar o selection para retornar a instancia de selection. 
		InterfaceTestCaseSelector selector = new SelectionFactory().createTreatment(type);
		return new SelectionTreatment(selector, testSuite, percentage);
	}
	
	public ExecutableTreatment createGeneration(GenerationType type, InterfaceVertex root, int loopCoverage) {
		InterfaceSearch generator = new GenerationFactory().createTreatment(type);		
		return new GenerationTreatment(generator, root, loopCoverage);
	}
}
