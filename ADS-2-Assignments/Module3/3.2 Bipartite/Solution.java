/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        Graph g = new Graph(n);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          String[] input = line.split(" ");
          g.addEdge(Integer.parseInt(input[0]),
            Integer.parseInt(input[1]));
        }
        DirectedCycle dc = new DirectedCycle(g);
        if (dc.isBipartite()) {
        	System.out.println("Graph is bipartite");
        } else {
        	System.out.println("Graph is not a bipartite");
        }
    }
}
