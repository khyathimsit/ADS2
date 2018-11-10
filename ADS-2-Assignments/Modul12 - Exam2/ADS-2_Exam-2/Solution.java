import java.util.Scanner;
public final class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		EdgeWeightedGraph e = new EdgeWeightedGraph(vertices);
		int edges = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < edges; i++) {
        	String[] tokens = sc.nextLine().split(" ");
        	e.addEdge(new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2])));
        }
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
		    System.out.println(e);
			break;

		case "DirectedPaths":
			String[] tokens = sc.nextLine().split(" ");
			Dijkstra d = new Dijkstra(e, Integer.parseInt(tokens[0]));
			double distance = d.distTo(Integer.parseInt(tokens[1]));
			if (!d.hasPathTo(Integer.parseInt(tokens[0]))) {
            	System.out.println("No Path Found.");
            } else {
            	System.out.println(distance);
            }
			break;

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
