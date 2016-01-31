package br.edu.ufcg.splab.gui.factories.panefm;

import java.io.IOException;
import java.net.URL;

import br.edu.ufcg.splab.gui.ModulesController;
import br.edu.ufcg.splab.gui.exceptions.screen.SceneLoadingException;
import br.edu.ufcg.splab.gui.view.FileParsingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class ParsePane implements PaneBuilder {
	public static final URL LOCATION = FileParsingController.class.getResource("FileParsingView.fxml");
	
	private ModulesController application;
	
	public ParsePane(ModulesController application) {
		this.application = application;
	}
	
	@Override
	public Pane createPane() {
		Pane pane = null;
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LOCATION);
		
			pane = loader.load();
			FileParsingController controller = loader.getController();
			controller.setController(this.application);
		} catch(IOException e) {
			throw new SceneLoadingException("Exception while trying to "
											+ "create scene");
		}
		
		if (pane == null) throw new SceneLoadingException("Exception while trying to "
															+ "load a pane to the scene");

		return pane;
	}

}
