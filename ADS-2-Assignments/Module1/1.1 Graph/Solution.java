import java.util.Scanner;
public class Solution {
	Solution() {
	}
		public static void main(final String[] args) {
			// GraphList list = new GraphList();
			// AdjMatrixGraph matrix = new AdjMatrixGraph();
			Scanner sc = new Scanner(System.in);
			String word = sc.nextLine();
			int m = Integer.parseInt(sc.nextLine());
			int n = Integer.parseInt(sc.nextLine());
			String[] tokens2 = new String[10];
			String[] token2 = new String[10];
			if (m < 2 || n < 2) {
				System.out.println(m + " vertices, " + n + " edges");
				System.out.println("No edges");
			} else 
			{
				switch (word){
				case "List":
					// if (m == 0 || n == 0) {
					// 	System.out.println(m + " vertices, " + n + " edges");
					// 	System.out.println("No edges");
					// 	break;
					// }
					String vertices = sc.nextLine();
					String[] tokens1 = vertices.split(",");
					GraphList list = new GraphList(m);
					for (int i = 0; i < m; i++) {
						list.addVertex(tokens1[i]);
					}
					while(sc.hasNext()){
					String edges = sc.nextLine();
					tokens2 = edges.split(" ");
					for (int i = 0; i < n; i++) {
						list.addEdge(Integer.parseInt(tokens2[0]), Integer.parseInt(tokens2[0]));
					}}
					if (Integer.parseInt(tokens2[0]) == Integer.parseInt(tokens2[1])) {
						return;
					} else {
						System.out.println(list.toString());
					}
				break;

				case "Matrix":
					// if (m == 0 || n == 0) {
					// 	System.out.println(m + " vertices, " + n + " edges");
					// 	System.out.println("No edges");
					// 	break;
					// }
					String vertices1 = sc.nextLine();
					String[] token1 = vertices1.split(",");
					AdjMatrixGraph matrix = new AdjMatrixGraph(m);
					for (int i = 0; i < m; i++) {
						matrix.addVertex(token1[i]);
					}
					while(sc.hasNext()){
					String edges1 = sc.nextLine();
					for (int i = 0; i < n; i++) {
						token2 = edges1.split(" ");
						matrix.addEdge(Integer.parseInt(token2[0]), Integer.parseInt(token2[0]));
					}}
					if (Integer.parseInt(token2[0]) == Integer.parseInt(token2[1])) {
						break;
					} else {
						System.out.println(matrix.toString());
					}
				break;

				default:
				break;
			}
		}
	}
}