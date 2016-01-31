package br.edu.ufcg.splab.gui.view;

import br.edu.ufcg.splab.gui.ModulesController;
import br.edu.ufcg.splab.gui.model.ExperimentOperation;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ExperimentSetupController {
	@FXML
	private TableView<ExperimentOperation> operationTableView;
	@FXML
	private AnchorPane setupAnchoPane;
	
	private ModulesController appController;
	
	
	@FXML
	public void initialize() {
		
	}
	
	public void setController(ModulesController appController) {
		this.appController = appController;
	}
}
