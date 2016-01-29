package br.edu.ufcg.splab.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class RunApplication extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ArrsttApplication app = new ArrsttApplication();
		app.initialize();
	}
}
