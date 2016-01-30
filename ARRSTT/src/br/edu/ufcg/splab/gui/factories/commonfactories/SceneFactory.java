package br.edu.ufcg.splab.gui.factories.commonfactories;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneFactory {
	public Scene createScene(Parent parent, double width, double height) {
		return new Scene(parent, width, height);
	}
}
