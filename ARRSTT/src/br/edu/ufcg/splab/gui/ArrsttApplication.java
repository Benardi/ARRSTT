package br.edu.ufcg.splab.gui;

import br.edu.ufcg.splab.gui.datahandler.DataHandler;
import br.edu.ufcg.splab.gui.factories.scenefm.ParseSceneBuilder;
import br.edu.ufcg.splab.gui.graphic.GraphicStudio;
import br.edu.ufcg.splab.parsers.frontend.ParsingFacade;

public class ArrsttApplication {
	// Modules
	private GraphicStudio gStudio;
	private ParsingFacade parsingFacade;
	private DataHandler dHandler;
	
	public ArrsttApplication() {
		this.dHandler = new DataHandler();
		this.parsingFacade = new ParsingFacade();
		this.gStudio = new GraphicStudio();
	}
	
	public void initialize() {
		this.gStudio.mainStageScene(new ParseSceneBuilder(this).createScene()); // Create scene 1
		this.gStudio.showMainStage();
	}
	
	public GraphicStudio getGraphicStudio() {
		return this.gStudio;
	}
	
	public DataHandler getDataHandler() {
		return this.dHandler;
	}
	
	public ParsingFacade getParsingFacade() {
		return this.parsingFacade;
	}
}
