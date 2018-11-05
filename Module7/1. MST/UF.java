/**.
 * Class for uf.
 */
public class UF {
    /**.
     * { var_description }
     */
    private int[] parent;
    /**.
     * { var_description }
     */
    private byte[] rank;
    /**.
     * { var_description }
     */
    private int count;
    /**.
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    public UF(final int n) {
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    /**.
     * Searches for the first match.
     * Time complexity : O(n)
     * @param      l     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int find(final int l) {
        int p = l;
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    /**.
     * Returns the number of components.
     * Time complexity : O(1)
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }
    /**.
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites {@code p}
     *         {@code false} otherwise
     * Time complexity : O(1)
     */
    public boolean connected(final int p, final int q) {
        return find(p) == find(q);
    }
    /**.
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * Time complexity : O(1)
     */
    public void union(final int p, final int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }
    /**.
     * { function_description }
     *
     * @param      p     { parameter_description }
     * Time complexity : O(1)
     */
    private void validate(final int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException(
                "index " + p + " is not between 0 and " + (n - 1));
        }
    }
}
