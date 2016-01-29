package br.edu.ufcg.splab.gui.factories.dialogfm;

import javafx.scene.control.Dialog;

@FunctionalInterface
public interface DialogBuilder {
	public Dialog<?> buildDialog();
}
