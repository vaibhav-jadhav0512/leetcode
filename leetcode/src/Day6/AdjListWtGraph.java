package Day6;

import java.util.LinkedList;
import java.util.Scanner;

public class AdjListWtGraph {
	static class Edge {
		private int src;
		private int dest;
		private int weight;

		public Edge() {
			super();
		}

		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return String.format("[%s -> %s (%s)]", src, dest, weight);
		}
	}

	private int vertCount, edgeCount;
	private LinkedList<Edge>[] adjList;

	public AdjListWtGraph(int vertCount) {
		this.vertCount = vertCount;
		adjList = new LinkedList[vertCount];
		edgeCount = 0;
		for (int i = 0; i < vertCount; i++) {
			adjList[i] = new LinkedList<Edge>();
		}
	}

	public void accept(Scanner sc) {
		System.out.println("How many edges do you want?");
		edgeCount = sc.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			System.out.print("Enter edge (src dest): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjList[src].add(new Edge(src, dest, wt));
			adjList[dest].add(new Edge(dest, src, wt)); // for directed graph delete this line
		}

	}

	public void display() {
		for (int i = 0; i < vertCount; i++) {
			System.out.print("vert " + i + " ");
			for (Edge e : adjList[i]) {
				System.out.print(e + " -> ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdjListWtGraph g = new AdjListWtGraph(6);
		g.accept(sc);
		g.display();
		sc.close();
	}
}
