package Day7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphBFSDFS {
	private int vertCount;
	private int edgeCount;
	private int[][] adjMat;

	public GraphBFSDFS(int vertCount) {
		edgeCount = 0;
		this.vertCount = vertCount;
		adjMat = new int[vertCount][vertCount];
		for (int i = 0; i < vertCount; i++)
			for (int j = 0; j < vertCount; j++)
				adjMat[i][j] = 0;
	}

	public void display() {
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++)
				System.out.print(adjMat[i][j] + "\t");
			System.out.println();
		}
	}

	public void accept(Scanner sc) {
		System.out.println("How many edges do you want?");
		edgeCount = sc.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			System.out.print("Enter edge (src dest): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjMat[src][dest] = 1;
			adjMat[dest][src] = 1; // delete this line for directed line
		}
	}

	public void bfsTraversal(int start) {
		System.out.print("BFS: ");
		boolean[] marked = new boolean[vertCount];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		marked[start] = true;
		while (!q.isEmpty()) {
			int trav = q.poll();
			System.out.print(trav + ", ");
			for (int dest = 0; dest < vertCount; dest++) {
				if (adjMat[trav][dest] != 0 && !marked[dest]) {
					q.offer(dest);
					marked[dest] = true;
				}
			}
		}
		System.out.println();
	}

	public void bfsSpanningTree(int start) {
		System.out.println("BFS spanning tree: ");
		boolean[] marked = new boolean[vertCount];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		marked[start] = true;
		while (!q.isEmpty()) {
			int trav = q.poll();
			for (int dest = 0; dest < vertCount; dest++) {
				if (adjMat[trav][dest] != 0 && !marked[dest]) {
					q.offer(dest);
					marked[dest] = true;
					System.out.println(trav + "->" + dest);
				}
			}
		}
	}

	public void dfsTraversal(int start) {
		System.out.print("DFS: ");
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<Integer>();
		s.push(start);
		marked[start] = true;
		while (!s.isEmpty()) {
			int trav = s.pop();
			System.out.print(trav + ", ");
			for (int dest = 0; dest < vertCount; dest++) {
				if (adjMat[trav][dest] != 0 && !marked[dest]) {
					s.push(dest);
					marked[dest] = true;
				}
			}
		}
		System.out.println();
	}

	public void dfsSpanningTree(int root) {
		System.out.println("DFS Spanning tree: ");
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<Integer>();
		s.push(root);
		marked[root] = true;
		while (!s.isEmpty()) {
			int trav = s.pop();
			for (int dest = 0; dest < vertCount; dest++) {
				if (adjMat[trav][dest] != 0 && !marked[dest]) {
					s.push(dest);
					marked[dest] = true;
					System.out.println(trav + " -> " + dest);
				}
			}
		}
		System.out.println();
	}

	public boolean isConnected() {
		int start = 0, counter = 0;
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<Integer>();
		s.push(start);
		marked[start] = true;
		counter++;
		while (!s.isEmpty()) {
			int trav = s.pop();
			System.out.print(trav + ", ");
			for (int dest = 0; dest < vertCount; dest++) {
				if (adjMat[trav][dest] != 0 && !marked[dest]) {
					s.push(dest);
					marked[dest] = true;
					counter++;
					if (counter == vertCount)
						return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GraphBFSDFS g = new GraphBFSDFS(6);
		g.accept(sc);
		g.display();
		g.bfsTraversal(0);
		g.dfsTraversal(0);
		System.out.println(g.isConnected());
		g.dfsSpanningTree(0);
		g.bfsSpanningTree(0);
		sc.close();
	}
}
