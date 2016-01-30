package br.edu.ufcg.splab.gui.view;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import br.edu.ufcg.splab.gui.ArrsttApplication;
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
	
	private ArrsttApplication app;
	
	@FXML
	private void initialize() {
		this.fileSourceTableColumn.setCellValueFactory(new PropertyValueFactory<FileSource, String>("source"));
		
		this.openFileButton.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				Stage mainStage = app.getGraphicStudio().getMainStage();
				File choosenFile = app.getGraphicStudio().showFileChooser(mainStage);
				
				if (choosenFile != null) {
					File choosenFileParent = choosenFile.getParentFile();
				
					filePathTextField.setText(choosenFile.getPath());
					app.getGraphicStudio().getFileChooser().setInitialDirectory(choosenFileParent);
				}
			}
		});
		
		this.parseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileSource selectedItem = fileSourceTableView.getSelectionModel().getSelectedItem();
				String filePath = filePathTextField.getText();
				
				if (selectedItem == null) {
					app.getGraphicStudio().createAndShowDialog("Select a source before trying to parse!", "No Source Selected");	
				} else if (filePath == null || filePath.equals("")) {
					app.getGraphicStudio().createAndShowDialog("Select a file before trying to parse!", "No File Selected");
				} else {
					app.getParsingFacade().changeParser(selectedItem.getSource());
					generatedTestSuiteTextArea.setText(app.getParsingFacade().parse(filePath));
				}
			}
		});
		
		this.outputButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().open(new File("C:\\"));
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	public void setApp(ArrsttApplication app) {
		this.app = app;
		this.fileSourceTableView.setItems(app.getDataHandler().getFileSources());
	}
}
