package br.edu.ufcg.splab.gui.datahandler;

import java.util.Iterator;

import br.edu.ufcg.splab.gui.model.FileSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataHandler {
	private ObservableList<FileSource> fileSources;
	
	public DataHandler() {
		this.fileSources = FXCollections.observableArrayList();
		this.fileSources.add(new FileSource("Evosuite"));
		this.fileSources.add(new FileSource("Whatever"));
		this.fileSources.add(new FileSource("However"));
	}
	
	public ObservableList<FileSource> getFileSources() {
		return this.fileSources;
	}
	
	public Iterator<FileSource> fileSourcesIterator() {
		return this.fileSources.iterator();
	}
}
