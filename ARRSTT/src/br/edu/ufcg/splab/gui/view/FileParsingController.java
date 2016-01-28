package br.edu.ufcg.splab.gui.view;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.gui.model.FileSource;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
	
	private GuiApplication app;
	
	@FXML
	private void initialize() {
		this.fileSourceTableColumn.setCellValueFactory(new PropertyValueFactory<FileSource, String>("source"));
		this.openFileButton.setOnAction(event -> filePathTextField.setText(app.showOpenFileChooseDialog().getPath()));
		this.parseButton.setOnAction(event -> { this.app.getParsingFacade().changeParser(fileSourceTableView.getSelectionModel().getSelectedItem().getSource().toLowerCase());
												this.generatedTestSuiteTextArea.setText(app.getParsingFacade().parse(this.filePathTextField.getText()));});
	}
	
	public void setApp(GuiApplication app) {
		this.app = app;
		fillTable();
	}
	
	private void fillTable() {
		this.fileSourceTableView.setItems(app.getFileSources());
	}
}
