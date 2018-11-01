/**.
 * Class for digraph.
 */
public class Digraph {
    /**.
     * { var_description }
     */
    private static final String
    NEWLINE = System.getProperty("line.separator");
    /**.
     * { var_description }
     */
    private final int v1;
    /**.
     * { var_description }
     */
    private int e;
    /**.
     * { var_description }
     */
    private Bag<Integer>[] adj;
    /**.
     * { var_description }
     */
    private int[] indegree;
    /**.
     * Constructs the object.
     *
     * @param      l     { parameter_description }
     */
    public Digraph(final int l) {
        this.v1 = l;
        this.e = 0;
        indegree = new int[v1];
        adj = (Bag<Integer>[]) new Bag[v1];
        for (int v = 0; v < v1; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity:O(1)
     */
    public int v1() {
        return v1;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity:O(1)
     */
    public int e() {
        return e;
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     * time complexity:O(1)
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= v1) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (v1 - 1));
        }
    }
    /**.
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     * time complexity:O(1)
     */
    public void addEdge(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        e++;
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity:O(1)
     */
    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity:O(1)
     */
    public int outdegree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity:O(1)
     */
    public int indegree(final int v) {
        validateVertex(v);
        return indegree[v];
    }
}
