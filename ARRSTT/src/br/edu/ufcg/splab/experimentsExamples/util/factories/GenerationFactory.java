package br.edu.ufcg.splab.experimentsExamples.util.factories;

import br.edu.ufcg.splab.experimentsExamples.techniques.generation.BFSTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.generation.DFSTechnique;
import br.edu.ufcg.splab.experimentsExamples.techniques.generation.InterfaceGenerationTechnique;
import br.edu.ufcg.splab.experimentsExamples.util.enums.GenerationType;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> This class covers all necessary procedure involved in the process
 * of generating a search.
 * <br>
 * <b>Description of use:</b> Receives a type and returns a search of the respective
 * type.
 */
public class GenerationFactory {
	/**
	 * 
	 * @param type
	 *            the type of search
	 * @return A search
	 */
	public InterfaceGenerationTechnique createTreatment(GenerationType type) {
		if (type == GenerationType.BFS) {
			return createBfsGenerator();
		} else {
			return createDfsGenerator();
		}
	}
	/**
	 * 
	 * @return A Breadth First Search.
	 */
	public InterfaceGenerationTechnique createBfsGenerator() {
		return new BFSTechnique();
	}
	/**
	 * 
	 * @return A Depth First Search.
	 */
	public InterfaceGenerationTechnique createDfsGenerator() {
		return new DFSTechnique();
	}
}
