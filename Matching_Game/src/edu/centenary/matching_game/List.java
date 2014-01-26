package edu.centenary.matching_game;


public interface List<E> {
	
	public void add(E t);
	
	public boolean contains (E t);
	
	public E get(int index);
	
	public boolean isEmpty();
	
	public E remove (int index);
	
	public boolean remove( E t);

	public void set(int index, E t);
	
	public int size();
}
