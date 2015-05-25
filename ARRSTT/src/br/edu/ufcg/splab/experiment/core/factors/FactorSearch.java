package br.edu.ufcg.splab.experiment.core.factors;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.useless.Treatment;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

public class FactorSearch extends AbstractFactor<InterfaceSearch> {

	public FactorSearch(List<Treatment<InterfaceSearch>> treatments) {
		super(treatments);
	}
	
	public FactorSearch() {
		super(new ArrayList<Treatment<InterfaceSearch>>());
	}
	
}
