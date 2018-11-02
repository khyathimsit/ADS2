/**.
 * { item_description }
 */
import java.util.Iterator;
/**.
 * { item_description }
 */
import java.util.NoSuchElementException;
/**.
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**.
     * { var_description }
     */
    private Node<Item> first;
    /**.
     * { var_description }
     */
    private int n;
    /**.
     * Class for node.
     *
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**.
         * { var_description }
         */
        private Item item;
        /**.
         * { var_description }
         */
        private Node<Item> next;
    }
    /**.
     * Constructs the object.
     */
    public Bag() {
        first = null;
        n = 0;
    }
    /**.
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }
    /**.
     * Class for list iterator.
     *
     * @param      <Item>  The item
     */
    private class ListIterator<Item> implements Iterator<Item> {
        /**.
         * { var_description }
         */
        private Node<Item> current;
        /**.
         * Constructs the object.
         *
         * @param      first  The first
         */
        public ListIterator(final Node<Item> first) {
            current = first;
        }
        /**.
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**.
         * { function_description }
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**.
         * { function_description }
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
