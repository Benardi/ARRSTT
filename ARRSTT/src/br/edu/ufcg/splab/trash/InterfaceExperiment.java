package br.edu.ufcg.splab.trash;


/**
 * Represents a generic type of experiment.
 *
 */
public interface InterfaceExperiment {
	/**
	 * This method takes care of generating all the output data of an
	 * experiment.
	 * 
	 * @throws Exception
	 * 		(To be decided)
	 */
	public void runExperiment() throws Exception; // throws Exception added by Iaron to fix an error
	
	/**
	 * Used to put a factor into the experiment.
	 * 
	 * @param factor
	 * 		The adding factor.
	 * @return
	 * 		True if the add operation was successful, false otherwise.
	 */
	public boolean addFactor(InterfaceFactor factor);
	
	/**
	 * Used to remove a factor from an experiment.
	 * 
	 * @param factor
	 * 		The removing factor.
	 * @return
	 * 		True if the remove operation was successful, false otherwise.
	 */
	public boolean removeFactor(InterfaceFactor factor);
	
	/**
	 * Used to get a factor from the experiment.
	 * 
	 * @param i
	 * 		A number that can be translated into a factor on the using representation.
	 * @return
	 * 		The retrieving factor.
	 */
	public InterfaceFactor getFactor(int i);
	
	/**
	 * Set the combinator that the experiment is currently using.
	 * 
	 * @param combinator
	 * 		The combinator that will replace the using combinator.
	 */
	public void setCombinator(Combinable combinator);
	
	/**
	 * Get the combinator that the experiment is currently using.
	 * 
	 * @return
	 * 		The using combinator.
	 */
	public Combinable getCombinator();
}
