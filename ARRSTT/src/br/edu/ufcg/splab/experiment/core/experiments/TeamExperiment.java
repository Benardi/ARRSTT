package br.edu.ufcg.splab.experiment.core.experiments;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.experiment.core.Combinable;
import br.edu.ufcg.splab.experiment.core.InterfaceFactor;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

public class TeamExperiment extends ReplicableExperiment {
	public static final String LINE_END = System.getProperty("line.separator");
	
	private ReadTGF tgfReader;
	private File[] graphFiles;
	
	public TeamExperiment(List<InterfaceFactor<?>> factors,	Combinable combinator, int repNumber) {
		super(factors, combinator, repNumber);
		
		this.tgfReader = new ReadTGF();
		this.graphFiles = new File("input_examples/").listFiles();
	}

	@Override
	public void runExperiment() {
		List<InterfaceGraph> runGraphs = graphsToRun(0);
		String output = "";
		
		for (int i = 1; i <= this.getRepNumber(); i++) {
			List<List<?>> combinations = getCombinator().combinate();
			
			for (List<?> combination : combinations) {
				InterfaceSearch search = (InterfaceSearch) combination.get(0);
				Integer loopCoverage = (Integer) combination.get(1);
				Integer branchType = (Integer) combination.get(2);

				for (InterfaceGraph graph : runGraphs) {
					long initTime = System.nanoTime();
					search.getTestSuite(graph.getRoot(), loopCoverage);
					long endTime = System.nanoTime();
				}
			}
		}
	}
	
	private List<InterfaceGraph> graphsToRun(Integer branchType) throws Exception {
		List<InterfaceGraph> graphs = new ArrayList<InterfaceGraph>();
		
 		for (File file : graphFiles) { 
			graphs.add(tgfReader.getGraph(file.getAbsolutePath()));
		}
 		
 		return graphs;
	}
}
