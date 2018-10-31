/**.
 * Class for graph.
 */
public class Graph {
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
     * Constructs the object.
     *
     * @param      V     { parameter_description }
     */
    public Graph(final int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**.
     * Constructs the object.
     *
     * @param      V     { parameter_description }
     * @param      E     { parameter_description }
     */
    public Graph(final int V, final int E) {
        this(V);
        for (int i = 0; i < E; i++) {
            int v = (int) (Math.random() * V);
            int w = (int) (Math.random() * V);
            addEdge(v, w);
        }
    }
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
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
