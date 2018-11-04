// /**.
//  * Class for page rank.
//  */
// class PageRank {
//     /**.
//      * { var_description }
//      */
//     private Digraph dig;
//     /**.
//      * { var_description }
//      */
//     private double[] prvalue;
//     private final int NUM_BER = 1000;
//     /**.
//      * Constructs the object.
//      *
//      * @param      d     { parameter_description }
//      */
//     PageRank(final Digraph d) {
//         this.dig = d;
//         //int vertices = dig.vert();
//         prvalue = new double[dig.vert()];
//         for (int i = 0; i < prvalue.length; i++) {
//             prvalue[i] = 1 / dig.vert();
//         }
//         getPR();
//     }
//     /**.
//      * Gets the pr.
//      */
//     public void getPR() {
//         for (int i = 0; i < NUM_BER; i++) {
//             for (int j = 0; j < dig.vert(); j++) {
//                 double result = 0.0;
//                 for (int k : dig.adj(j)) {
//                     result += (prvalue[k] / dig.outdegree(k));
//                 }
//                 prvalue[j] = result;
//             }
//         }
//     }

//     // public String toString() {
//     //  StringBuilder s = new StringBuilder();
//     //  for (int i = 0; i < dig.vert(); i++) {
//     //      System.out.println(i + "-" + getPR(i));
//     //  }
//     // }
// }

/**.
 * { item_description }
 */
import java.util.Arrays;
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
    private int vertices;
    /**.
     * { var_description }
     */
    private double[] pr;
    /**.
     * { var_description }
     */
    private double[] pr1;
    /**.
     * { var_description }
     */
    private double result;
    /**.
     * { var_description }
     */
    private final int thousand = 1000;
    /**.
     * Constructs the object.
     *
     * @param      d     { parameter_description }
     */
    PageRank(final Digraph d) {
        dig = d;
        vertices = dig.vert();
        pr = new double[vertices];
        pr1 = new double[vertices];
        for (int i = 0; i < vertices; i++) {
            pr[i] = (1 / vertices);
        }
        Digraph revdigraph = dig.reverse();
        for (int i = 0; i < thousand; i++) {
            for (int j = 0; j < vertices; j++) {
                result = 0.0;
                for (int k : revdigraph.adj(j)) {
                    result += ((pr[k]) / ((double) (dig.outdegree(k))));
                    System.out.println(result);
                }

                pr1[j] = result;
            }
            if (Arrays.equals(pr, pr1)) {
                break;
            } else {
                pr = pr1.clone();
            }
        }
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " - " + pr1[i] + "\n");
        }
    }
}
