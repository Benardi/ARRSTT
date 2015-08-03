package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExperimentFile {
	public static final String defaultFormat = ".txt";
	
	private BufferedWriter writer;
	private StringBuffer content;
	private String fileFormat;
	private String fileName;
	
	public ExperimentFile(String fileName, String fileFormat) {
		this.content = new StringBuffer();
		this.fileFormat = fileFormat;
		this.fileName = fileName;
	}
	
	public ExperimentFile(String fileName) {
		this(fileName, defaultFormat);
	}
	
	public void save() throws IOException {
		writer = new BufferedWriter(new FileWriter(new File(fileName + fileFormat)));
		writer.write(content.toString());
		writer.close();
	}
	
	public String getFileName() {
		return fileName;
	}	
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public StringBuffer getContent() {
		return content;
	}
	
	public void setContent(StringBuffer content) {
		this.content = content;
	}
	
	public void appendContent(StringBuffer toAppendContent) {
		this.content.append(toAppendContent);
	}
	
	public void appendContent(String toAppendContent) {
		this.content.append(toAppendContent);
	}
}
