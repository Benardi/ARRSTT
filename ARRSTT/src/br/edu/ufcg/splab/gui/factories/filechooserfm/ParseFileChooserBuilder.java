package br.edu.ufcg.splab.gui.factories.filechooserfm;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ParseFileChooserBuilder implements FileChooserBuilder {
	
	@Override
	public FileChooser createFileChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("File To Be Parsed");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Files | .java", "*.java"));
		
		return fileChooser;
	}
}
