package br.edu.ufcg.splab.trash;

import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.ARRSTTTestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-10-28
 * 
 */
public interface RequirementTracer {
	public Map<ARRSTTTestRequirement, Set<TestCase>> getMap();
}
