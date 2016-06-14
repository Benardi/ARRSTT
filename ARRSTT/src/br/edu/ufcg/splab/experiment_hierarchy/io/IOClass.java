package br.edu.ufcg.splab.experiment_hierarchy.io;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.exceptions.ParseException;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentFile;
import br.edu.ufcg.splab.experiment_hierarchy.util.OldXMLParser;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.graph.Graph;
import br.edu.ufcg.splab.graph_hierarchy.parser.ReadTGF;

public class IOClass {
	private OldXMLParser xmlParser;
	private ReadTGF tgfParser;
	
	public IOClass() {
		this.xmlParser = new OldXMLParser();
		this.tgfParser = new ReadTGF();
	}
	
	public List<TestSuite> getTestSuites(String[] paths) throws ParseException, IOException, Exception {
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		
		for (String path : paths) {
			File file = new File(path);
			testSuites.addAll(parseFile(file));
		}
		
		return testSuites;
	}
	
	public List<TestSuite> getTestSuites(File[] files) throws ParseException, IOException, Exception {
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		
		for (File file : files) { 
			testSuites.addAll(parseFile(file));
		}
		
		return testSuites;
	}
	
	public void saveData(String[] benchmarkData, String[] dvcData, String[] dvcs, String outputFolderPath) {
		File outputFolder = new File(outputFolderPath);
		if (!outputFolder.isDirectory()) throw new ARRSTTException("The given path is not a valid directory.");
		
		String dirName = createDirectory(outputFolder);
		
		for (int i = 0; i < dvcData.length; i++) {
			try {
				ExperimentFile file = new ExperimentFile(dirName + "/" + dvcs[i].toString());
				file.appendContent(dvcData[i]);
				file.save();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < benchmarkData.length; i++) {
			try {
				ExperimentFile file = new ExperimentFile(dirName + "/" + "Time");
				file.appendContent(benchmarkData[i]);
				file.save();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String createDirectory(File outputFolder){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd -- HH_mm_ss");
		LocalDateTime date = LocalDateTime.now();
		
		String dirName = outputFolder + date.format(dateFormatter);
		
		if(!(new File (dirName)).mkdirs()) {
			throw new ARRSTTException("It was not able to create a data directory.");
		}
		
		return dirName;
	}
	
	private List<TestSuite> parseFile(File file) throws ParseException, IOException, Exception {
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		String extension = getFileExtension(file);
		
		switch(extension) {
			case IOConstants.TGF:
				testSuites.add(getTGFSuite(file));
				break;
			case IOConstants.XML:
				testSuites.addAll(getXMLSuite(file));
				break;
			default:
				throw new ARRSTTException("File extension not supported " + extension + ".");
		}
		
		return testSuites;
	}
	
	private List<TestSuite> getXMLSuite(File file) throws ParseException, IOException {
		return xmlParser.read(file.getPath()); // getPath or getAbsolutePath?
	}

	private TestSuite getTGFSuite(File file) throws Exception {
		Graph graph = tgfParser.getGraph(file.getAbsolutePath()); // getPath or getAbsolutePath?
		InterfaceSearch search = new DepthFirstSearch();
		return search.getTestSuite(graph.getRoot(), 0);
	}
	
	private String getFileExtension(File file) {
		String fileName = file.getName();
		int lastIndex = fileName.lastIndexOf(IOConstants.EXTENSION_SEPARATOR);
		return fileName.substring(lastIndex, fileName.length());
	}

}
