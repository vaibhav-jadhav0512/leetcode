package Day3;


public class SinglyCircularLinkedList {
	static class Node {
		private int data;
		private Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int val) {
			this.data = val;
			this.next = null;
		}
	}

	private Node head;

	public SinglyCircularLinkedList() {
		this.head = null;
	}

	public void display() {
		if (head == null)
			throw new RuntimeException("Empty list");
		Node trav = head;
		do {
			System.out.println(trav.data);
			trav = trav.next;
		} while (trav != head);
	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		Node trav = head;
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			while (trav.next != head)
				trav = trav.next;
			newNode.next = head;
			trav.next = newNode;
		}
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		Node trav = head;
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			while (trav.next != head)
				trav = trav.next;
			newNode.next = head;
			trav.next = newNode;
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
			trav.next = newNode;
		}
	}

	public void delFirst() {
		if (head == null)
			throw new RuntimeException("Empty list");
		else if (head.next == head)
			head = null;
		else {
			Node trav = head;
			while (trav.next != head)
				trav = trav.next;
			head = head.next;
			trav.next = head;
		}
	}
	
	public void delAtPos(int pos) {
		if (pos == 1)
			delFirst();
		else if (head == null || pos < 1) {
			throw new RuntimeException("Empty list");
		} else {
			Node trav = this.head;
			Node temp = null;
			for (int i = 1; i < pos; i++) {
				if (trav.next == head)
					throw new RuntimeException("Invalid position");
				temp = trav;
				trav = trav.next;
			}
			temp.next = trav.next;
		}
	}
	
	public void delAll() {
		head.next=null;
		head=null;
	}
	
	public void delLast() {
		if (head == null) {
			throw new RuntimeException("Empty list");
		} else if (head.next == head) {
			head = null;
		} else {
			Node trav = this.head;
			Node temp = null;

			while (trav.next != head) {
				temp = trav;
				trav = trav.next;
			}
			trav.next=null;
			temp.next = head;
		}
	}

	public static void main(String[] args) {
		SinglyCircularLinkedList list = new SinglyCircularLinkedList();
		list.addLast(20);
		list.addLast(10);
		list.addLast(5);
		list.addAtPos(33, 1);
		list.addFirst(3);
//		list.delFirst();
//		list.delAtPos(3);
//		list.delLast();
		list.display();
	}
}
