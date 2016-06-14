package br.edu.ufcg.splab.exceptions;

public class ARRSTTException extends RuntimeException {
	private static final long serialVersionUID = -1200320313916234880L;

	public ARRSTTException(String message) {
		super(message);
	}
	
	public ARRSTTException() {
		super("An error has ocurred in ARRSTT System.");
	}
}
