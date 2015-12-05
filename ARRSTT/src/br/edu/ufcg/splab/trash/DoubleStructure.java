package br.edu.ufcg.splab.trash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class DoubleStructure {
	private Map<TestCase, List<TestRequirement>> tcTOreq;
	private Map<TestRequirement, Set<TestCase>> reqTOtc;
	
	public DoubleStructure(TestSuite tSuite, List<TestRequirement> reqs) {
		this.tcTOreq = buildTTR(tSuite, reqs);
		this.reqTOtc = buildRTT(tSuite, reqs);
	}
	
	public TestCase markTestCase() {
		List<TestCase> mstestCases = mostSatisfiedTestcases();
		
		if (!mstestCases.isEmpty()) {
			TestCase choosenTestCase = getRandomTestCase(mstestCases);
			if (tcTOreq.get(choosenTestCase).size() == 0) return null; 
			removeTestcase(choosenTestCase);
			return choosenTestCase;
		}
		
		return null;
	}
	
	public TestCase markEssencialTestCase() {
		List<TestCase> etCases = essencialTestcases();
		
		if (!etCases.isEmpty()) {
			TestCase choosenTestCase = getRandomTestCase(etCases);
			//System.out.println(choosenTestCase);
			//if (reqTOtc.get(choosenTestCase).size() == 0) return null;
			removeTestcase(choosenTestCase);
			for (TestRequirement req : reqTOtc.keySet()) {
				if (reqTOtc.get(req).size() == 1) reqTOtc.get(req).remove(choosenTestCase);
			}
			
			return choosenTestCase;
		}
		
		return null;
	}
	
	public TestCase markNonRedundantTestCase() {
		List<TestCase> nrtCases = nonRedundantTestcases();
		
		if (!nrtCases.isEmpty()) {
			TestCase choosenTestCase = getRandomTestCase(nrtCases);
			removeTestcase(choosenTestCase);
			return choosenTestCase;
		}
		
		return null;
	}
	
	private void removeTestcase(TestCase removingtCase) {
		if (!tcTOreq.containsKey(removingtCase)) throw new RuntimeException("TEST CASE COULD NOT BE REMOVED");
		List<TestRequirement> markedReqs = tcTOreq.get(removingtCase);
		
		// REMOTION ON tcTOreq
		tcTOreq.remove(removingtCase);
		
		for (TestCase tCase : tcTOreq.keySet()) {
			for (TestRequirement req : markedReqs) {
				if (tcTOreq.get(tCase).contains(req)) tcTOreq.get(tCase).remove(req); 
			}
		}
	}
	
	private List<TestCase> mostSatisfiedTestcases() {
		List<TestCase> mstCases = new ArrayList<TestCase>();
		int gsNumber = -1;
		
		for (TestCase tCase : tcTOreq.keySet()) {
			if (tcTOreq.get(tCase).size() > gsNumber) {
				gsNumber = tcTOreq.get(tCase).size();
				mstCases = new ArrayList<TestCase>();
				mstCases.add(tCase);
			} else if (tcTOreq.get(tCase).size() == gsNumber) {
				mstCases.add(tCase);
			}
		}
		
		return mstCases;
	}
	
	private List<TestCase> essencialTestcases() {
		List<TestCase> etCases = new ArrayList<TestCase>();
		
		for (TestRequirement req : reqTOtc.keySet()) {
			if (reqTOtc.get(req).size() == 1) {
				Iterator<TestCase> it = reqTOtc.get(req).iterator();
				etCases.add(it.next());
			}
		}
		
		return etCases;
	}
	
	private List<TestCase> nonRedundantTestcases() {
		List<TestCase> nrtCases = new ArrayList<TestCase>();
		Map<TestCase, Set<TestCase>> redundancyMap = new HashMap<TestCase, Set<TestCase>>();
		
		for (TestCase tCase : tcTOreq.keySet()) {
			for (TestCase innertCase : tcTOreq.keySet()) {
				if (!tCase.equals(innertCase) && !innertCase.isEmpty() && tCase.containsAll(innertCase)) {
					if (!redundancyMap.containsKey(tCase)) {
						redundancyMap.put(tCase, new HashSet<TestCase>());
					}
					
					redundancyMap.get(tCase).add(innertCase);
				}
			}
		}
		
		int gsNumber = -1;
		
		for (TestCase tCase : redundancyMap.keySet()) {
			if (redundancyMap.get(tCase).size() > gsNumber) {
				gsNumber = redundancyMap.get(tCase).size();
				nrtCases = new ArrayList<TestCase>();
				nrtCases.add(tCase);
			} else if (redundancyMap.get(tCase).size() == gsNumber) {
				nrtCases.add(tCase);
			}
		}
		
		return nrtCases;
	}
	
	private TestCase getRandomTestCase(List<TestCase> tCases) {
		return tCases.get(randIndex(tCases.size()));
	}
	
	private Map<TestCase, List<TestRequirement>> buildTTR(TestSuite tSuite, List<TestRequirement> reqs) {
		Map<TestCase, List<TestRequirement>> tcTOreq = new HashMap<>();
		
		for (TestCase tCase : tSuite) {
			tcTOreq.put(tCase, new ArrayList<TestRequirement>());
			
			for (TestRequirement req : reqs) {
				if (req.cover(tCase)) tcTOreq.get(tCase).add(req);
			}
		}
		
		return tcTOreq;
	}
	
	private Map<TestRequirement, Set<TestCase>> buildRTT(TestSuite tSuite, List<TestRequirement> reqs) {
		Map<TestRequirement, Set<TestCase>> reqTOtc = new HashMap<>();
		
		for (TestRequirement req : reqs) {
			reqTOtc.put(req, new HashSet<TestCase>()); 
			
			for (TestCase tCase : tSuite) {
				if (req.cover(tCase)) reqTOtc.get(req).add(tCase);
			}
		}
		
		return reqTOtc;
	}
	
	private int randIndex(int upperBound) {
		return new Random().nextInt(upperBound);
	}
}

/*private void removeRequirement(TestRequirement removingReq) {
if (!reqTOtc.containsKey(removingReq)) throw new RuntimeException("REQUIREMENT COULD NOT BE REMOVED");
Set<TestCase> markedtCases = reqTOtc.get(removingReq);

// REMOTION ON reqTOtc
reqTOtc.remove(removingReq);

for (TestRequirement req : reqTOtc.keySet()) {
	for (TestCase tCase : markedtCases) {
		if (reqTOtc.get(req).contains(tCase)) reqTOtc.get(req).remove(tCase);
	}
}

// REMOTION on tcTOreq
for (TestCase tCase : markedtCases) {
	tcTOreq.get(tCase).remove(removingReq);
}
}*/
