package br.edu.ufcg.splab.experiment_hierarchy.util;

public class ExperimentData {
	private String content;
	private String fileName;
	
	public ExperimentData(String fileName, String content){
		this.content = content;
		this.fileName = fileName;
	}

	public String getContent() {
		return content;
	}

	public String getFileName() {
		return fileName;
	}
	
}
