package Day3;

public class DoublyCircularLinkedList {
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

	public DoublyCircularLinkedList() {
		this.head = null;
	}

	public void displayForward() {
		Node trav = head;
		do {
			System.out.println(trav.data);
			trav = trav.next;
		} while (trav != head);
	}

	public void displayReverse() {
		if (head == null)
			return;
		else {
			Node trav = head;
			do {
				trav = trav.prev;
				System.out.println(trav.data);
			} while (trav != head);
		}
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			newNode.next = newNode;
			newNode.prev = newNode;
			head = newNode;
		} else {
			newNode.next = head;
			head.prev.next = newNode;
			newNode.prev = head.prev;
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
				if (trav.next == head)
					break;
				trav = trav.next;
			}
			newNode.next = trav.next;
			newNode.prev = trav;
			trav.next.prev = newNode;
			trav.next = newNode;
		}
	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		Node trav = this.head;
		if (head == null) {
			head = newNode;
			newNode.next = newNode;
			newNode.prev = newNode;
		} else {
			while (trav.next != head)
				trav = trav.next;
			newNode.prev = trav;
			newNode.next = trav.next;
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
			head.prev.next = head.next;
			head.next.prev = head.prev;
			head.prev = null;
			head = head.next;
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
				if (trav.next == head)
					throw new RuntimeException("Invalid position");
				trav = trav.next;
			}
			trav.prev.next = trav.next;
			trav.next.prev = trav.prev;
		}
	}

	public void delLast() {
		if (head == null) {
			throw new RuntimeException("Empty list");
		} else if (head.next == head) {
			head = null;
		} else {
			Node trav = this.head;

			while (trav.next != head) {
				trav = trav.next;
			}
			trav.prev.next = head;
			head.prev = trav.prev;
			trav.prev = null;
			trav.next = null;
		}
	}
	public static void main(String[] args) {
		DoublyCircularLinkedList list = new DoublyCircularLinkedList();
		list.addFirst(2);
		list.addFirst(3);
		list.addAtPos(6, 2);
		list.addLast(7);
		list.addLast(8);
//		list.delFirst();
//		list.delAtPos(5);
		list.delLast();
		list.displayForward();
		list.displayReverse();
	}
}
