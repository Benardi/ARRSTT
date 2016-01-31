package br.edu.ufcg.splab.gui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExperimentOperation {
	private StringProperty operation;
	
	public ExperimentOperation(String operation) {
		this.operation = new SimpleStringProperty(operation);
	}
	
	public StringProperty getOperationProperty() {
		return this.operation;
	}
	
	public String getOperation() {
		return this.operation.getValue();
	}
	
	public void setOperation(String newOperation) {
		this.operation.setValue(newOperation);
	}
}
