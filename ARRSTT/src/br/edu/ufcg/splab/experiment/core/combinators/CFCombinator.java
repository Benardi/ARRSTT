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
	
	/* There are two things here that we may look... first, this works just for our experiment, because
	 * it is explicit what each treatment is, and it combines exactly 3 factors, I think we can make
	 * this work for any amount of factors. The other thing is that since I've made some changes to Factor
	 * itself and that now we have a Treatment class, I think this method should return a List<List<Treatment>>
	 * because this will make it more flexible and keep the Expert. So, what do you think? - Iaron
	 */
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
