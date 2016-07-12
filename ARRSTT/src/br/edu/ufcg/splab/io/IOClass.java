package br.edu.ufcg.splab.io;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.exceptions.ParseException;
import br.edu.ufcg.splab.framework.techniques.generation.DFSTechnique;
import br.edu.ufcg.splab.framework.techniques.generation.InterfaceGenerationTechnique;
import br.edu.ufcg.splab.graph.core.graph.Graph;
import br.edu.ufcg.splab.graph.parser.ReadTGF;
import br.edu.ufcg.splab.util.ArresttConstants;
import br.edu.ufcg.splab.util.ExperimentDataGroup;
import br.edu.ufcg.splab.util.ExperimentFile;
import br.edu.ufcg.splab.util.TestSuiteMerger;
import br.edu.ufcg.splab.util.XMLParser;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

/**
 * This class holds the input and output operations necessary to convert 
 * files into TestSuite objects and save the output of an experiment to files.
 *
 */
public class IOClass {
	/**
	 * Object used when handling with .xml files as input.
	 */
	private XMLParser xmlParser;
	/**
	 * Object used when handling with .tgf files as input.
	 */
	private ReadTGF tgfParser;
	
	public IOClass() {
		this.xmlParser = new XMLParser();
		this.tgfParser = new ReadTGF();
	}
	
	/**
	 * Used to obtain an array of files from an array of paths.
	 *
	 * @param paths The paths of the files.
	 * @return A array of files.
	 */
	public File[] getFiles(String[] paths){
		File[] files = new File[paths.length];
		for(int i = 0; i < paths.length; i++){
			files[i] = new File(paths[i]);
		}
		return files;
	}
	
	/**
	 * Given .xml or .tgf file paths this method will parse their content
	 * to TestSuite objects and return them as a List. 
	 * 
	 * @param paths The paths of the files to be parsed.
	 * @return A list with the test suites that the files describe. 
	 * @throws ParseException If the parsing does not work.
	 * @throws IOException If the file cannot be read.
	 * @throws Exception If the format is not a .tgf or a .xml.
	 */
	public List<TestSuite> getTestSuites(String[] paths) throws ParseException, IOException, Exception {
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		
		for (String path : paths) {
			File file = new File(path);
			testSuites.addAll(parseFile(file));
		}
		
		return testSuites;
	}
	
	/**
	 * Given .xml or .tgf files this method will parse their content
	 * to TestSuite objects and return them as a List. 
	 * 
	 * @param paths The files to be parsed.
	 * @return A list with the test suites that the files describe. 
	 * @throws ParseException If the parsing does not work.
	 * @throws IOException If the file cannot be read.
	 * @throws Exception If the format is not a .tgf or a .xml.
	 */
	public List<TestSuite> getTestSuites(File[] files) throws ParseException, IOException, Exception {
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		TestSuiteMerger merger = new TestSuiteMerger();
		for (File file : files) {			
			List<TestSuite> fileTestSuites = parseFile(file);
			TestSuite singleTestSuite = merger.merge(fileTestSuites);
			testSuites.add(singleTestSuite);
		}
		
		return testSuites;
	}
	
	/**
	 * This method can be used to save the results of an experiment to files. 
	 * 
	 * The folder in which the files are going to be saved is given by:
	 * 'outputFolderPath/yyyy-MM-dd -- HH_mm_ss'.
	 * 
	 * @param datas A List of ExperimentDataGroup to be saved.
	 * @param outputFolderPath The folder in which they will be saved.
	 */
	public void saveData(List<ExperimentDataGroup> datas, String outputFolderPath) {
		File outputFolder = new File(outputFolderPath);
		if (!outputFolder.isDirectory()) throw new ARRSTTException("The given path is not a valid directory.");
		
		String dirName = createDirectory(outputFolder);
		
		
		for(ExperimentDataGroup data: datas){
			try {
				ExperimentFile file = new ExperimentFile(dirName + "/" + data.getFileName(), data.getContent());
				file.save();
			} catch (IOException e) {
				throw new ARRSTTException(e.getMessage());
			}
		}
		
	}
	
	private String createDirectory(File outputFolder){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd -- HH_mm_ss");
		LocalDateTime date = LocalDateTime.now();
		
		String dirName = outputFolder + "/" + date.format(dateFormatter);
		
		if(!(new File (dirName)).mkdirs()) {
			throw new ARRSTTException("It was not able to create a data directory.");
		}
		
		return dirName;
	}
	
	private List<TestSuite> parseFile(File file) throws ParseException, IOException, Exception {
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		String extension = getFileExtension(file);
		
		switch(extension) {
			case ArresttConstants.TGF:
				testSuites.add(getTGFSuite(file));
				break;
			case ArresttConstants.XML:
				testSuites.addAll(getXMLSuite(file));
				break;
			default:
				throw new ARRSTTException("File extension not supported " + extension + ".");
		}
		
		return testSuites;
	}
	
	private List<TestSuite> getXMLSuite(File file) throws ParseException, IOException {
		return xmlParser.read(file.getPath());
	}

	private TestSuite getTGFSuite(File file) throws Exception {
		Graph graph = tgfParser.getGraph(file.getAbsolutePath());
		InterfaceGenerationTechnique search = new DFSTechnique();
		return search.getTestSuite(graph.getRoot(), 0);
	}
	
	private String getFileExtension(File file) {
		String fileName = file.getName();
		int lastIndex = fileName.lastIndexOf(ArresttConstants.EXTENSION_SEPARATOR);
		return fileName.substring(lastIndex, fileName.length());
	}

}
