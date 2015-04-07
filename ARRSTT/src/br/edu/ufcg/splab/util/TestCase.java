package br.edu.ufcg.splab.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.edu.ufcg.splab.core.InterfaceEdge;

public class TestCase implements List{
	
	List<InterfaceEdge> tCase;
	
	
	public TestCase(List<InterfaceEdge> tCase){
		this.tCase = tCase;
	}
	
	public TestCase(){
		this(new ArrayList<InterfaceEdge>());
	}
	
	public List<InterfaceEdge> getTestCase(){
		return tCase;
	}
	
	public TestCase getCopy(){
		List<InterfaceEdge> copyList = new ArrayList<InterfaceEdge>(tCase);
		return new TestCase(copyList);
	}

	
	
	// The Forwarding part
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
	public Iterator iterator() {
		return tCase.iterator();
	}

	@Override
	public Object[] toArray() { 
		return tCase.toArray();
	}

	@Override
	public Object[] toArray(Object[] a) {	 
		return tCase.toArray(a);
	}

	@Override
	public boolean add(Object e) {
		return tCase.add((InterfaceEdge) e);
	}

	@Override
	public boolean remove(Object o) {	 
		return tCase.remove(o);
	}

	@Override
	public boolean containsAll(Collection c) {	 
		return tCase.containsAll(c);
	}

	@Override
	public boolean addAll(Collection c) {	 
		return tCase.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection c) {		 
		return tCase.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection c) {		 
		return tCase.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection c) {		 
		return tCase.retainAll(c);
	}

	@Override
	public void clear() {		 
		tCase.clear();
	}

	@Override
	public Object get(int index) {		 
		return tCase.get(index);
	}

	@Override
	public Object set(int index, Object element) {		 
		return tCase.set(index, (InterfaceEdge) element);
	}

	@Override
	public void add(int index, Object element) {
		tCase.add(index, (InterfaceEdge) element);
		
	}

	@Override
	public Object remove(int index) {		 
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
	public ListIterator listIterator() {		 
		return tCase.listIterator();
	}

	@Override
	public ListIterator listIterator(int index) {		 
		return tCase.listIterator(index);
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		 
		return tCase.subList(fromIndex, toIndex);
	}

}
