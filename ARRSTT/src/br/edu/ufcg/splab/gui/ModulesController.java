package br.edu.ufcg.splab.gui;

import java.io.File;
import java.util.Iterator;

import br.edu.ufcg.splab.gui.datahandler.DataHandler;
import br.edu.ufcg.splab.gui.graphic.GraphicStudio;
import br.edu.ufcg.splab.gui.model.FileSource;
import br.edu.ufcg.splab.parsers.frontend.ParsingFacade;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ModulesController {
	// Modules
	private GraphicStudio gStudio;
	private ParsingFacade parsingFacade;
	private DataHandler dHandler;
	
	public ModulesController() {
		this.dHandler = new DataHandler();
		this.parsingFacade = new ParsingFacade();
		this.gStudio = new GraphicStudio(this);
	}
	
	public void initialize() {
		this.gStudio.placeRootPane();
		this.gStudio.placeParsePane();
		this.gStudio.showMainStage();
	}
	
	public ObservableList<FileSource> getFileSources() {
		return this.dHandler.getFileSources();
	}
	
	public Iterator<FileSource> fileSourcesIterator() {
		return this.dHandler.fileSourcesIterator();
	}
	
	// Manipulate mainStage
	public void showMainStage() {
		this.gStudio.showMainStage();
	}
		
	public void mainStageScene(Scene scene) {
		this.gStudio.mainStageScene(scene);
	}
	
	public void setCenterToExperimental() {
		this.gStudio.placeExperimentPane();
	}
	
	public Stage getMainStage() {
		return this.gStudio.getMainStage();
	}
		
	// Manipulate file chooser
	public File showFileChooser(Stage parentStage) {
		return this.gStudio.showFileChooser(parentStage);
	}
		
	public FileChooser getFileChooser() {
		return this.gStudio.getFileChooser();
	}
		
	// Manipulate error dialogs
	public void createAndShowDialog(String content, String title) {
		this.gStudio.createAndShowDialog(content, title);
	}
	
	public void changeParser(String parserStr) {
		this.parsingFacade.changeParser(parserStr);
	}
	
	public String parse(String filePath) {
		return this.parsingFacade.parse(filePath);
	}
}