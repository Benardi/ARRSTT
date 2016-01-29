package br.edu.ufcg.splab.gui.factories.dialogfm;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;

public class ErrorDialogBuilder implements DialogBuilder {
	private String contextText;
	private String title;
	
	public ErrorDialogBuilder(String contextText, String title) {
		this.contextText = contextText;
		this.title = title;
	}
	
	@Override
	public Dialog<?> createDialog() {
		Alert errorDialog = new Alert(AlertType.ERROR);
		errorDialog.setContentText(contextText);
		errorDialog.setTitle(title);
		return errorDialog;
	}
	
}
