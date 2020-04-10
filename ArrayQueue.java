// Abstracted from University of Washington lecture notes

import java.util.*;

public class ArrayQueue<T> implements Queue<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private int cap, current, front, back;		
	private T[] arr;

	
	public ArrayQueue () {
		cap = DEFAULT_CAPACITY;
		arr = (T[]) new Object[DEFAULT_CAPACITY];
		back = -1; front = 0;
	}

	public boolean empty() {
		return current == 0;
	}

	public void enqueue (T value) {
		if (isFull()){
			grow_array();
		}
		back++;
		arr[back%cap] = value;
		current++;
	}

	public T getFront() {
		if (empty()) {
			throw new QueueException();
		} else {
			return arr[front%cap];
		}
	}

	private void grow_array() {
		T[] tempArr = (T[]) new Object[2*cap];

		for(int i = front; i <= back; i ++) {
			tempArr[i-front] = arr[i%cap];
		}

		arr = tempArr;
		front = 0;
		back = current-1;
		cap *= 2;
	}
	
	public T dequeue() {
		T e = getFront();
		arr[front%cap] = null;
		front++;
		current--;
		return e;
	}

	public boolean isFull() {
		return current == cap;
	}


}