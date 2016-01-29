package br.edu.ufcg.splab.gui.graphic;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface StageState {
	public void showStage();
	public void hideStage();
	public void initializeStage();
	public void changeScene(Scene scene);
	public Stage getStage();
}
