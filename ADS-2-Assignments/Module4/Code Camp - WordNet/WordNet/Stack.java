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
public class Stack<Item> implements Iterable<Item> {
    /**.
     * { var_description }
     */
    private int n;
    /**.
     * { var_description }
     */
    private Node first;
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
    public Stack() {
        first = null;
        n = 0;
    }
    /**.
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     * time complexity O(1)
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity O(1)
     */
    public int size() {
        return n;
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     * time complexity O(1)
     */
    public void push(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    /**.
     * { function_description }
     *time complexity O(1)
     * @return     { description_of_the_return_value }
     */
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * time complexity O(1)
     */
    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return first.item;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     * time complexity O(1)
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
     * time complexity O(1)
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    /**.
     * Class for list iterator.
     *
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
         * time complexity O(1)
         */
        public boolean hasNext() {
            return current != null;
        }
        /**.
         * { function_description }
         * time complexity O(1)
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**.
         * { function_description }
         *
         * @return     { description_of_the_return_value }
         * time complexity O(1)
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


