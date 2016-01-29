package br.edu.ufcg.splab.gui.exceptions.screen;

public class ScreenLoadingException extends RuntimeException {
	
	public ScreenLoadingException(String msg) {
		super(msg);
	}
	
	public ScreenLoadingException() {
		this(null);
	}
	
}
