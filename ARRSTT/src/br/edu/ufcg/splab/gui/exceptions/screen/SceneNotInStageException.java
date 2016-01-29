package br.edu.ufcg.splab.gui.exceptions.screen;

public class SceneNotInStageException extends ScreenLoadingException {
	
	public SceneNotInStageException(String msg) {
		super(msg);
	}
	
	public SceneNotInStageException() {
		this(null);
	}
	
}
