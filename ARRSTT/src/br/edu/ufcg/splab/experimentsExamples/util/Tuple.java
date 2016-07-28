package br.edu.ufcg.splab.experimentsExamples.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * This class works exactly like a list.
 * We should review this.
 *
 * @param <T>
 */
public class Tuple<T> implements List<T>{
	private List<T> tuple;
	
	public Tuple() {
		this.tuple = new ArrayList<T>();
	}
	
	@Override
	public int size() {
		return tuple.size();
	}

	@Override
	public boolean isEmpty() {
		return tuple.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return tuple.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return tuple.iterator();
	}

	@Override
	public Object[] toArray() {
		return tuple.toArray();
	}

	@Override
	public boolean add(T e) {
		return tuple.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return tuple.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return tuple.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return tuple.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return tuple.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return tuple.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return tuple.retainAll(c);
	}

	@Override
	public void clear() {
		tuple.clear();
	}

	@Override
	public T get(int index) {
		return tuple.get(index);
	}

	@Override
	public T set(int index, T element) {
		return tuple.set(index, element);
	}

	@Override
	public void add(int index, T element) {
		tuple.add(index, element);
	}

	@Override
	public T remove(int index) {
		return tuple.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return tuple.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return tuple.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return tuple.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return tuple.listIterator(index);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return tuple.subList(fromIndex, toIndex);
	}

	@Override
	public <V> V[] toArray(V[] a) {
		return tuple.toArray(a);
	}
}