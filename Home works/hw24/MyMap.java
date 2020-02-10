package hw24;

import java.util.ArrayList;
import java.util.Comparator;


public class MyMap<K, V> {
	private ArrayList<MyEntry<K, V>> myEntry;

	public MyMap() {
		myEntry = new ArrayList<>();
	}

	public void add(K key, V value){
		for (int i = 0; i < myEntry.size(); i++) {
			if (myEntry.get(i).getKey().equals(key)) {
				myEntry.get(i).setValue(value);
				return;
			}
		}
		myEntry.add(new MyEntry<K, V>(key, value));		
	}

	public void removeKey(K key) {
		for (int i = 0; i < myEntry.size(); i++) {
			if (myEntry.get(i).getKey().equals(key)) {
				myEntry.remove(i);
			}
		}
	}

	public void removeValue(V value) {
		for (int i = 0; i < myEntry.size(); i++) {
			if (myEntry.get(i).getValue().equals(value)) {
				myEntry.remove(i);
			}
		}
	}

	public void printAllKeys() {
		for (int i = 0; i < myEntry.size(); i++) {
			System.out.println("key - " + myEntry.get(i).getKey());
		}
	}

	public void printAllValue() {
		for (int i = 0; i < myEntry.size(); i++) {
			System.out.println("value - " + myEntry.get(i).getValue());
		}
	}

	public void printMap() {
		System.out.println(myEntry);
	}
	
	public void sort(Comparator<? super MyEntry <K,V>> c ) {
		myEntry.sort(c);
	}
}
