package br.edu.ufcg.splab.gui.graphic;

import java.io.File;

import br.edu.ufcg.splab.gui.factories.filechooserfm.ParseFileChooserBuilder;
import br.edu.ufcg.splab.gui.factories.stagefm.MainStageBuilder;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GraphicStudio {
	private Stage mainStage;
	private FileChooser fileChooser;
	
	public GraphicStudio() {
		this.fileChooser = new ParseFileChooserBuilder().createFileChooser();
		this.mainStage = new MainStageBuilder().createStage();
	}
	
	// Manipulate mainStage
	public void showMainStage() {
		this.mainStage.show();
	}
	
	public void mainStageScene(Scene scene) {
		this.mainStage.setScene(scene);
	}
	
	public Stage getMainStage() {
		return this.mainStage;
	}
	
	// Manipulate file chooser
	public File showFileChooser(Stage parentStage) {
		return this.fileChooser.showOpenDialog(parentStage);
	}
	
	public FileChooser getFileChooser() {
		return this.fileChooser;
	}
}
