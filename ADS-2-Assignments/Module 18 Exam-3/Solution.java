/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
 */
import java.util.Collections;
/**.
 * { item_description }
 */
import java.util.ArrayList;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash =
               loadDictionary("/Files/t9.csv");
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                System.out.println(hash.get(key));
            }
            break;

        case "getAllPrefixes":
            // input001.txt and output001.txt
            T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
            while (scan.hasNextLine()) {
                String prefix = scan.nextLine();
                for (String each : t9.getAllWords(prefix)) {
                    System.out.println(each);
                }
            }
            break;

        case "potentialWords":
            // input002.txt and output002.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            int count = 0;
            while (scan.hasNextLine()) {
                String t9Signature = scan.nextLine();
                for (String each : t9.potentialWords(t9Signature)) {
                    count++;
                    System.out.println(each);
                }
            }
            if (count == 0) {
                System.out.println("No valid words found.");
            }
            break;

        case "topK":
            // input003.txt and output003.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            Bag<String> bag = new Bag<String>();
            int k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                bag.add(line);
            }
            for (String each : t9.getSuggestions(bag, k)) {
                System.out.println(each);
            }
            break;

        case "t9Signature":
            // input004.txt and output004.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            bag = new Bag<String>();
            k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (String each : t9.t9(line, k)) {
                    System.out.println(each);
                }
            }
            break;

        default:
            break;

        }
    }
    /**.
     * { function_description }
     *
     * @param      file  The file
     *
     * @return     { description_of_the_return_value }
     */
    public static String[] toReadFile(final String file) {
        In in = new In(file);
        return in.readAllStrings();
    }
    /**.
     * Loads a dictionary.
     *
     * @param      file  The file
     *
     * @return     { description_of_the_return_value }
     */
    public static BinarySearchST<String, Integer>
              loadDictionary(final String file) {
        BinarySearchST<String, Integer>  st =
            new BinarySearchST<String, Integer>();
        String[] dict = toReadFile(file);
        for (int i = 0; i < dict.length; i++) {
            String words = dict[i].toLowerCase();
            if (st.contains(words)) {
                int value = st.get(words);
                st.put(words, value + 1);
            } else {
                st.put(words, 1);
            }
        }
        return st;
    }
}
/**.
 * Class for t 9.
 */
class T9 {
    private TST<Integer> tst;
    public T9(BinarySearchST<String, Integer> st) {
        // your code goes here
        tst = new TST<Integer>();
        for (String i : st.keys()) {
            tst.put(i, st.get(i));
        }
    }

    /**.
     * Gets all words.
     *
     * @param      prefix  The prefix
     *
     * @return     All words.
     */
    public Iterable<String> getAllWords(final String prefix) {
        // your code goes here
        return tst.keysWithPrefix(prefix);
    }
    /**.
     * { function_description }
     *
     * @param      t9Signature  The t 9 signature
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> potentialWords(final String t9Signature) {
        // your code goes here
        ArrayList<String> list = new ArrayList<String>();
        for(String word : tst.keys()) {
            String[] chars = word.split("");
            String str = "";
            for (String ch : chars) {
                if (ch.equals("a") || ch.equals("b") || ch.equals("c")) {
                    str = str + 2;
                }
                if (ch.equals("d") || ch.equals("e") || ch.equals("f")) {
                    str = str + 3;
                }
                if (ch.equals("g") || ch.equals("h") || ch.equals("i")) {
                    str = str + 4;
                }
                if (ch.equals("j") || ch.equals("k") || ch.equals("l")) {
                    str = str + 5;
                }
                if (ch.equals("m") || ch.equals("n") || ch.equals("o")) {
                    str = str + 6;
                }
                if (ch.equals("p") || ch.equals("q") ||
                    ch.equals("r") || ch.equals("s")) {
                    str = str + 7;
                }
                if (ch.equals("t") || ch.equals("u") || ch.equals("v")) {
                    str = str + 8;
                }
                if (ch.equals("w") || ch.equals("x") ||
                    ch.equals("y") || ch.equals("z")) {
                    str = str + 9;
                }
            }
            if (str.equals(t9Signature)) {
                if (tst.contains(word)) {
                    list.add(word);
                }
            }
        }
        return list;
    }
    /**.
     * Gets the suggestions.
     *
     * @param      words  The words
     * @param      k      { parameter_description }
     *
     * @return     The suggestions.
     */
    public Iterable<String> getSuggestions(
           final Iterable<String> words, final int k) {
        // your code goes here
        ArrayList<String> list = new ArrayList<String>();
        MaxPQ<Integer> pq = new MaxPQ<Integer>();
        for (String i : words) {
            pq.insert(tst.get(i));
        }
        for (int i = 0; i < k; i++) {
            int maxval = pq.delMax();
            for (String word : words) {
                if (maxval == tst.get(word)) {
                    list.add(word);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
    /**.
     * { function_description }
     *
     * @param      t9Signature  The t 9 signature
     * @param      k            { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> t9(final String t9Signature, final int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}
