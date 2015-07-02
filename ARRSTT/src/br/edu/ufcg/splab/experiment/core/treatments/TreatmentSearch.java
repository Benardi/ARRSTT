package br.edu.ufcg.splab.experiment.core.treatments;

import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.searchs.InterfaceSearch;
import br.edu.ufcg.splab.util.TestSuite;

public class TreatmentSearch implements ExecutableTreatment {
	private InterfaceSearch searchObject;
	private InterfaceVertex root;
	private TestSuite testSuite;
	private int loopCoverage;
	private String title;
	
	public TreatmentSearch(InterfaceSearch searchObject, InterfaceVertex root, int loopCoverage, String title) {
		this.searchObject = searchObject;
		this.loopCoverage = loopCoverage;
		this.title = title;
		this.root = root;
		
		testSuite = new TestSuite();
	}
	
	public TreatmentSearch(InterfaceSearch searchObject, int loopCoverage, String title) {
		this(searchObject, null, loopCoverage, title);
	}
	
	public TreatmentSearch(String title) {
		this(null, null, 0, title);
	}

	public int getLoopCoverage() {
		return loopCoverage;
	}

	public void setLoopCoverage(int loopCoverage) {
		this.loopCoverage = loopCoverage;
	}

	public InterfaceVertex getRoot() {
		return root;
	}

	public void setRoot(InterfaceVertex root) {
		this.root = root;
	}

	public TestSuite getTestSuite() {
		return testSuite;
	}

	@Override
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public TestSuite execute() {
		testSuite = searchObject.getTestSuite(root, loopCoverage);
		return testSuite;
	}
}
