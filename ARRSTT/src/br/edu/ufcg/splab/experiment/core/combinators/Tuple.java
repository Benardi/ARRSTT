package br.edu.ufcg.splab.experiment.core.combinators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.edu.ufcg.splab.experiment.core.treatments.InterfaceTreatment;

public class Tuple<T> implements List<InterfaceTreatment<T>>{
	private List<InterfaceTreatment<T>> tuple;
	
	public Tuple() {
		this.tuple = new ArrayList<InterfaceTreatment<T>>();
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
	public Iterator<InterfaceTreatment<T>> iterator() {
		return tuple.iterator();
	}

	@Override
	public Object[] toArray() {
		return tuple.toArray();
	}

	@Override
	public boolean add(InterfaceTreatment<T> e) {
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
	public boolean addAll(Collection<? extends InterfaceTreatment<T>> c) {
		return tuple.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends InterfaceTreatment<T>> c) {
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
	public InterfaceTreatment<T> get(int index) {
		return tuple.get(index);
	}

	@Override
	public InterfaceTreatment<T> set(int index, InterfaceTreatment<T> element) {
		return tuple.set(index, element);
	}

	@Override
	public void add(int index, InterfaceTreatment<T> element) {
		tuple.add(index, element);
	}

	@Override
	public InterfaceTreatment<T> remove(int index) {
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
	public ListIterator<InterfaceTreatment<T>> listIterator() {
		return tuple.listIterator();
	}

	@Override
	public ListIterator<InterfaceTreatment<T>> listIterator(int index) {
		return tuple.listIterator(index);
	}

	@Override
	public List<InterfaceTreatment<T>> subList(int fromIndex, int toIndex) {
		return tuple.subList(fromIndex, toIndex);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return tuple.toArray(a);
	}
	
}