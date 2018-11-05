/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    // time complexity for the main method is E.
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        sc.nextLine();
        EdgeWeightedGraph edge = new EdgeWeightedGraph(vertices);
        for (int i = 0; i < edges; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            edge.addEdge(new Edge(Integer.parseInt(tokens[0]),
             Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2])));
        }
        KruskalMST k = new KruskalMST(edge);
        double res = k.weight();
        System.out.format("%.5f", res);
    }
}