package br.edu.ufcg.splab.gui.factories.scenefm;

import javafx.scene.Scene;

@FunctionalInterface
public interface SceneBuilder {
	public Scene createScene();
}
