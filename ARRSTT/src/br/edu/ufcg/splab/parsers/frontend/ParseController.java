package br.edu.ufcg.splab.parsers.frontend;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ParseController {
	private Parser parser;
	private TestSuite lastGeneratedTestSuite;
	
	public ParseController(Parser parser) {
		this.parser = parser;
	}
	
	public ParseController() {
		this(null);
	}
	
	public Parser getParser() {
		return parser;
	}
	
	public void setParser(Parser parser) {
		this.parser = parser;
	}
	
	public TestSuite parse(String filePath) {
		this.lastGeneratedTestSuite = parser.parseFile(filePath);
		return this.lastGeneratedTestSuite;
	}
}
