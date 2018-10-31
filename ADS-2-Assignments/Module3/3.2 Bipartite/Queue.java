/**.
 * { item_description }
 */
import java.util.Iterator;
/**.
 * { item_description }
 */
import java.util.NoSuchElementException;
/**.
 * List of .
 *
 * @param      <Item>  The item
 */
public class Queue<Item> implements Iterable<Item> {
    /**.
     * { var_description }
     */
    private int n;
    /**.
     * { var_description }
     */
    private Node first;
    /**.
     * { var_description }
     */
    private Node last;
    /**.
     * Class for node.
     */
    private class Node {
        /**.
         * { var_description }
         */
        private Item item;
        /**.
         * { var_description }
         */
        private Node next;
    }
    /**.
     * Constructs the object.
     */
    public Queue() {
        first = null;
        last  = null;
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
     * @return     { description_of_the_return_value }
     */
    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return first.item;
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     */
    public void enqueue(final Item item) {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            last.next = x;
            last = x;
        }
        n++;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
        last = null;
        }
        return item;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    /**.
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**.
         * { var_description }
         */
        private Node current = first;
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

