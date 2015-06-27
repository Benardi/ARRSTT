package br.edu.ufcg.splab.experiment.core.treatments;

import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.searchs.InterfaceSearch;
import br.edu.ufcg.splab.util.TestSuite;


public class TreatmentSearch implements ExecutableTreatment {
	private InterfaceSearch searchObject;
	private InterfaceGraph graph;
	private TestSuite testSuite;
	private int loopCoverage;
	private String name;
	
	public TreatmentSearch(InterfaceSearch searchObject, InterfaceGraph graph, int loopCoverage, String name) {
		this.searchObject = searchObject;
		this.loopCoverage = loopCoverage;
		this.graph = graph;
		this.name = name;
		
		testSuite = new TestSuite();
	}
	
	public TreatmentSearch(InterfaceSearch searchObject, int loopCoverage, String name) {
		this(searchObject, null, loopCoverage, name);
	}
	
	public TreatmentSearch(String name) {
		this(null, null, 0, name);
	}
	
	public void execute() {
		testSuite = searchObject.getTestSuite(graph.getRoot(), loopCoverage);
	}
	
	/* Note: The name of the method in incoherent. */
	public boolean isEmpty() {
		return (testSuite.isEmpty()) ? (true) : (false);
	}

	public int getLoopCoverage() {
		return loopCoverage;
	}

	public void setLoopCoverage(int loopCoverage) {
		this.loopCoverage = loopCoverage;
	}

	public InterfaceGraph getGraph() {
		return graph;
	}

	public void setGraph(InterfaceGraph graph) {
		this.graph = graph;
	}

	public TestSuite getTestSuite() {
		return testSuite;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
