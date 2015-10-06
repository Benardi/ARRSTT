package br.edu.ufcg.splab.experiment_hierarchy.core.runners;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentFile;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
* <b>Objective:</b> This interface represents a runner that
* is responsible for getting a list of ExecutableTreatment's
* tuple and execute them, collecting the experiment's dependent
* variables while doing so.
* <br>
* <b>Description of use:</b> This is used in the Experiment class, so it
* can get a SetUp's combinations.
*
*/
public class DefaultRunner implements InterfaceRunner {
	public static final String LINE_END = System.getProperty("line.separator");
	private List<DependentVariableCollector> dvcs;
	private List<StringBuffer> stringBuffers;
	private int lineSize;
	
	/**
	 * The constructor that receives a list of dependent
	 * variable collectors and initialize the StringBuffers
	 * that are going to contain the dependent variables' data.
	 * 
	 * @param dvcs
	 * 			The list of the DependentVariableCollectors for 
	 * 			this experiment.
	 */
	public DefaultRunner(List<DependentVariableCollector> dvcs, int lineSize) {
		this.dvcs = dvcs;
		this.stringBuffers = new ArrayList<StringBuffer>();
		this.lineSize = lineSize;
		
		for (int i = 0; i < dvcs.size(); i++) {
			stringBuffers.add(new StringBuffer());
		}
	}
	
	@Override
	/**
	 * <b>Objective:</b> this method is responsible for getting a 
	 * list of ExecutableTreatment's tuple and execute them,
	 * collecting the experiment's dependent variables and
	 * saving them in StringBuffers while doing so.
	 * <br>
	 * <b>Exemple of use:</b> Used in the Experiment's method to execute
	 * the experiment.
	 * @param combinations
	 * 			The combinations generated by a set up.
	 */
	public void runExperiment(List<Tuple<ExecutableTreatment>> combinations) {
		for (int i = 0; i < dvcs.size(); i++) {
			for (int j = 0; j < combinations.size(); j++) {
				stringBuffers.get(i).append(dvcs.get(i).collect(combinations.get(j)) + "\t");
				
				if ((j + 1) % lineSize == 0) {
					stringBuffers.get(i).append(LINE_END);
				}
			}				
		}
		
		saveBuffers();
	}
	
	/**
	 * <b>Objective:</b> Return the StringBuffers that contains
	 * the experiment data.
	 * <br>
	 * <b>Exemple of use:</b> In a class that gets the experiment's
	 * data and write it in a file.
	 * 
	 * @return The StringBuffers containing the execution's
	 * data.
	 */
	public List<StringBuffer> getStringBuffers() {
		return stringBuffers;
	}
	
	/**
	 * <b>Objective:</b> Save the StringBuffer's data in a file.
	 */
	public void saveBuffers() {
		String dirName = createDirectory();		
		for (int i = 0; i < stringBuffers.size(); i++) {
			try {
				ExperimentFile file = new ExperimentFile(dirName + "/" + dvcs.get(i).toString());
				file.appendContent(stringBuffers.get(i));
				file.save();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String createDirectory(){
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd__HH-mm-ss");
//		Date date = new Date();
		LocalDateTime data = LocalDateTime.now();
		
		String dirName = "experiment_results/" + data.toString().replaceAll("T", "__").replaceAll(":", "_");
		boolean sucess = (new File (dirName)).mkdirs();
		if(!sucess){
			System.out.println("FAILURE TO CREATE THE DIRECTORY");
		}
		return dirName;
	}
}
