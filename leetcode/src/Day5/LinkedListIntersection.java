package Day5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LinkedListIntersection {
	public static boolean doLinkedListsIntersect(Collection<SinglyLinkedList> lists) {
		HashSet<Node> visitedNodes = new HashSet<>();
		for (SinglyLinkedList list : lists) {
			Node current = list.head;
			while (current != null) {
				if (visitedNodes.contains(current)) {
					return true;
				}
				visitedNodes.add(current);
				current = current.next;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Create a map to store the edges of the DAG
		Map<String, String> edges = new HashMap<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			// Split the line on the "->" delimiter
			String[] parts = line.split("->");
			if (parts.length != 2) {
				break;
			}

			// Add the edge to the map
			edges.put(parts[0], parts[1]);
		}

		// Create a list to store the singly linked lists
		List<SinglyLinkedList> lists = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.equals("$"))
				break;
			// Split the line on the "," delimiter
			String[] parts = line.split(",");

			// Create a new singly linked list starting with the first node
			SinglyLinkedList list = new SinglyLinkedList(parts[0]);

			// Add the rest of the nodes to the list
			for (int i = 1; i < parts.length; i++) {
				String current = parts[i];
				String next = edges.get(current);
				while (next != null) {
					list.addNode(next);
					current = next;
					next = edges.get(current);
				}
			}

			lists.add(list);
		}
		// Check if any of the traversals intersect
		boolean intersect = doLinkedListsIntersect(lists);
		System.out.println("The linked lists intersect: " + intersect);

	}
}

class SinglyLinkedList {
	Node head;
	String value;
	SinglyLinkedList next;

	SinglyLinkedList(String value) {
		this.value = value;
	}

	public void addNode(String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
}

class Node {
	String data;
	Node next;

	public Node(String data) {
		this.data = data;
		this.next = null;
	}
}