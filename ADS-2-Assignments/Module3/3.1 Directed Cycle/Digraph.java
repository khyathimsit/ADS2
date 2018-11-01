/**.
 * { item_description }
 */
import java.util.NoSuchElementException;
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
    private final int V;
    /**.
     * { var_description }
     */
    private int E;
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
     * @param      V     { parameter_description }
     */
    public Digraph(final int V) {
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
   
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity:O(1)
     */
    public int V() {
        return V;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity:O(1)
     */
    public int E() {
        return E;
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     * time complexity:O(1)
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (V-1));
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
        E++;
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
