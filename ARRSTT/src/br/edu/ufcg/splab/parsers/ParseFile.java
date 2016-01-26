package br.edu.ufcg.splab.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ParseFile {
	private File parseFile;
	private BufferedReader fileReader;
	
	public ParseFile(String path) {
		this.parseFile = new File(path);
	}
	
	public boolean streamOn() {
		try {
			this.fileReader = new BufferedReader(new FileReader(this.parseFile));
		} catch(IOException ioException) {
			ioException.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean streamOff() {
		try {
			this.fileReader.close();
		} catch(IOException ioException) {
			ioException.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public String readLine() {
		String contentOfLine = null;
		
		try {
			contentOfLine = fileReader.readLine();
		} catch(IOException ioException) {
			ioException.printStackTrace(); 
		}
		
		return contentOfLine;
	}
	
	public boolean isReadyToRead() {
		boolean isReady = false;
		
		try {
			isReady = fileReader.ready();	
		} catch(IOException ioException) {
			ioException.printStackTrace();
		}
		
		return isReady;
	}
	
	
}
