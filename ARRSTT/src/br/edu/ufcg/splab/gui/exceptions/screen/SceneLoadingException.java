package br.edu.ufcg.splab.gui.exceptions.screen;

public class SceneLoadingException extends ScreenLoadingException {
	
	public SceneLoadingException(String msg) {
		super(msg);
	}
	
	public SceneLoadingException() {
		this(null);
	}
	
}
