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
        Digraph d = new Digraph(n);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          String[] input = line.split(" ");
          d.addEdge(Integer.parseInt(input[0]),
            Integer.parseInt(input[1]));
        }
        DirectedCycle dc = new DirectedCycle(d);
        if (dc.hasCycle()) {
        	System.out.println("Cycle exists.");
        } else {
        	System.out.println("Cycle doesn't exists.");
        }
    }
}
