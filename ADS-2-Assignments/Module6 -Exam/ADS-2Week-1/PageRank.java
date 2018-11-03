/**.
 * Class for page rank.
 */
class PageRank {
    /**.
     * { var_description }
     */
    private Digraph dig;
    /**.
     * { var_description }
     */
    private double[] prvalue;
    /**.
     * Constructs the object.
     *
     * @param      d     { parameter_description }
     */
    PageRank(final Digraph d) {
        this.dig = d;
        //int vertices = dig.vert(); 
        prvalue = new double[dig.vert()];
        for (int i = 0; i < prvalue.length; i++) {
            prvalue[i] = 1 / dig.vert();
        }
        getPR();
    }
    /**.
     * Gets the pr.
     */
    public void getPR() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < dig.vert(); j++) {
                double result = 0.0;
                for(int k : dig.adj(j)) {
                    result += (prvalue[k]/dig.outdegree(k));
                }
                prvalue[j] = result;
            }
        }
    }

    // public String toString() {
    //  StringBuilder s = new StringBuilder();
    //  for (int i = 0; i < dig.vert(); i++) {
    //      System.out.println(i + "-" + getPR(i));
    //  }
    // }
}
