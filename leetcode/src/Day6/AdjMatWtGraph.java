package Day6;

import java.util.Scanner;

public class AdjMatWtGraph {
	public static final int INFINITY = Integer.MAX_VALUE;

	private int vertCount;
	private int edgeCount;
	private int[][] adjMat;

	public AdjMatWtGraph(int vertCount) {
		edgeCount = 0;
		this.vertCount = vertCount;
		adjMat = new int[vertCount][vertCount];
		for (int i = 0; i < vertCount; i++)
			for (int j = 0; j < vertCount; j++)
				adjMat[i][j] = INFINITY;
	}

	public void display() {
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++) {
				if (adjMat[i][j] == INFINITY)
					System.out.print("X\t");
				else
				System.out.print(adjMat[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void accept(Scanner sc) {
		System.out.println("How many edges do you want?");
		edgeCount = sc.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			System.out.print("Enter edge (src dest weight): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int weight = sc.nextInt();
			adjMat[src][dest] = weight;
			adjMat[dest][src] = weight; // delete this line for directed line
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdjMatWtGraph g = new AdjMatWtGraph(6);
		g.accept(sc);
		g.display();
		sc.close();
	}

}
