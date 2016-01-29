package br.edu.ufcg.splab.gui.factories.scenefm;

import java.io.IOException;
import java.net.URL;

import br.edu.ufcg.splab.gui.ArrsttApplication;
import br.edu.ufcg.splab.gui.exceptions.screen.SceneLoadingException;
import br.edu.ufcg.splab.gui.view.FileParsingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class ParseSceneBuilder implements SceneBuilder {
	public static final URL LOCATION = FileParsingController.class.getResource("FileParsingView.fxml");
	
	private ArrsttApplication application;
	
	public ParseSceneBuilder(ArrsttApplication application) {
		this.application = application;
	}

	@Override
	public Scene createScene() {
		Pane pane = null;
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LOCATION);
		
			pane = loader.load();
			FileParsingController controller = loader.getController();
			controller.setApp(this.application);
		} catch(IOException e) {
			throw new SceneLoadingException("Exception while trying to "
											+ "create scene");
		}
		
		if (pane == null) throw new SceneLoadingException("Exception while trying to "
															+ "load a pane to the scene");

		return new Scene(pane, 800, 600); 
	}

}
