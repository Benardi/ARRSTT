package br.edu.ufcg.splab.gui.factories.filechooserfm;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ParseFileChooserBuilder implements FileChooserBuilder {
	
	@Override
	public FileChooser createFileChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("File To Be Parsed");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Files | .java", "*.java"));
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		
		return fileChooser;
	}
}
