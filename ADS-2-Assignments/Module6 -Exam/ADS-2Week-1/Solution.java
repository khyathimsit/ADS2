/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public class Solution {
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
        int vertices = sc.nextInt();
        Digraph dg = new Digraph(vertices);
        PageRank pr = new PageRank(dg);
        int edges = 0;
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(" ");
            for (int i = 1; i < tokens.length; i++) {
                dg.addEdge(Integer.parseInt(tokens[0]),
                 Integer.parseInt(tokens[i]));
                int e = dg.indegree(i);
                edges += e;
            }
        }
        System.out.println(dg.toString());
        System.out.println(pr.toString());
    }
}
