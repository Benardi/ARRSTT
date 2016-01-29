package br.edu.ufcg.splab.gui.factories.stagefm;

import javafx.scene.Scene;
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
	}

}
