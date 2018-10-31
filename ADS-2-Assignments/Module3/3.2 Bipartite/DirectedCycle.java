/**.
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**.
     * { var_description }
     */
    private boolean[] marked;
    /**.
     * { var_description }
     */
    private int[] edgeTo;
    /**.
     * { var_description }
     */
    private boolean[] onStack;
    private boolean isBipartite = false;
    /**.
     * { var_description }
     */
    private Stack<Integer> cycle;
    /**.
     * Constructs the object.
     *
     * @param      G     { parameter_description }
     */
    public DirectedCycle(final Graph G) {
        isBipartite = true;
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(G, v);
            }
        }
    }
    /**.
     * { function_description }
     *
     * @param      G     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final Graph G, final int v) {

        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }
    /**.
     * Determines if it has cycle.
     *
     * @return     True if has cycle, False otherwise.
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    public boolean isBipartite() {
        return isBipartite;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check() {
        if (hasCycle()) {
            int first = -1;
            int last = -1;
            for (int v : cycle()) {
                if (first == -1) {
                    first = v;
                    last = v;
                }
            }
            if (first != last) {
                return false;
            }
        }
        return true;
    }
}
