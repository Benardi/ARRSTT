package br.edu.ufcg.splab.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestSuite implements List<TestCase>{
	
	private List<TestCase> tSuite;
	
	
	public TestSuite(List<TestCase> tSuite){
		this.tSuite = tSuite;
	}
	
	public TestSuite(TestSuite tSuiteCopy){
		this.tSuite = tSuiteCopy.getTestSuiteCopy();
	}
	
	public TestSuite(){
		this(new ArrayList<TestCase>());
	}
	
	public List<TestCase> getTestSuite(){
		return tSuite;
	}
	
	public List<TestCase> getTestSuiteCopy(){
		return new ArrayList<TestCase>(tSuite);
	}
	
	public TestSuite getCopy(){
		List<TestCase> copyList = new ArrayList<TestCase>(tSuite);
		return new TestSuite(copyList);
	}
	
	@Override
	public int size() {
		return tSuite.size();
	}

	@Override
	public boolean isEmpty() {	 
		return tSuite.isEmpty();
	}

	@Override
	public boolean contains(Object o) {	 
		return tSuite.contains(o);
	}

	@Override
	public Iterator<TestCase> iterator() {	 
		return tSuite.iterator();
	}

	@Override
	public Object[] toArray() {	 
		return tSuite.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {	 
		return tSuite.toArray(a);
	}

	@Override
	public boolean add(TestCase e) {	 
		return tSuite.add(e);
	}

	@Override
	public boolean remove(Object o) {
		 
		return tSuite.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {	 
		return tSuite.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends TestCase> c) {	 
		return tSuite.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends TestCase> c) {	 
		return tSuite.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {	 
		return tSuite.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {	 
		return tSuite.retainAll(c);
	}

	@Override
	public void clear() {	 
		tSuite.clear();
	}

	@Override
	public TestCase get(int index) {	 
		return tSuite.get(index);
	}

	@Override
	public TestCase set(int index, TestCase element) {	 
		return tSuite.set(index, element);
	}

	@Override
	public void add(int index, TestCase element) {	 
		tSuite.add(index, element);
	}

	@Override
	public TestCase remove(int index) {	 
		return tSuite.remove(index);
	}

	@Override
	public int indexOf(Object o) {	 
		return tSuite.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {	 
		return tSuite.lastIndexOf(o);
	}

	@Override
	public ListIterator<TestCase> listIterator() {	 
		return tSuite.listIterator();
	}

	@Override
	public ListIterator<TestCase> listIterator(int index) {	 
		return tSuite.listIterator(index);
	}

	@Override
	public List<TestCase> subList(int fromIndex, int toIndex) {
		return tSuite.subList(fromIndex, toIndex);
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof TestSuite)) return false;
		TestSuite other = (TestSuite) obj;
		if(tSuite.equals(other.getTestSuite())){
			return true;
		} else{
			return false;
		}
	}
	
	@Override
	public String toString(){
		String output = "";
		
		for (TestCase tCase : tSuite) {
			tCase.toString();
			output += tCase.toString() + "\n";
			output += "----------------------------------------------------" + "\n";
		}
		
		return output;
	}
}
