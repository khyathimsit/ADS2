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
    // /**.
    //  * Constructs the object.
    //  *
    //  * @param      in    { parameter_description }
    //  */
    // public Digraph(final In in) {
    //     this.V = in.readInt();
    //     indegree = new int[V];
    //     adj = (Bag<Integer>[]) new Bag[V];
    //     for (int v = 0; v < V; v++) {
    //         adj[v] = new Bag<Integer>();
    //     }
    //     int E = in.readInt();
    //     for (int i = 0; i < E; i++) {
    //         int v = in.readInt();
    //         int w = in.readInt();
    //         addEdge(v, w); 
    //     }
    // }
    // /**.
    //  * Constructs the object.
    //  *
    //  * @param      G     { parameter_description }
    //  */
    // public Digraph(final Digraph G) {
    //     this(G.V());
    //     this.E = G.E();
    //     for (int v = 0; v < V; v++) {
    //         this.indegree[v] = G.indegree(v);
    //     }
    //     for (int v = 0; v < G.V(); v++) {
    //         Stack<Integer> reverse = new Stack<Integer>();
    //         for (int w : G.adj[v]) {
    //             reverse.push(w);
    //         }
    //         for (int w : reverse) {
    //             adj[v].add(w);
    //         }
    //     }
    // }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int V() {
        return V;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int E() {
        return E;
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
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
     */
    public int indegree(final int v) {
        validateVertex(v);
        return indegree[v];
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
