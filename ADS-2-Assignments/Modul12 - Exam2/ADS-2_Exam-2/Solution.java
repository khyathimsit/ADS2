import java.util.Scanner;
public final class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		EdgeWeightedGraph e = new EdgeWeightedGraph(vertices);
		int edges = sc.nextInt();
        int ver = vertices;
        sc.nextLine();
        for (int i = 0; i < ver; i++) {
        	String[] tokens = sc.nextLine().split(" ");
        	e.addEdge(new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2])));
        }
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
		    System.out.println(e);
			break;

		// case "DirectedPaths":
		// 	// Handle the case of DirectedPaths, where two integers are given.
		// 	// First is the source and second is the destination.
		// 	// If the path exists print the distance between them.
		// 	// Other wise print "No Path Found."
		// 	break;

		// case "ViaPaths":
		// 	// Handle the case of ViaPaths, where three integers are given.
		// 	// First is the source and second is the via is the one where path should pass throuh.
		// 	// third is the destination.
		// 	// If the path exists print the distance between them.
		// 	// Other wise print "No Path Found."
		// 	break;

		default:
			break;
		}

	}
}