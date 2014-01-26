package edu.centenary.matching_game;

public class ArrayList<E> implements List<E> {
	
	// Data members
	private int size;
	private E[] data;
	
	// Constructor
	public ArrayList(){
		size = 0;
		data = (E[]) (new Object[1]);
	}

	
	// Other Methods
	public void add(E t) {
		if (size == data.length) {
			resize();
		}
		data[size] = t;
		size++;
	}

	
	public boolean contains(E t) {
		for (int i = 0; i < size; i++){
			if (data[i].equals(t)){
				return true;
			}
		}
		return false;
	}

	
	public E get(int index) {
		return data[index];
	}

	
	public boolean isEmpty() { 
		return size == 0;
	}

	
	public E remove(int index) {
		E temp = data[index];
		for (int i = index; i < size - 1; i ++) {
			data[i] = data[i + 1];
		}
		size--;
		return temp;
	}

	
	public boolean remove(E t) {
		for (int i = 0; i < size; i++){
			if (data[i].equals(t)){
				for(int k = i;k< size - 1; k++) {
					data[k] = data[k+1];
				}
				size--;
				return true;
				}
			}
		return false;
			}
				
			
	
	public void set(int index, E t) {
		data[index] = t;
	}

	
	public int size() {
		return size;
	}
	
	protected void resize() {
		E[] temp = (E[])(new Object[size * 2]);
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}


	public void shuffle() {
		for (int i = size - 1; i> 0; i--) {
			swap(i, (int)(Math.random() * (i + 1)));
		}
	}

	protected void swap(int i, int j) {
		E temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
}
