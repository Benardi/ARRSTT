package br.edu.ufcg.splab.experiment;

import java.util.ArrayList;

import br.edu.ufcg.splab.searchs.BreadthFirstSearch;
import br.edu.ufcg.splab.searchs.DepthFirstSearch;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

public class Main {
	private void doExperiment(ArrayList<Factor> list, int replication){
		
	}

	public static void main(String[] args) {
		Factor f = new FactorSearch();
		Treatment<InterfaceSearch> t1 = new Treatment<InterfaceSearch>(new BreadthFirstSearch());
		Treatment<InterfaceSearch> t2 = new Treatment<InterfaceSearch>(new DepthFirstSearch());
	
		f.addTreatment(t1);
		f.addTreatment(t2);
	}
}
