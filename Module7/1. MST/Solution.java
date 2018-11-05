/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
 */
final class Solution {
    /**
     * @brief [brief description]
     * @details [long description]
     */
    private Solution() { }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(N)
     * @param args [description]
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int vertices = Integer.parseInt(s.nextLine());
        int testcases = Integer.parseInt(s.nextLine());
        EdgeWeightedGraph edge = new EdgeWeightedGraph(vertices);
        for (int i = 0; i < testcases; i++) {
            String[] inp = s.nextLine().split(" ");
            Edge e = new Edge(Integer.parseInt(inp[0]),
                Integer.parseInt(inp[1]),
                Double.parseDouble(inp[2]));
            edge.addEdge(e);
        }
        //LazyPrimMST p =  new LazyPrimMST(edge);
        Kruskals k = new Kruskals(edge);
        System.out.format("%.5f", k.weight());
    }
}

