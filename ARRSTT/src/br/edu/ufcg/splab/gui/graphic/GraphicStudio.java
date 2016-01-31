package br.edu.ufcg.splab.gui.graphic;

import java.awt.BorderLayout;
import java.io.File;

import br.edu.ufcg.splab.gui.ModulesController;
import br.edu.ufcg.splab.gui.factories.commonfactories.SceneFactory;
import br.edu.ufcg.splab.gui.factories.dialogfm.DialogBuilder;
import br.edu.ufcg.splab.gui.factories.dialogfm.ErrorDialogBuilder;
import br.edu.ufcg.splab.gui.factories.filechooserfm.ParseFileChooserBuilder;
import br.edu.ufcg.splab.gui.factories.panefm.ExperimentPane;
import br.edu.ufcg.splab.gui.factories.panefm.MenuPane;
import br.edu.ufcg.splab.gui.factories.panefm.PaneBuilder;
import br.edu.ufcg.splab.gui.factories.panefm.ParsePane;
import br.edu.ufcg.splab.gui.factories.panefm.RootPane;
import br.edu.ufcg.splab.gui.factories.panefm.StatusPane;
import br.edu.ufcg.splab.gui.factories.stagefm.MainStageBuilder;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GraphicStudio {
	private Stage mainStage;
	private FileChooser fileChooser;
	private ModulesController controller;
	private SceneFactory sceneFactory;
	
	public GraphicStudio(ModulesController controller) {
		this.controller = controller;
		this.fileChooser = new ParseFileChooserBuilder().createFileChooser();
		this.mainStage = new MainStageBuilder().createStage();
		this.sceneFactory = new SceneFactory();
	}
	
	// Manipulate mainStage
	public void showMainStage() {
		this.mainStage.show();
	}
	
	public void mainStageScene(Scene scene) {
		this.mainStage.setScene(scene);
	}
	
	public void placeExperimentPane() {
		BorderPane pane = (BorderPane) this.mainStage.getScene().getRoot();
		pane.setCenter(new ExperimentPane(this.controller).createPane());
	}
	
	public Stage getMainStage() {
		return this.mainStage;
	}
	
	public void placeRootPane() {
		PaneBuilder[] builders = {new MenuPane(), new StatusPane()};
		String[] positions = {BorderLayout.NORTH, BorderLayout.SOUTH};
		this.mainStageScene(sceneFactory.createScene(new RootPane(builders, positions).createPane(), 800, 650));
	}
	
	public void placeParsePane() { 
		System.out.println(this.mainStage.getScene());
		BorderPane pane = (BorderPane) this.mainStage.getScene().getRoot();
		pane.setCenter(new ParsePane(this.controller).createPane());
	}
	
	// Manipulate file chooser
	public File showFileChooser(Stage parentStage) {
		return this.fileChooser.showOpenDialog(parentStage);
	}
	
	public FileChooser getFileChooser() {
		return this.fileChooser;
	}
	
	// Manipulate error dialogs
	public void createAndShowDialog(String content, String title) {
			DialogBuilder dialogBuilder = new ErrorDialogBuilder(content, title);
			Dialog<?> dialog = dialogBuilder.createDialog();
			dialog.showAndWait();
	}
		
}
