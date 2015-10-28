package br.edu.ufcg.splab.experiment_hierarchy.minimizations.interfaces;

import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestRequirement;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-10-28
 * 
 */
public interface RequirementTracer {
	public Map<TestRequirement, Set<TestCase>> getMap();
}
