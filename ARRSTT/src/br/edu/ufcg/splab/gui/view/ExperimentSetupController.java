package br.edu.ufcg.splab.gui.view;

import br.edu.ufcg.splab.gui.ModulesController;
import javafx.fxml.FXML;

public class ExperimentSetupController {
	
	private ModulesController appController;
	
	
	@FXML
	public void initialize() {
		
	}
	
	public void setController(ModulesController appController) {
		this.appController = appController;
	}
}
