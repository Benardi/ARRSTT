package br.edu.ufcg.splab.experiment;

import java.util.ArrayList;
import java.util.List;

public class FactorSearch implements Factor {
	private List<Treatment> treatments;

	public FactorSearch() {
		treatments = new ArrayList<Treatment>();
	}

	public Treatment getTreatment() {
		return null;

	}

	public boolean addTreatment(Treatment t) {
		return treatments.add(t);

	}
}
