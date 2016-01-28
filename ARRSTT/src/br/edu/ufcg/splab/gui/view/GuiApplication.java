package br.edu.ufcg.splab.gui.view;

import java.io.File;
import java.io.IOException;

import br.edu.ufcg.splab.gui.model.FileSource;
import br.edu.ufcg.splab.parsers.ParsingFacade;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class GuiApplication extends Application { 
	// Frame State Attributes
	private Stage viewStage;
	private Scene viewScene;
	
	// Stages
	private Stage primaryStage;
	
	// Dialogs
	private FileChooser fileChooser;
	
	// Model Data
	private ObservableList<FileSource> fileSources;
	
	// Components Imported From Business Logic
	private ParsingFacade parsingFacade;
	
	public GuiApplication() {
		this.fileSources = FXCollections.observableArrayList();
		this.fileSources.add(new FileSource("Evosuite"));
		this.parsingFacade = new ParsingFacade();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		showPrimaryStage();
	}
	
	public void showPrimaryStage() {
		try {
			this.primaryStage.setTitle("Tool - File Parser");
			buildPrimaryStage();
			this.viewStage = primaryStage;
			this.viewStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void buildPrimaryStage() throws IOException {
		this.primaryStage.setTitle("Tool - File Parser");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GuiApplication.class.getResource("FileParsingView.fxml"));
		
		Pane loadingPane = loader.load();
		FileParsingController controller = loader.getController();
		controller.setApp(this);
		
		Scene scene = new Scene(loadingPane, 800, 600);
		this.primaryStage.setScene(scene);
	}
	
	public void cleanStage() {
		this.viewStage = null;
	}
	
	public File showOpenFileChooseDialog() {
		this.fileChooser = new FileChooser();
		this.fileChooser.setTitle("Choose The File To Be Parsed");
		this.fileChooser.getExtensionFilters().add(new ExtensionFilter("Supported Code Files - .java", "*.java"));
		return this.fileChooser.showOpenDialog(this.viewStage);
	}
	
	// Getters and setters for view (should not be used).
	public Stage getViewStage() {
		return viewStage;
	}
	
	public void setViewStage(Stage newStage) {
		this.viewStage = newStage;
	}
	
	public Scene getViewScene() {
		return viewScene;
	}
	
	public void setScene(Scene newScene) {
		this.viewScene = newScene;
	}
	
	public ObservableList<FileSource> getFileSources() {
		return fileSources;
	}
	
	public ParsingFacade getParsingFacade() {
		return this.parsingFacade;
	}
	
	public void setParsingFacade(ParsingFacade parsingFacade) {
		this.parsingFacade = parsingFacade;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
