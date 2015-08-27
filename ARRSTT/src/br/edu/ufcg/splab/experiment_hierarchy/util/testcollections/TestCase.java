package br.edu.ufcg.splab.experiment_hierarchy.util.testcollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.edu.ufcg.splab.graph.core.InterfaceEdge;

/**
 * This class represents a testcase. It is a
 * list of edges of a graph.
 */
public class TestCase implements List<InterfaceEdge>{
	
	/**
	 * The list of edges
	 */
	private List<InterfaceEdge> tCase;
	
	/**
	 * A constructor that already receives a list of edges.
	 * @param tCase
	 * 			The list of edges.
	 */
	public TestCase(List<InterfaceEdge> tCase){
		this.tCase = tCase;
	}
	
	/**
	 * A constructor that receives another testcase, making a copy of it.
	 * @param tCaseCopy
	 * 			The TesCase to be received.
	 */
	public TestCase(TestCase tCaseCopy){
		this.tCase = tCaseCopy.getTestCaseCopy();
	}
	
	/**
	 * This constructor creates an empty TestCase.
	 */
	public TestCase(){
		this(new ArrayList<InterfaceEdge>());
	}
	
	/**
	 * 
	 * @return The list of deges.
	 */
	public List<InterfaceEdge> getTestCase(){
		return tCase;
	}
	
	/**
	 * 
	 * @return a copy of the edge's list.
	 */
	public List<InterfaceEdge> getTestCaseCopy(){
		return new ArrayList<InterfaceEdge>(tCase);
	}
	
	/**
	 * 
	 * @return a copy of the TestCase.
	 */
	public TestCase getCopy(){
		List<InterfaceEdge> copyList = new ArrayList<InterfaceEdge>(tCase);
		return new TestCase(copyList);
	}

	
	// Forwarding part
	
	@Override
	public int size() {
		return tCase.size();
	}

	@Override
	public boolean isEmpty() {	 
		return tCase.isEmpty();
	}

	@Override
	public boolean contains(Object o) {	 
		return tCase.contains(o);
	}

	@Override
	public Iterator<InterfaceEdge> iterator() {	 
		return tCase.iterator();
	}

	@Override
	public Object[] toArray() {	 
		return tCase.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {	 
		return tCase.toArray(a);
	}

	@Override
	public boolean add(InterfaceEdge e) {	 
		return tCase.add(e);
	}

	@Override
	public boolean remove(Object o) {
		 
		return tCase.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {	 
		return tCase.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends InterfaceEdge> c) {	 
		return tCase.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends InterfaceEdge> c) {	 
		return tCase.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {	 
		return tCase.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {	 
		return tCase.retainAll(c);
	}

	@Override
	public void clear() {	 
		tCase.clear();
	}

	@Override
	public InterfaceEdge get(int index) {	 
		return tCase.get(index);
	}

	@Override
	public InterfaceEdge set(int index, InterfaceEdge element) {	 
		return tCase.set(index, element);
	}

	@Override
	public void add(int index, InterfaceEdge element) {	 
		tCase.add(index, element);
	}

	@Override
	public InterfaceEdge remove(int index) {	 
		return tCase.remove(index);
	}

	@Override
	public int indexOf(Object o) {	 
		return tCase.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {	 
		return tCase.lastIndexOf(o);
	}

	@Override
	public ListIterator<InterfaceEdge> listIterator() {	 
		return tCase.listIterator();
	}

	@Override
	public ListIterator<InterfaceEdge> listIterator(int index) {	 
		return tCase.listIterator(index);
	}

	@Override
	public List<InterfaceEdge> subList(int fromIndex, int toIndex) {
		return tCase.subList(fromIndex, toIndex);
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof TestCase)) return false;
		TestCase other = (TestCase) obj;
		if(tCase.equals(other.getTestCase())){
			return true;
		} else{
			return false;
		}
	}
	
	@Override
	public String toString(){
		return tCase.toString();
	}

	
	


}