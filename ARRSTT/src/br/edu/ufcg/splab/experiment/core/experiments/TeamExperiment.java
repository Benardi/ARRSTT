package br.edu.ufcg.splab.experiment.core.experiments;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.experiment.core.combinators.Combinable;
import br.edu.ufcg.splab.experiment.core.factors.InterfaceFactor;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.searchs.InterfaceSearch;

/**
 * This is the class that should execute the specific experiment made
 * on the ARRSTT project. 
 */
public class TeamExperiment extends ReplicableExperiment {
	public static final String LINE_END = System.getProperty("line.separator");
	
	private ReadTGF tgfReader;
	private File[] graphFiles;
	private List<String> outputs; // added by Iaron. This should contain all outputs.
	
	/**
	 * Build a new Experiment Executer, receiving the factors of the experiments
	 * the combinator responsible to combine the treatments on a specefic way and the
	 * number of times it will be re-executed.
	 * @param factors
	 * 			The list of factors of this Experiment
	 * @param combinator
	 * 			The combinator responsible to combine the treatments.
	 * @param repNumber
	 * 			The number of times the experiment will be re-executed
	 * @throws Exception
	 * 			An exception is throwed if the list of factors has more than 3 factors,
	 * 			since it should work just for our experiment.
	 */
	public TeamExperiment(List<InterfaceFactor<?>> factors,	Combinable combinator, int repNumber) throws Exception {
		super(factors, combinator, repNumber);
		
		// Added to ensure our experiment will work. - Iaron
		if(factors.size() != 3) throw new Exception("This experiment must have exactly 3 factors");
		
		//later it should be added some instanceof() to assure the factors are searches,
		//loop coverages and branch type
		
		this.tgfReader = new ReadTGF();
		this.graphFiles = new File("input_examples/").listFiles();
		this.outputs = new ArrayList<>();
	}

	@Override
	public void runExperiment() throws Exception {
		List<InterfaceGraph> runGraphs = graphsToRun(0);
		
		for (int i = 1; i <= this.getRepNumber(); i++) {
			//The list of every treatment combination possible
			List<List<?>> combinations = getCombinator().combine();
			
			//fill the outputs List
			//it writes what treatments are being used on every line
			for (List<?> combination : combinations) {
				InterfaceSearch search = (InterfaceSearch) combination.get(0);
				Integer loopCoverage = (Integer) combination.get(1);
				Integer branchType = (Integer) combination.get(2);
				
				outputs.add(search.getName() + loopCoverage + ":"); // branchType to be added in the future
			}
			
			//This for iterates on every combination
			for(int j = 0; j < combinations.size(); j++){
				InterfaceSearch search = (InterfaceSearch) combinations.get(j).get(0);
				Integer loopCoverage = (Integer) combinations.get(j).get(1);
				Integer branchType = (Integer) combinations.get(j).get(2);
				
				//This is the for that will run the experiment and save it's execution time.
				for (InterfaceGraph graph : runGraphs) {
					Long initTime = System.nanoTime();
					search.getTestSuite(graph.getRoot(), loopCoverage);
					Long endTime = System.nanoTime();
					
					//This block has to be heavily checked
					Long timeDif = (endTime - initTime);
					String output = timeDif.toString();
					String currentOutput = outputs.get(j);
					currentOutput += output;
					outputs.set(j, currentOutput);
					
				}
			}
		}
		
		putToFile(outputs);
	}
	
	
	//This Branch type will be used once we have de measurement, right? - Iaron
	//Right now it just goes to the folder and create a list of graphs
	private List<InterfaceGraph> graphsToRun(Integer branchType) throws Exception {
		List<InterfaceGraph> graphs = new ArrayList<InterfaceGraph>();
		
 		for (File file : graphFiles) { 
			graphs.add(tgfReader.getGraph(file.getAbsolutePath()));
		}
 		
 		return graphs;
	}
	
	//Writes the results, saved in a String, in a txt.
	private void putToFile(List<String> outputs) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File( "Experiment.txt")));
		
		for(String output : outputs){
			writer.write(output + LINE_END);
		}
		
		writer.close();
	}
}
