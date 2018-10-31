/**.
 * Class for graph.
 */
public class Graph {
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
     * Constructs the object.
     *
     * @param      v1     { parameter_description }
     */
    public Graph(final int v1) {
        this.v1 = v1;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v1];
        for (int v = 0; v < v1; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**.
     * Constructs the object.
     *
     * @param      v1    { parameter_description }
     * @param      e     { parameter_description }
     */
    public Graph(final int v1, final int e) {
        this(v1);
        for (int i = 0; i < e; i++) {
            int v = (int) (Math.random() * v1);
            int w = (int) (Math.random() * v1);
            addEdge(v, w);
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int v1() {
        return v1;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int e() {
        return e;
    }
    /**.
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        e++;
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
        String newline = System.getProperty("line.separator");
        s.append(v1 + " vertices, " + e + " edges " + newline);
        for (int v = 0; v < v1; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(newline);
        }
        return s.toString();
    }
}

