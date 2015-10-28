package br.edu.ufcg.splab.experiment_hierarchy.util.testcollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-10-28
 * 
 */
public class TestRequirement implements List<InterfaceEdge>{
	
	private List<InterfaceEdge> transitions;
	
	public TestRequirement(){
		transitions = new ArrayList<>();
	}
	
	public List<InterfaceEdge> getTransitions(){
		return transitions;
	}
	
	// Forwarding part

	@Override
	public int size() {
		return transitions.size();
	}

	@Override
	public boolean isEmpty() {
		return transitions.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return transitions.contains(o);
	}

	@Override
	public Iterator<InterfaceEdge> iterator() {
		return transitions.iterator();
	}

	@Override
	public Object[] toArray() {
		return transitions.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return transitions.toArray(a);
	}

	@Override
	public boolean add(InterfaceEdge e) {
		return transitions.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return transitions.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return transitions.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends InterfaceEdge> c) {
		return transitions.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends InterfaceEdge> c) {
		return transitions.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return transitions.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return transitions.retainAll(c);
	}

	@Override
	public void clear() {
		transitions.clear();
	}

	@Override
	public InterfaceEdge get(int index) {
		return transitions.get(index);
	}

	@Override
	public InterfaceEdge set(int index, InterfaceEdge element) {
		return transitions.set(index, element);
	}

	@Override
	public void add(int index, InterfaceEdge element) {
		transitions.add(index, element);
	}

	@Override
	public InterfaceEdge remove(int index) {
		return transitions.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return transitions.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return transitions.lastIndexOf(o);
	}

	@Override
	public ListIterator<InterfaceEdge> listIterator() {
		return transitions.listIterator();
	}

	@Override
	public ListIterator<InterfaceEdge> listIterator(int index) {
		return transitions.listIterator(index);
	}

	@Override
	public List<InterfaceEdge> subList(int fromIndex, int toIndex) {
		return transitions.subList(fromIndex, toIndex);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TestRequirement))
			return false;
		TestRequirement other = (TestRequirement) obj;
		if (transitions.equals(other.getTransitions())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return transitions.toString();
	}

}
