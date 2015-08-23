package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class TreatmentSelection implements ExecutableTreatment {
    private InterfaceTestCaseSelector selectionObject;
    private TestSuite testSuite;
    private Double percentage;
    
    public TreatmentSelection(InterfaceTestCaseSelector selectionObject, TestSuite testSuite, Double percentage) {
        this.selectionObject = selectionObject;
        this.testSuite = testSuite;
        this.percentage = percentage;
    }

	@Override
	public TestSuite execute() {
		return selectionObject.select(testSuite, percentage);
	}

	@Override
	public String getTitle() {
		return "Selection";
	}
    
    public InterfaceTestCaseSelector getSelector() {
    	return selectionObject;
    }
}