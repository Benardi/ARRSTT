package br.edu.ufcg.splab.experiment_hierarchy.util.testcollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

	/*
	 * Change														Author				Date
	 * -------------------------------------------------------------------------------------------
	 * Creation														Iaron Araujo		2015-03-31
	 * 
	 */
/**
 * <b>Objective:</b>This class represents a test case.It is a list of edges of a
 * graph.<br>
 * <br>
 * <b>Description of use:</b> This class is an attribute of the test suite
 * class.
 *
 */
public class TestCase implements Iterable<InterfaceEdge> {

	/**
	 * The list of edges
	 */
	private List<InterfaceEdge> tCase;
	
	private String name;
	private String id;

	/**
	 * * <b>Objective:</b> Enable the construction of and object from this
	 * class. <br>
	 * <br>
	 * 
	 * <b>Description of use:</b> This constructor is used to create a new
	 * object from this class and initialize it through the creation of a list
	 * of edges.
	 * 
	 * @param tCase
	 *            The list of edges.
	 */
	public TestCase(List<InterfaceEdge> tCase) {
		this.tCase = tCase;
		this.name = "Noname";
		this.id = "Noname";
	}

	/**
	 * <b>Objective:</b> Create a new test case identical to the one received. <br>
	 * 
	 * <b>Example of use:</b> Used in the method get copy.
	 * 
	 * @param tCaseCopy
	 *            The TesCase to be received.
	 */
	public TestCase(TestCase tCaseCopy) {
		this.tCase = tCaseCopy.getTestCaseCopy();
		this.name = tCaseCopy.getName();
		this.id = tCaseCopy.getID();
	}

	/**
	 * This constructor creates an empty TestCase.
	 */
	public TestCase() {
		this(new ArrayList<InterfaceEdge>());
		this.name = "Noname";
		this.id = "Noname";
	}
	
	public TestCase(String id, String name){
		this(new ArrayList<InterfaceEdge>());
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return The list of edges.
	 */
	/**
	 * <b>Objective:</b> Giving a copy of the edge's list. <br>
	 * 
	 * <<b>Example of use:</b> This method is used when the edge's list must be
	 * manipulated and yet it's necessary to keep its original state.
	 * 
	 * @return a copy of the edge's list.
	 */
	public List<InterfaceEdge> getTestCase() {
		return tCase;
	}

	/**
	 * <b>Objective:</b> Giving a copy of the edge's list. <br>
	 * 
	 * <<b>Example of use:</b> This method is used when the edge's list must be
	 * manipulated and yet it's necessary to keep its original state.
	 * 
	 * @return a copy of the edge's list.
	 */
	public List<InterfaceEdge> getTestCaseCopy() {
		return new ArrayList<InterfaceEdge>(tCase);
	}

	/**
	 * <b>Objective:</b> Giving a copy of the test case. <br>
	 * 
	 * <<b>Example of use:</b> This method is used when the test case must be
	 * manipulated and yet it's necessary to keep its original state.
	 * 
	 * @return a copy of the TestCase.
	 */
	public TestCase getCopy() {
		List<InterfaceEdge> copyList = new ArrayList<InterfaceEdge>(tCase);
		return new TestCase(copyList);
	}

	// Forwarding part
	public int size() {
		return tCase.size();
	}
	
	public boolean isEmpty() {
		return tCase.isEmpty();
	}

	public boolean contains(Object o) {
		return tCase.contains(o);
	}

	@Override
	public Iterator<InterfaceEdge> iterator() {
		return tCase.iterator();
	}

	public Object[] toArray() {
		return tCase.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return tCase.toArray(a);
	}

	public boolean add(InterfaceEdge e) {
		return tCase.add(e);
	}
		
	public boolean addEdge(InterfaceEdge e) {
		return tCase.add(e);
	}

	public boolean remove(Object o) {
		return tCase.remove(o);
	}

	public boolean containsAll(TestCase c) {
		return tCase.containsAll(c.getTestCase());
	}
	
	public boolean containsAll(List<InterfaceEdge> c) {
		return tCase.containsAll(c);
	}

	public boolean addAll(List<InterfaceEdge> c) {
		return tCase.addAll(c);
	}

	public boolean addAll(int index, List<InterfaceEdge> c) {
		return tCase.addAll(c);
	}

	public boolean removeAll(List<InterfaceEdge> c) {
		return tCase.removeAll(c);
	}

	public boolean retainAll(List<InterfaceEdge> c) {
		return tCase.retainAll(c);
	}

	public void clear() {
		tCase.clear();
	}

	public InterfaceEdge get(int index) {
		return tCase.get(index);
	}

	public InterfaceEdge set(int index, InterfaceEdge element) {
		return tCase.set(index, element);
	}

	public void add(int index, InterfaceEdge element) {
		tCase.add(index, element);
	}

	public InterfaceEdge remove(int index) {
		return tCase.remove(index);
	}

	public int indexOf(Object o) {
		return tCase.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return tCase.lastIndexOf(o);
	}

	public ListIterator<InterfaceEdge> listIterator() {
		return tCase.listIterator();
	}

	public ListIterator<InterfaceEdge> listIterator(int index) {
		return tCase.listIterator(index);
	}

	public List<InterfaceEdge> subList(int fromIndex, int toIndex) {
		return tCase.subList(fromIndex, toIndex);
	}
	
	@Override // GENERATE THIS AGAIN
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tCase == null) ? 0 : tCase.hashCode());
		return result;
	}

	@Override // IMPLEMENT THIS AGAIN SHOULD
	public boolean equals(Object obj) {
		if (!(obj instanceof TestCase))
			return false;
		TestCase other = (TestCase) obj;
		if (tCase.equals(other.getTestCase())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "{ID: " + this.id + " NAME: " + this.name + "}" + tCase.toString();
	}
	
	public String getID(){
		return id;
	}

}
