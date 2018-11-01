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
    private Stack<Integer> cycle;
    /**.
     * Constructs the object.
     *
     * @param      G     { parameter_description }
     */
    public DirectedCycle(final Digraph G) {
        marked  = new boolean[G.v1()];
        onStack = new boolean[G.v1()];
        edgeTo  = new int[G.v1()];
        for (int v = 0; v < G.v1(); v++) {
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
     * time complexity : no of edges + vertices
     */
    private void dfs(final Digraph G, final int v) {
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
                //assert check();
            }
        }
        onStack[v] = false;
    }
    /**.
     * Determines if it has cycle.
     *
     * @return     True if has cycle, False otherwise.
     * time complexity : O(1)
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity : O(1)
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    // /**.
    //  * { function_description }
    //  *
    //  * @return     { description_of_the_return_value }
    //  */
    // private boolean check() {
    //     if (hasCycle()) {
    //         int first = -1;
    //         int last = -1;
    //         for (int v : cycle()) {
    //             if (first == -1) {
    //                 first = v;
    //                 last = v;
    //             }
    //         }
    //         if (first != last) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
