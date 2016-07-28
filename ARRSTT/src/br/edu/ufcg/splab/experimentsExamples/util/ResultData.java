package br.edu.ufcg.splab.experimentsExamples.util;

public class ResultData {
	
	private String name;
	private String content;
	private String dvcString;
	
	public ResultData(String name, String content, String dvcString){
		this.name = name;
		this.content = content;
		this.dvcString = dvcString;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}
	
	public String getDvcString(){
		return dvcString;
	}

	
	

}
