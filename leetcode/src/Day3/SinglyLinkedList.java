package Day3;

public class SinglyLinkedList {
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

	public SinglyLinkedList() {
		this.head = null;
	}

	public void display() {
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
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
			trav.next = newNode;
		}
	}

	public void delFirst() {
		if (head == null)
			throw new RuntimeException("List is empty");
		head = head.next;
	}

	public void delAll() {
		head = null;
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
				if (trav.next == null)
					throw new RuntimeException("Invalid position");
				temp = trav;
				trav = trav.next;
			}
			temp.next = trav.next;
		}
	}

	public void delLast() {
		if (head == null) {
			throw new RuntimeException("Empty list");
		} else if (head.next == null) {
			head = null;
		} else {
			Node trav = this.head;
			Node temp = null;

			while (trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			temp.next = null;
		}
	}

	public SinglyLinkedList sort(SinglyLinkedList list) {
		for (Node i = head; i.next != null; i = i.next) {
			for (Node j = i.next; j != null; j = j.next) {
				if (i.data > j.data) {
					int temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
			}
		}
		return list;
	}

	public SinglyLinkedList reverse(SinglyLinkedList list) {
		Node oldHead = head;
		head = null;
		Node temp = null;
		while (oldHead != null) {
			temp = oldHead;
			oldHead = oldHead.next;
			temp.next = head;
			head = temp;
		}
		return list;
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(11);
		list.addLast(21);
		list.addAtPos(100, 3);
		list.addLast(27);
//		list.delFirst();
//		list.delAll();
//		list.delAtPos(4);
//		list.delLast();
//		list = list.sort(list);
		list.reverse(list);
		list.display();

	}
}
