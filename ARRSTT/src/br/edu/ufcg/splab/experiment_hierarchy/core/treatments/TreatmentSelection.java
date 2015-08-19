package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class TreatmentSelection implements ExecutableTreatment {
    private InterfaceTestCaseSelector selectionObject;
    
    public TreatmentSelection(InterfaceTestCaseSelector selectionObject) {
        this.selectionObject = selectionObject;
    }

	@Override
	public TestSuite execute() {
		return selectionObject.select();
	}

	@Override
	public String getTitle() {
		return "Selection";
	}
    
    public InterfaceTestCaseSelector getSelector() {
    	return selectionObject;
    }
}