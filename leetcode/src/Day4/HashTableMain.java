package Day4;

import java.util.LinkedList;

public class HashTableMain {
	public static void main(String[] args) {
		HashTable table = new HashTable();
		table.put(1, "Vaibhav");
		table.put(2, "John");
		table.put(32, "Donald");
		table.put(62, "Ronaldo");
	}

}

class HashTable {
	static class Pair {
		private int key; // rollno
		private String value; // name

		public Pair(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private static final int SLOTS = 100;
	private LinkedList<Pair> table[];

	public HashTable() {
		table = new LinkedList[SLOTS];
		for (int i = 0; i < SLOTS; i++) {
			table[i] = new LinkedList<>();

		}
	}

	public int hash(int key) {
		return key % SLOTS;
	}

	public void put(int key, String value) {
		int slot = hash(key);
		LinkedList<Pair> bucket = table[SLOTS - 1];
		for (Pair pair : bucket) {
			if (key == pair.key) {
				pair.value = value;
				return;
			}
		}
		Pair pair = new Pair(key, value);
		bucket.add(pair);
	}

	public String get(int key) {
		int slot = hash(key);
		LinkedList<Pair> bucket = table[slot];
		for (Pair pair : bucket) {
			if (key == pair.key)
				return pair.value;
		}
		return null;
	}
}