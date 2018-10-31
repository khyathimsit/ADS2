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
    /**.
     * { var_description }
     */
    private boolean isBipartite = false;
    /**.
     * { var_description }
     */
    private Stack<Integer> cycle;
    /**.
     * Constructs the object.
     *
     * @param      g     { parameter_description }
     */
    public DirectedCycle(final Graph g) {
        isBipartite = true;
        marked  = new boolean[g.v1()];
        onStack = new boolean[g.v1()];
        edgeTo  = new int[g.v1()];
        for (int v = 0; v < g.v1(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(g, v);
            }
        }
    }
    /**.
     * { function_description }
     *
     * @param      g     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final Graph g, final int v) {

        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
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
