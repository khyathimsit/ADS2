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
        int vertices = Integer.parseInt(sc.nextLine());
        Digraph dg = new Digraph(vertices);
        Digraph dg1 = new Digraph(vertices);
        //int edges = 0;
        String[] tokens;
        int ver = vertices;
        while (ver > 0) {
            tokens = sc.nextLine().split(" ");
            if (tokens.length >= 2) {
                for (int i = 1; i < tokens.length; i++) {
                    dg.addEdge(Integer.parseInt(tokens[0]),
                                Integer.parseInt(tokens[i]));
                    dg1.addEdge(Integer.parseInt(tokens[0]),
                                Integer.parseInt(tokens[i]));
                // int e = dg.indegree(i);
                // edges += e;
                }
            } else {
                for (int j = 0; j < vertices; j++) {
                    if (j != Integer.parseInt(tokens[0])) {
                        dg1.addEdge(Integer.parseInt(tokens[0]), j);
                    }
                }
            }
            ver--;
        }
        System.out.println(dg);
        PageRank pr = new PageRank(dg1);
        //System.out.println(pr.toString());
    }
}

