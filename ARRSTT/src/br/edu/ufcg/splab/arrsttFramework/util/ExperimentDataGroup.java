package br.edu.ufcg.splab.arrsttFramework.util;

public class ExperimentDataGroup {
	private String content;
	private String fileName;
	
	public ExperimentDataGroup(String fileName, String content){
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
