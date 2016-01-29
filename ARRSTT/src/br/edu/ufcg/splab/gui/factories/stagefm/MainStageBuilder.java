package br.edu.ufcg.splab.gui.factories.stagefm;

import br.edu.ufcg.splab.gui.exceptions.screen.SceneLoadingException;
import br.edu.ufcg.splab.gui.factories.scenefm.ParseSceneBuilder;
import br.edu.ufcg.splab.gui.graphic.GraphicStudio;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainStageBuilder implements StageBuilder {
	private Scene scene;
	
	public MainStageBuilder(Scene scene) {
		this.scene = scene;
	}
	
	public MainStageBuilder() {
		this(null);
	}
	
	@Override
	public Stage createStage() {
		Stage stage = new Stage();
		stage.setTitle("File Parser");
		stage.setScene(scene);
		return stage;
//		try {
//			this.primaryStage.setTitle("Tool - File Parser");
//			this.primaryStage.setScene(new ParseSceneBuilder(this).createScene());
//			this.viewStage = primaryStage;
//			this.viewStage.show();
//		} catch(SceneLoadingException e) {
//			// $$$ERROR$$$
//			Alert errorDialog = new Alert(AlertType.ERROR);
//			errorDialog.setContentText("Error while trying to load screen.");
//			errorDialog.setTitle("Load Screen Error");
//			errorDialog.showAndWait();
//		}
	}

}
