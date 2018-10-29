import java.util.Scanner;
public class Solution {
	Solution() {
	}
		public static void main(final String[] args) {
			// GraphList list = new GraphList();
			// AdjMatrixGraph matrix = new AdjMatrixGraph();
			Scanner sc = new Scanner(System.in);
			String word = sc.nextLine();
			int m = sc.nextInt();
			int n = sc.nextInt();
			while(sc.hasNext()) {
				switch (word){
				case "List":
					if (m == 0 || n == 0) {
						System.out.println(m + " vertices, " + n + " edges");
						System.out.println("No edges");
					}
					String vertices = sc.nextLine();
					String[] tokens1 = vertices.split(",");
					GraphList list = new GraphList(m);
					for (int i = 0; i < m; i++) {
						list.addVertex(tokens1[i]);
					}
					String edges = sc.nextLine();
					String[] tokens2 = edges.split(" ");
					for (int i = 0; i < n; i++) {
						list.addEdge(Integer.parseInt(tokens2[0]), Integer.parseInt(tokens2[0]));
					}
					if (Integer.parseInt(tokens2[0]) == Integer.parseInt(tokens2[1])) {
						break;
					} else {
						System.out.println(list.toString());
					}
				break;

				default:
				break;
			}
		}
	}
}