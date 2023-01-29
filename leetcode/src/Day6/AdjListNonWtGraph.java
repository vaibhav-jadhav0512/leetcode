package Day6;

import java.util.LinkedList;
import java.util.Scanner;

public class AdjListNonWtGraph {

	private int vertCount, edgeCount;
	private LinkedList<Integer>[] adjList;

	public AdjListNonWtGraph(int vertCount) {
		this.vertCount = vertCount;
		adjList = new LinkedList[vertCount];
		edgeCount = 0;
		for (int i = 0; i < vertCount; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	public void accept(Scanner sc) {
		System.out.println("How many edges do you want?");
		edgeCount = sc.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			System.out.print("Enter edge (src dest): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjList[src].add(dest);
			adjList[dest].add(src); // for directed graph delete this line
		}

	}

	public void display() {
		for (int i = 0; i < vertCount; i++) {
			System.out.print("vert " + i + " ");
			for (int dest : adjList[i]) {
				System.out.print(dest + " -> ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdjListNonWtGraph g = new AdjListNonWtGraph(6);
		g.accept(sc);
		g.display();
		sc.close();
	}
}
