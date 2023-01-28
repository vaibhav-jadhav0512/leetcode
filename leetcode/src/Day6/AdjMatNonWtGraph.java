package Day6;

import java.util.Scanner;

public class AdjMatNonWtGraph {

	private int vertCount;
	private int edgeCount;
	private int[][] adjMat;

	public AdjMatNonWtGraph(int vertCount) {
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdjMatNonWtGraph g = new AdjMatNonWtGraph(6);
		g.accept(sc);
		g.display();
		sc.close();
	}
}
