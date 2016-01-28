package br.edu.ufcg.splab.gui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FileSource {
	private StringProperty source;
	
	public FileSource(String source) {
		this.source = new SimpleStringProperty(source);
	}
	
	public StringProperty getStringProperty() {
		return this.source;
	}
	
	public String getSource() {
		return this.source.getValue();
	}
	
	public void setSource(String newSource) {
		this.source.setValue(newSource);
	}
}
