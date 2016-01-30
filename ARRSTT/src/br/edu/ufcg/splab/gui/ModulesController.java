package br.edu.ufcg.splab.gui;

import java.awt.BorderLayout;
import java.io.File;
import java.util.Iterator;

import br.edu.ufcg.splab.gui.datahandler.DataHandler;
import br.edu.ufcg.splab.gui.factories.commonfactories.SceneFactory;
import br.edu.ufcg.splab.gui.factories.panefm.MenuPane;
import br.edu.ufcg.splab.gui.factories.panefm.PaneBuilder;
import br.edu.ufcg.splab.gui.factories.panefm.ParsePane;
import br.edu.ufcg.splab.gui.factories.panefm.RootPane;
import br.edu.ufcg.splab.gui.factories.panefm.StatusPane;
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
	private SceneFactory sceneFactory;
	
	public ModulesController() {
		this.dHandler = new DataHandler();
		this.parsingFacade = new ParsingFacade();
		this.gStudio = new GraphicStudio();
		this.sceneFactory = new SceneFactory();
	}
	
	public void initialize() {
		PaneBuilder[] builders = {new ParsePane(this), new MenuPane(), new StatusPane()};
		String[] positions = {BorderLayout.CENTER, BorderLayout.NORTH, BorderLayout.SOUTH};
		
		this.gStudio.mainStageScene(sceneFactory.createScene(new RootPane(builders, positions).createPane(), 800, 650));
		this.showMainStage();
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