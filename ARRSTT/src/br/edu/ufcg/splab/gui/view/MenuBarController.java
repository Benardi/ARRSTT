package br.edu.ufcg.splab.gui.view;

import br.edu.ufcg.splab.gui.ModulesController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MenuBarController {
	@FXML
	private MenuItem resetMenuItem;
	@FXML
	private MenuItem exitMenuItem;
	
	@FXML
	private ModulesController appController;
	
	@FXML
	private void initialize() {
		exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
			
		});
		
		resetMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
			
		});
	}
}
