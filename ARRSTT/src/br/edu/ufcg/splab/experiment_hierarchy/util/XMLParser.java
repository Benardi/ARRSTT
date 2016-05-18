package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import br.edu.ufcg.splab.exceptions.ParseException;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.Transition;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.TransitionType;
import br.edu.ufcg.splab.graph_hierarchy.core.vertex.Vertex;

/*
 * import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.core.edges.Edge;
import br.edu.ufcg.splab.core.edges.EdgeType;
import br.edu.ufcg.splab.core.vertex.Vertex;
import br.edu.ufcg.splab.exceptions.ParseException;
import br.edu.ufcg.splab.generator.TestCase;
import br.edu.ufcg.splab.generator.TestSuite;
 */

public class XMLParser {
	/**
	 * Holds the counter for the vertexes labels.
	 */
    private int vertexCounter;
    
    /**
     * This attribute is used to assist the generation of test cases. 
     */
    private InterfaceVertex fromVertex;
    
    /**
     * This attribute is used to assist the generation of test cases. 
     */
    private InterfaceVertex toVertex;
    
    /**
     * The final list of test suites described in the XML file.
     */
    private List<TestSuite> result;
    
    
    /**
	 * Converts the XML file representation of a test suite into a TestSuite object.
	 * @param filePath The path of the XML file in the file system.
	 * @return An Equivalent List of TestSuite objects. 
	 * @throws ParseException Thrown if the provided .xml file does not conform with the schema. 
	 * @throws IOException Thrown if the provided .xml file does not exist or whether some permission problem arise.
	 */
	public List<TestSuite> read(String filePath) throws ParseException, IOException {
		result = new ArrayList<>();
		vertexCounter = 0;
		
		Document parsedXML = this.parseXML(filePath);
		String initialPath = parsedXML.getRootElement().getChildText("name");
		
		/* The algorithm assumes that there are no "testsuites" tags inside a "testsuites" tag.
		 and also that all "testsuites" have the root element as parent.*/
		for(Element testSuitesTag : parsedXML.getRootElement().getChildren("testsuites")) { 
			recursiveRead(initialPath, testSuitesTag);
		}
		
		return result;
	}
	
	/**
	 * Converts the XML file to a Document.
	 * @param filePath The path of the XML file to be parsed.
	 * @return The object representation of the valid XML file to be converted into a TestSuite instance.
	 * @throws ParseException Thrown if the provided .xml file does not conform with the schema. 
	 * @throws IOException Thrown if the provided .xml file does not exist or whether some permission problem arise.
	 */
	private Document parseXML(String filePath) throws ParseException, IOException{
		try {
			SAXBuilder builder = new SAXBuilder();
			return builder.build(new File(filePath));
		} catch (JDOMException e) {
			throw new ParseException(e.getLocalizedMessage());
		} catch (IOException e) {
			throw new IOException(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Recursively iterates through the XML file trying to find either "testcase" tags or "testsuite" tags. 
	 * The algorithm resembles the DF Search on a graph.
	 * @param id The partial id of the test suite that is being built by the algorithm.
	 * @param tag The tag that the algorithm will search for child tags.
	 */
	private void recursiveRead(String id, Element tag) {
		if (!tag.getChildren("testcase").isEmpty()) {
			TestSuite ts = new TestSuite(id.toString());

			for (Element testCaseTag : tag.getChildren("testcase")) {
				ts.add(createTestCase(testCaseTag));
			}
			result.add(ts);
		} else {
			for (Element testSuiteTag : tag.getChildren("testsuite")) {
				recursiveRead(id + "/" + testSuiteTag.getAttributeValue("name"), testSuiteTag);
			}
		}
	}
	
	/**
	 * Generate a test case. For the first test case, it will have the first vertex labeled "0", 
	 * the second labeled "1" and so on. It is assumed that every step has an action.
	 * @param testCaseTag A "testcase" tag.
	 * @return The created TestCase.
	 */
	private TestCase createTestCase(Element testCaseTag) {
		// Initialize test case.
		TestCase testCase = new TestCase(testCaseTag.getAttributeValue("internalid"), testCaseTag.getAttributeValue("name"));
		
		// Add the precondition to the test case.
		String preconditions = testCaseTag.getChildText("preconditions");
		testCase.addEdge(this.createPreconditionsEdge(this.correctTestLinkLabel(preconditions)));
		
		// Iteration through the steps.
	    for (Element testCaseSteps : testCaseTag.getChildren("steps")) {
	        for (Element testCaseStep : testCaseSteps.getChildren("step")) {
	        	
	        	// Add an action edge to the test case.
	            String actions = testCaseStep.getChildText("actions");
	            testCase.addEdge(this.createActionsEdge(this.correctTestLinkLabel(actions)));
	            
	            // Add an expected results to the test case.
	            if (testCaseStep.getChild("expectedresults") != null) {
	                String expectedResults = testCaseStep.getChildText("expectedresults");
	                testCase.addEdge(this.createResultsEdge(this.correctTestLinkLabel(expectedResults)));
	            }
	        }
	    }
	    
	    return testCase;
	}
	
	private InterfaceEdge createPreconditionsEdge(String preconditions) {
		this.fromVertex = getNewVertex();
		this.toVertex = getNewVertex();
		return new Transition(fromVertex, preconditions, toVertex, TransitionType.CONDITIONS);
	}
	
	private InterfaceEdge createActionsEdge(String actions) {
		this.fromVertex = toVertex;
		this.toVertex = getNewVertex();
		return new Transition(fromVertex, actions, toVertex, TransitionType.STEPS);
	}
	
	private InterfaceEdge createResultsEdge(String expectedResults) {
		this.fromVertex = toVertex;
		this.toVertex = getNewVertex();
		return new Transition(fromVertex, expectedResults, toVertex, TransitionType.EXPECTED_RESULTS);
	}
	
	/**
	 * @return	A new vertex with the correct label.
	 */
	private InterfaceVertex getNewVertex() {
		return new Vertex((vertexCounter++) + "");
	}
	
	/**
	 * Correct the label with html mime characters and inside of 'paragraph' html tag
	 * @param label The label to be corrected.
	 * @return The corrected label.
	 */
	private String correctTestLinkLabel(String label){
		String correctedLabel = StringEscapeUtils.unescapeHtml4(label);
		int beginIndex = correctedLabel.indexOf("<p>");
		int lastIndex = correctedLabel.indexOf("</p>");
		
		if(beginIndex >= 0){
			beginIndex = beginIndex + 3;
			correctedLabel = correctedLabel.substring(beginIndex);
		}
		
		if(lastIndex >= 0){
			lastIndex = lastIndex - 3;
			correctedLabel = correctedLabel.substring(0, lastIndex);
		}
		
		lastIndex = correctedLabel.indexOf("<p>");
		if(lastIndex >= 0){
			correctedLabel = correctedLabel.substring(0, lastIndex);
		}
		
		correctedLabel = correctedLabel.trim();
		return correctedLabel;
	}
}
