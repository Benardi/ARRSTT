package br.edu.ufcg.splab.gui.view;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import br.edu.ufcg.splab.gui.ModulesController;
import br.edu.ufcg.splab.gui.model.FileSource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FileParsingController {
	@FXML
	private TableView<FileSource> fileSourceTableView;
	@FXML
	private TableColumn<FileSource, String> fileSourceTableColumn;
	@FXML
	private TextArea generatedTestSuiteTextArea;
	@FXML
	private TextField filePathTextField;
	@FXML
	private Button setupExperimentButton;
	@FXML
	private Button openFileButton;
	@FXML
	private Button parseButton;
	@FXML
	private Button outputButton;
	
	private ModulesController appController;
	
	@FXML
	private void initialize() {
		this.fileSourceTableColumn.setCellValueFactory(new PropertyValueFactory<FileSource, String>("source"));
		
		this.openFileButton.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				Stage mainStage = appController.getMainStage();
				File choosenFile = appController.showFileChooser(mainStage);
				
				if (choosenFile != null) {
					File choosenFileParent = choosenFile.getParentFile();
				
					filePathTextField.setText(choosenFile.getPath());
					appController.getFileChooser().setInitialDirectory(choosenFileParent);
				}
			}
		});
		
		this.parseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileSource selectedItem = fileSourceTableView.getSelectionModel().getSelectedItem();
				String filePath = filePathTextField.getText();
				
				if (selectedItem == null) {
					appController.createAndShowDialog("Select a source before trying to parse!", "No Source Selected");	
				} else if (filePath == null || filePath.equals("")) {
					appController.createAndShowDialog("Select a file before trying to parse!", "No File Selected");
				} else {
					appController.changeParser(selectedItem.getSource());
					generatedTestSuiteTextArea.setText(appController.parse(filePath));
				}
			}
		});
		
		this.outputButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().open(new File("C:\\"));
				} catch(IOException e) {
					appController.createAndShowDialog("Directory can not be open or do not exist.", "Directory Error");
				}
			}
			
		});
		
		this.setupExperimentButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				appController.setCenterToExperimental();
			}
			
		});
	}
	
	public void setController(ModulesController appController) {
		System.out.println(appController);
		this.appController = appController;
		this.fileSourceTableView.setItems(this.appController.getFileSources());
	}
}
