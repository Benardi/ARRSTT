package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectiveEdgesCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTDefectsCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTFailuresCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.ARRSTTSizeCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-09-16
 * 
 */
/**
 * <b>Objective:</b> This class covers all necessary procedure involved in the process
 * of generating all the possible dependent variable collectors.
 * <br>
 * <b>Description of use:</b> Receives a type and returns a collector of the respective
 * type, this process can be repeated as the collectors are put in a List.
 */
public class DVCFactory {
	/**
	 * <b>Objective:</b> Generating a dependent variable collector whose type of
	 * variable is the same as the provided one.
	 * <br>
	 * <b>Description of use:</b> The generated dvc can be used in the building of a
	 * generation as in the Experiment Factory class.
	 * 
	 * @param type
	 *            The type of variable the collector will manage.
	 * @return A collector of variables of specific type.
	 */
	public DependentVariableCollector createCollector(DVCType type) {
		if (type == DVCType.DEFECTIVE_EDGES) {
			return new ARRSTTDefectiveEdgesCollector();
		} else if (type == DVCType.DEFECTS) {
			return new ARRSTTDefectsCollector();
		} else if (type == DVCType.FAILURES) {
			return new ARRSTTFailuresCollector();
		} else if (type == DVCType.SIZE) {
			return new ARRSTTSizeCollector();
		} else {
			return null;
		}
	}

	/**
	 * <b>Objective:</b> This method initializes and fills a list with different
	 * collectors.
	 * 
	 * @param types
	 *            The type of the variables that each collector will manage.
	 * @return A list filled with one collector for each of the types given.
	 */
	public List<DependentVariableCollector> createCollectorList(
			Iterable<DVCType> types) {
		List<DependentVariableCollector> dvcs = new ArrayList<>();

		for (DVCType type : types) {
			dvcs.add(createCollector(type));
		}

		return dvcs;
	}

	/**
	 * <b>Objective:</b> This method initializes and fills a list with one collector
	 * for each of the existing types.
	 * 
	 * @param types
	 *            All the types of dependent variables.
	 * @return A list filled with one collector for each one of all the types.
	 */
	public List<DependentVariableCollector> createCollectorList(
			DVCType... types) {
		List<DependentVariableCollector> dvcs = new ArrayList<>();

		for (DVCType type : types) {
			dvcs.add(createCollector(type));
		}

		return dvcs;
	}
}
