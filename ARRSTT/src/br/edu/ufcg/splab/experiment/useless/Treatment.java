package br.edu.ufcg.splab.experiment.useless;

public class Treatment<T> implements TreatmentInterface<T> {
	private T t;

	public Treatment(T t) {
		this.t = t;
	}

	public void setTreatment(T newTreatment) {
		if (newTreatment.getClass() == t.getClass()) {
			t = newTreatment;
		}
	}

	@Override
	public boolean isEmpty() {
		if (t == null) {
			return true;
		}
		return false;
	}

	@Override
	public T getTreatment(){
		return t;
	}

}
