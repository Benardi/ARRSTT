package br.edu.ufcg.splab.experiment.core.combinators;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.core.InterfaceFactor;
import br.edu.ufcg.splab.experiment.core.factors.FactorSearch;
import br.edu.ufcg.splab.experiment.useless.TreatmentInterface;

public class CFCombinator extends AbstractCombinator {
	
	public CFCombinator(List<InterfaceFactor<?>> factors) {
		super(factors);
	}
	
	public CFCombinator() {
		super(new ArrayList<InterfaceFactor<?>>());
	}
	
	public List<List<?>> combinate() {
		List<List<?>> combinatedList = new ArrayList<List<?>>();
		TreatmentInterface<?>[] searches = (TreatmentInterface[]) super.getFactors().get(0).getTreatments();
		TreatmentInterface<?>[] loopCoverage = (TreatmentInterface[]) super.getFactors().get(1).getTreatments();
		TreatmentInterface<?>[] factorBranches = (TreatmentInterface[]) super.getFactors().get(2).getTreatments();
		
		
		for (TreatmentInterface<?> search : searches) {
			for (TreatmentInterface<?>  loop : loopCoverage) {
				for (TreatmentInterface<?>  factorBranch : factorBranches) {
					List<TreatmentInterface<?>> f = new ArrayList<TreatmentInterface<?>>();
					
					f.add(search);
					f.add(loop);
					f.add(factorBranch);
					
					combinatedList.add(f);
				}
			}
		}
		
		
		return combinatedList;
	}
	
}
