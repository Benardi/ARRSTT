package br.edu.ufcg.splab.experiment_hierarchy.util.testcollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-05-15
 * 
 */
/**
 * <b>Objective:</b> This class represents a test suite. A list of TestCases.<br>
 * <br>
 * <b>Description of use:</b> The Test Suite is the input and output of all the
 * selection classes.
 *
 */
public class TestSuite implements Iterable<TestCase> {

	/**
	 * The list of TestCases.
	 */
	private List<TestCase> tSuite;
	
	private String id;

	/**
	 * <b>Objective:</b> Enable the construction of and object from this class. <br>
	 * <br>
	 * 
	 * <b>Description of use:</b> This constructor is used to create a new
	 * object from this class and initialize it through the creation of a list
	 * of test cases.
	 * 
	 * @param tSuite
	 *            The list of TestCase.
	 */
	public TestSuite(List<TestCase> tSuite, String id) {
		this.tSuite = tSuite;
		this.id = id;
	}

	/**
	 * <b>Objective:</b>Constructor that receives another TestSuite and makes a
	 * copy of it. <br>
	 * 
	 * <b>Example of use:</b> Used in the method getTestSuiteCopy.
	 * 
	 * @param tSuiteCopy
	 *            The TestSuite to be copied.
	 */
	public TestSuite(TestSuite tSuiteCopy) {
		this.tSuite = tSuiteCopy.getTestSuiteCopy();
		id = tSuiteCopy.getID();
	}
	
	public TestSuite() {
		this(new ArrayList<TestCase>(), "noid");
	}

	/**
	 * Creates an empty TestSuite.
	 */
	public TestSuite(String id) {
		this(new ArrayList<TestCase>(), id);
		this.id = id;
	}

	/**
	 * <b>Objective:</b> Gives access to the test suite. <br>
	 * 
	 * <b>Example of use:</b> Used to gain access to the test suite outside the
	 * domain of the class.
	 * 
	 * @return the list of TestCase.
	 */
	public List<TestCase> getTestSuite() {
		return tSuite;
	}

	/**
	 * <b>Objective:</b> Giving a copy of the Test Suite. <br>
	 * 
	 * <<b>Example of use:</b> This method is used when the list of TestCase
	 * must be manipulated and yet it's necessary to keep its original state.
	 * 
	 * @return A copy of the list of TestCase.
	 */
	public List<TestCase> getTestSuiteCopy() {
		return new ArrayList<TestCase>(tSuite);
	}

	/**
	 * 
	 * @return A copy of the TestSuite.
	 */
	/**
	 * <b>Objective:</b> Create a new Test Suite identical to the previous one. <br>
	 * 
	 * <<b>Example of use:</b> This method is used when the Test Suite must be
	 * manipulated and yet it's necessary to keep its original state.
	 * 
	 * @return A copy of the TestSuite.
	 */
	public TestSuite getCopy() {
		List<TestCase> copyList = new ArrayList<TestCase>(tSuite);
		return new TestSuite(copyList, "noid");
	}
	
	public String getID(){
		return id;
	}

	public int size() {
		return tSuite.size();
	}

	public boolean isEmpty() {
		return tSuite.isEmpty();
	}

	public boolean contains(Object o) {
		return tSuite.contains(o);
	}

	@Override
	public Iterator<TestCase> iterator() {
		return tSuite.iterator();
	}

	public Object[] toArray() {
		return tSuite.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return tSuite.toArray(a);
	}

	public boolean add(TestCase e) {
		return tSuite.add(e);
	}

	public boolean remove(Object o) {
		return tSuite.remove(o);
	}

	public boolean containsAll(List<TestCase> c) {
		return tSuite.containsAll(c);
	}

	public boolean addAll(List<TestCase> c) {
		return tSuite.addAll(c);
	}

	public boolean addAll(int index, List<TestCase> c) {
		return tSuite.addAll(index, c);
	}

	public boolean removeAll(List<TestCase> c) {
		return tSuite.removeAll(c);
	}

	public boolean retainAll(List<TestCase> c) {
		return tSuite.retainAll(c);
	}

	public void clear() {
		tSuite.clear();
	}

	public TestCase get(int index) {
		return tSuite.get(index);
	}

	public TestCase set(int index, TestCase element) {
		return tSuite.set(index, element);
	}

	public void add(int index, TestCase element) {
		tSuite.add(index, element);
	}

	public TestCase remove(int index) {
		return tSuite.remove(index);
	}

	public int indexOf(Object o) {
		return tSuite.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return tSuite.lastIndexOf(o);
	}

	public ListIterator<TestCase> listIterator() {
		return tSuite.listIterator();
	}

	public ListIterator<TestCase> listIterator(int index) {
		return tSuite.listIterator(index);
	}

	public List<TestCase> subList(int fromIndex, int toIndex) {
		return tSuite.subList(fromIndex, toIndex);
	}

	// GENERATE HASHCODE
	
	public boolean equals(Object obj) { // IMPLEMENT THIS AGAIN
		if (!(obj instanceof TestSuite))
			return false;
		TestSuite other = (TestSuite) obj;
		if (tSuite.equals(other.getTestSuite())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String output = "";

		for (TestCase tCase : tSuite) {
			output += tCase.toString();
		}

		return output;
	}

	public TestCase nulify(int index) {
		return tSuite.set(index, null);
	}
}
