package br.edu.ufcg.splab.gui.factories.panefm;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;

import br.edu.ufcg.splab.gui.exceptions.screen.SceneLoadingException;
import br.edu.ufcg.splab.gui.view.FileParsingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class RootPane implements PaneBuilder {
	public static final URL LOCATION = FileParsingController.class.getResource("RootView.fxml");

	private PaneBuilder[] paneBuilders;
	private String[] positions;
	
	public RootPane(PaneBuilder[] paneBuilders, String[] positions) {
		this.paneBuilders = paneBuilders;
		this.positions = positions;
	}
	
	@Override
	public Pane createPane() {
		BorderPane pane = null;
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LOCATION);

			pane = loader.load();
			
			for (int i = 0; i < paneBuilders.length; i++) {
				switch(positions[i]) {
					case BorderLayout.CENTER:
						pane.setCenter(paneBuilders[i].createPane());
						break;
					case BorderLayout.NORTH:
						pane.setTop(paneBuilders[i].createPane());
						break;
					case BorderLayout.SOUTH:
						pane.setBottom(paneBuilders[i].createPane());
						break;
					default:
						break;
				}
			}
		} catch(IOException e) {
			throw new SceneLoadingException("Exception while trying to "
											+ "create scene");
		}
		
		if (pane == null) throw new SceneLoadingException("Exception while trying to "
															+ "load a pane to the scene");
		return pane;
	}
	
	
}
