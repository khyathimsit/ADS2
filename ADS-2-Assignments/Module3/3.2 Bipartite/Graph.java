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
     * @param      l     { parameter_description }
     */
    public Graph(final int l) {
        this.v1 = l;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v1];
        for (int v = 0; v < v1; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**.
     * Constructs the object.
     *
     * @param      m    { parameter_description }
     * @param      k     { parameter_description }
     */
    public Graph(final int m, final int k) {
        this(m);
        for (int i = 0; i < k; i++) {
            int v = (int) (Math.random() * v1);
            int w = (int) (Math.random() * v1);
            addEdge(v, w);
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity : O(1)
     */
    public int vert() {
        return v1;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity : O(1)
     */
    public int e() {
        return e;
    }
    /**.
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     * time complexity : O(1)
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
     * time complexity : O(1)
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    // /**.
    //  * Returns a string representation of the object.
    //  *
    //  * @return     String representation of the object.
    //  */
    // public String toString() {
    //     StringBuilder s = new StringBuilder();
    //     String newline = System.getProperty("line.separator");
    //     s.append(v1 + " vertices, " + e + " edges " + newline);
    //     for (int v = 0; v < v1; v++) {
    //         s.append(v + ": ");
    //         for (int w : adj[v]) {
    //             s.append(w + " ");
    //         }
    //         s.append(newline);
    //     }
    //     return s.toString();
    // }
}




