/**.
 * Class for breadth first search.
 */
public class BreadthFirstSearch {
    /**.
     * { var_description }
     */
    private static final int INFINITY = Integer.MAX_VALUE;
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
    private int[] distTo;
    /**.
     * Constructs the object.
     *
     * @param      g     { parameter_description }
     * @param      s     { parameter_description }
     */
    public BreadthFirstSearch(final Digraph g, final int s) {
        marked = new boolean[g.V()];
        distTo = new int[g.V()];
        edgeTo = new int[g.V()];
        for (int v = 0; v < g.V(); v++) {
            distTo[v] = INFINITY;
        }
        validateVertex(s);
        bfs(g, s);
    }
    /**.
     * { function_description }
     *
     * @param      g     { parameter_description }
     * @param      s     { parameter_description }
     */
    private void bfs(final Digraph g, final int s) {
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
    /**.
     * Determines if it has path to.
     *
     * @param      v     { parameter_description }
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {
        validateVertex(v);
        return marked[v];
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int distTo(final int v) {
        validateVertex(v);
        return distTo[v];
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> pathTo(final int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(x);
        return path;
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int v1 = marked.length;
        if (v < 0 || v >= v1) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (v1 - 1));
        }
    }
    /**.
     * { function_description }
     *
     * @param      vertices  The vertices
     */
    private void validateVertices(final Iterable<Integer> vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int v1 = marked.length;
        for (int v : vertices) {
            if (v < 0 || v >= v1) {
                throw new IllegalArgumentException(
                    "vertex " + v + " is not between 0 and " + (v1 - 1));
            }
        }
    }
}
