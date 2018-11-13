/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
	/**.
	 * Constructs the object.
	 */
	private Solution() { }
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		String[] words = loadWords();
		Scanner sc = new Scanner(System.in);
		TST<Integer> tst = new TST<Integer>();
		for (int i = 0; i < words.length; i++) {
			tst.put(words[i], i);
		}
		String prefix = sc.nextLine();
		for (String str : tst.keysWithPrefix(prefix)) {
			System.out.println(str);
		}
	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}