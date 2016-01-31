package br.edu.ufcg.splab.gui.factories.panefm;

import java.io.IOException;
import java.net.URL;

import br.edu.ufcg.splab.gui.ModulesController;
import br.edu.ufcg.splab.gui.exceptions.screen.SceneLoadingException;
import br.edu.ufcg.splab.gui.view.ExperimentSetupController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class ExperimentPane implements PaneBuilder {
	public static final URL LOCATION = ExperimentSetupController.class.getResource("ExperimentSetupView.fxml");
	
	private ModulesController controller;
	
	public ExperimentPane(ModulesController controller) {
		this.controller = controller;
	}
	
	@Override
	public Pane createPane() {
		Pane pane = null;
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LOCATION);
			
			pane = loader.load();
			ExperimentSetupController controller = loader.getController();
			controller.setController(this.controller);
		} catch(IOException e) {
			e.printStackTrace();
			throw new SceneLoadingException("Exception while trying to "
											+ "create scene");
		}
		
		if (pane == null) throw new SceneLoadingException("Exception while trying to "
															+ "load a pane to the scene");

		return pane;
	}
}
