public class BoggleSolver {
	TST<Integer> tst = new TST<Integer>();
	Bag<String> bag = new Bag<String>();
	private int rows;
	private int columns;
	public BoggleSolver(final String[] dictionary, final BoggleBoard board) {
		rows = board.rows();
		columns = board.cols();
		int[] scores = {0, 0, 0, 1, 1, 2, 3, 5};
		
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].length() >= 8) {
				tst.put(dictionary[i], 11);
			} else {
				tst.put(dictionary[i], scores[dictionary[i].length()]);
			}
		}
	}

	public Iterable<String> getAllValidWords(final BoggleBoard board) {
		boolean[][] valid = new boolean[board.rows()][board.cols()];
		for(int i = 0; i< board.rows(); i++) {
			for(int j = 0; j < board.cols(); j++) {
				dfs(board, i, j, character(board.getLetter(i, j)), valid);
			}
		}
		return new Bag<String>();
	}

	public boolean isValid(String word) {
		Queue<String> que = tst.keysWithPrefix(word);
		if (que.size() == 0) {
			return false;
		}
		return true;
	}

	public String character(char c) {
		if (c == 'Q') {
			return "QU";
		}
		return c + "";
	}

	public int scoreOf(final String word) {
		return tst.get(word);
	}

	public void dfs(BoggleBoard board, int row, int column, String word, boolean[][] matrix) {
		if (row < 0 || column < 0 || row > rows || column > columns) {
			return;
		}
		if (tst.contains(word) && (!bag.contains(word))) {
			bag.add(word);
			matrix[row][column] = true;
		}
		if (matrix[row][column]) {
			return;
		}
		if (!matrix[row - 1][column - 1]) {
			dfs(board, row - 1, column - 1, word + character(board.getLetter(row - 1, column - 1)), matrix);
			matrix[row - 1][column - 1] = true;
		}

		if (!matrix[row - 1][column]) {
			dfs(board, row - 1, column, word + character(board.getLetter(row - 1, column)), matrix);
			matrix[row - 1][column] = true;
		}

		if (!matrix[row - 1][column + 1]) {
			dfs(board, row - 1, column + 1, word + character(board.getLetter(row - 1, column + 1)), matrix);
			matrix[row - 1][column + 1] = true;
		}

		if (!matrix[row][column - 1]) {
			dfs(board, row, column - 1, word + character(board.getLetter(row, column - 1)), matrix);
			matrix[row][column - 1] = true;
		}

		if (!matrix[row][column + 1]) {
			dfs(board, row, column + 1, word + character(board.getLetter(row, column + 1)), matrix);
			matrix[row][column + 1] = true;
		}

		if (!matrix[row + 1][column - 1]) {
			dfs(board, row + 1, column - 1, word + character(board.getLetter(row + 1, column - 1)), matrix);
			matrix[row + 1][column - 1] = true;
		}
		if (!matrix[row + 1][column]) {
			dfs(board, row + 1, column, word + character(board.getLetter(row + 1, column)), matrix);
			matrix[row + 1][column] = true;
		}
		if (!matrix[row + 1][column + 1]) {
			dfs(board, row + 1, column + 1, word + character(board.getLetter(row + 1, column + 1)), matrix);
			matrix[row + 1][column + 1] = true;
		}
	}
}