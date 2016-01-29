package br.edu.ufcg.splab.gui.graphic;

import br.edu.ufcg.splab.gui.exceptions.screen.StageLoadingException;
import br.edu.ufcg.splab.gui.factories.stagefm.MainStageBuilder;
import br.edu.ufcg.splab.gui.factories.stagefm.StageBuilder;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainStage implements StageState {
	private Stage stage;
	
	@Override
	public void showStage() {
		try {
			stage.show();
		} catch(RuntimeException e) {
			throw new StageLoadingException("Error while trying to show stage");
		}
	}

	@Override
	public void hideStage() {
		try {
			stage.hide();
		} catch(RuntimeException e) {
			throw new StageLoadingException("Error while trying to hide stage");
		}
	}

	@Override
	public void initializeStage() {
		StageBuilder builder = new MainStageBuilder();
		builder.createStage();
	}

	@Override
	public void changeScene(Scene scene) {
		try {
			this.stage.setScene(scene);
		} catch(RuntimeException e) {
			throw new StageLoadingException("Error while trying to switch scene");
		}
	}

	@Override
	public Stage getStage() {
		return stage;
	}

}
