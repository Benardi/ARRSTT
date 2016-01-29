package br.edu.ufcg.splab.gui.exceptions.screen;

public class StageLoadingException extends ScreenLoadingException {
	
	public StageLoadingException(String msg) {
		super(msg);
	}
	
	public StageLoadingException() {
		this(null);
	}
	
}
