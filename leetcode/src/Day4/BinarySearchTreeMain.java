package Day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinarySearchTree {
	static class Node {
		private int data;
		private Node left, right;

		public Node() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		public Node(int val) {
			this.data = val;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void add(int val) {
		Node newNode = new Node(val);
		if (root == null) {
			root = newNode;
		} else {
			Node trav = root;
			while (true) {
				if (val < trav.data) {
					if (trav.left != null)
						trav = trav.left;
					else {
						root.left = newNode;
						break;
					}
				} else {
					if (trav.right != null)
						trav = trav.right;
					else {
						trav.right = newNode;
						break;
					}
				}
			}
		}
	}

	public void printWORecPreOrder() {
		Node trav = root;
		Stack<Node> s = new Stack<>();
		while (trav != null && !s.isEmpty()) {
			while (trav != null) {
				System.out.println(trav.data);
				if (trav.right != null) {
					s.push(trav.right);
				}
				trav = trav.left;
			}
			if (!s.isEmpty())
				trav = s.pop();
		}
	}

	public void printWORecInOrder() {
		Node trav = root;
		Stack<Node> s = new Stack<>();
		while (trav != null && !s.isEmpty()) {
			while (trav != null) {
				System.out.println(trav.data);
				s.push(trav.right);
				trav = trav.left;
			}
		}
		if (!s.isEmpty()) {
			trav = s.pop();
			System.out.println(trav.data);
			trav = trav.right;
		}
	}
	public void preOrder(Node trav) {
		if (trav == null)
			return;
		System.out.println(trav.data);
		preOrder(trav.left);
		preOrder(trav.right);
	}

	public void inOrder(Node trav) {
		if (trav == null)
			return;
		preOrder(trav.left);
		System.out.println(trav.data);
		preOrder(trav.right);
	}

	public void postOrder(Node trav) {
		if (trav == null)
			return;
		preOrder(trav.left);
		preOrder(trav.right);
		System.out.println(trav.data);
	}

	public void display() {
		preOrder(root);
		inOrder(root);
		postOrder(root);
	}

	public void deleteAll(Node trav) {
		if (trav == null)
			return;
		deleteAll(trav.left);
		deleteAll(trav.right);
		trav.left = null;
		trav.right = null;
		trav = null;
	}

	public void deleteAlls() {
		deleteAll(root);
		root = null;
	}

	public int height(Node trav) {
		if (trav == null)
			return -1;
		int hl = (height(trav.left));
		int hr = (height(trav.right));
		return hl > hr ? hl + 1 : hr + 1;
	}

	public int getHeight() {
		return height(root);
	}

	public Node bfs(int key) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node trav = q.poll();
			if (key == trav.data)
				return trav;
			if (trav.left != null)
				q.offer(trav.left);
			if (trav.right != null)
				q.offer(trav.right);
		}
		return null;
	}

	public Node dfs(int key) {
		Stack<Node> q = new Stack<>();
		q.push(root);
		while (!q.isEmpty()) {
			Node trav = q.pop();
			if (key == trav.data)
				return trav;
			if (trav.right != null)
				q.push(trav.right);
			if (trav.left != null)
				q.push(trav.left);
		}
		return null;
	}
}

public class BinarySearchTreeMain {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(50);
		tree.add(30);
		tree.add(10);
		tree.add(90);
		tree.add(100);
		tree.add(10);
//		tree.deleteAlls();
		tree.display();
		System.out.println(tree.bfs(30));
//		System.out.println(tree.getHeight());
	}
}
