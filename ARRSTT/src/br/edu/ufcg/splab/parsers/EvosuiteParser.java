package br.edu.ufcg.splab.parsers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class EvosuiteParser {
	private List<StringBuffer> transitions;
	
	public EvosuiteParser() {
		this.transitions = new ArrayList<StringBuffer>();
	}
	
	public TestSuite parseFile(String filePath) {
		BufferedReader readStream = null;
		StringBuffer allCode = new StringBuffer();
		
		try {
			readStream = new BufferedReader(new FileReader(filePath));
			
			String currentLine;
			
			do {
				
				currentLine = readStream.readLine();
				allCode.append(currentLine);
				
			} while (currentLine != null);
			
			String allCodeInString = allCode.toString().trim();
			String[] allLines = allCodeInString.toString().split(";");
			
			
			for (String line : allLines) {
				System.out.println(line);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				readStream.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
			
		}
		
		return null;
	}
}
