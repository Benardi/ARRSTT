package br.edu.ufcg.splab.experiment.core.factors;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment.core.treatments.ExecutableTreatment;

public class Factor extends AbstractFactor {

	public Factor(List<ExecutableTreatment> treatments) {
		super(treatments);
	}

	public Factor() {
		super(new ArrayList<ExecutableTreatment>());
	}
}
