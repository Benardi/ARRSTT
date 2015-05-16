package br.edu.ufcg.splab.experiment;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.core.Combinable;
import br.edu.ufcg.splab.experiment.core.InterfaceExperiment;
import br.edu.ufcg.splab.experiment.core.InterfaceFactor;
import br.edu.ufcg.splab.experiment.core.combinators.CFCombinator;
import br.edu.ufcg.splab.experiment.core.experiments.TeamExperiment;
import br.edu.ufcg.splab.experiment.core.factors.FactorBranch;
import br.edu.ufcg.splab.experiment.core.factors.FactorLoopCoverage;
import br.edu.ufcg.splab.experiment.core.factors.FactorSearch;
import br.edu.ufcg.splab.searchs.BreadthFirstSearch;
import br.edu.ufcg.splab.searchs.DepthFirstSearch;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

public class Main {
	public static void main(String[] args) {
		InterfaceFactor<InterfaceSearch> factor1 = new FactorSearch();
		factor1.addTreatment(new BreadthFirstSearch());
		factor1.addTreatment(new DepthFirstSearch());
		
		InterfaceFactor<Integer> factor2 = new FactorLoopCoverage();
		factor2.addTreatment(1);
		factor2.addTreatment(4);
		factor2.addTreatment(7);
		
		InterfaceFactor<Integer> factor3 = new FactorBranch();
		factor3.addTreatment(0);
		factor3.addTreatment(1);
		
		List<InterfaceFactor<?>> factors = new ArrayList<InterfaceFactor<?>>();
		factors.add(factor1);
		factors.add(factor2);
		factors.add(factor3);
		
		Combinable combinator = new CFCombinator();
		int replications = 5;
		
		InterfaceExperiment exp1 = new TeamExperiment("Experiment 1", factors, combinator, replications);
		exp1.runExperiment();
	}
}
