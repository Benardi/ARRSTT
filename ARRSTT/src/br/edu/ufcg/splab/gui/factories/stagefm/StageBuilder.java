package br.edu.ufcg.splab.gui.factories.stagefm;

import javafx.stage.Stage;

@FunctionalInterface
public interface StageBuilder {
	public Stage createStage();
}
