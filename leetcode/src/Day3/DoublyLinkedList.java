package Day3;

public class DoublyLinkedList {

	static class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node() {
			this.data = 0;
			this.next = null;
			this.prev = null;
		}

		public Node(int val) {
			this.data = val;
			this.next = null;
			this.prev = null;
		}
	}

	private Node head;

	public DoublyLinkedList() {
		this.head = null;
	}

	public void displayForward() {
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}

	public void displayReverse() {
		if (head == null)
			return;
		Node trav = head;
		while (trav.next != null) {
			trav = trav.next;
		}
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.prev;
		}
	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		Node trav = this.head;
		if (head == null)
			head = newNode;
		else {
			while (trav.next != null)
				trav = trav.next;
			trav.next = newNode;
			newNode.prev = trav;
		}
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public void addAtPos(int val, int pos) {
		if (head == null || pos <= 1)
			addFirst(val);
		else {
			Node newNode = new Node(val);
			Node trav = this.head;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			newNode.next = trav.next;
			newNode.prev = trav;
			trav.next.prev = newNode;
			trav.next = newNode;
		}
	}

	public void delFirst() {
		if (head == null)
			throw new RuntimeException("List is empty");
		if (head.next == null)
			head = null;
		else {
			head = head.next;
			head.prev = null;
		}
	}

	public void delAtPos(int pos) {
		if (pos == 1)
			delFirst();
		else if (head == null || pos < 1) {
			throw new RuntimeException("Empty list");
		} else {
			Node trav = this.head;
			for (int i = 1; i < pos; i++) {
				if (trav.next == null)
					throw new RuntimeException("Invalid position");
				trav = trav.next;
			}
				trav.prev.next = trav.next;
				if (trav.next != null)
				trav.next.prev = trav.prev;
		}
	}

	public void delLast() {
		if (head == null) {
			throw new RuntimeException("Empty list");
		} else if (head.next == null) {
			head = null;
		} else {
			Node trav = this.head;

			while (trav.next != null) {
				trav = trav.next;
			}
			trav.prev.next = null;
			trav.prev = null;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addFirst(1);
//		list.addAtPos(4, 4);
//		list.delFirst();
//		list.delAtPos(4);
		list.delLast();
		list.displayForward();
		list.displayReverse();
	}
}
