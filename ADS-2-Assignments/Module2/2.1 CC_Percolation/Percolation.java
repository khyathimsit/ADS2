import java.util.*;

public class Percolation {
	public boolean[][] grid;
	public int size;
	public GraphList list;

	public Percolation(int size) {
		this.size = size;
		grid = new boolean[size][size];
		list = new GraphList(size * size + 2);
	}

	public void open(int row, int col) {
		grid[row][col] = true;
		
		if(row == 0){
			list.addEdge(size * size, percolates(row,col));
		}
		if(row == size-1){
			list.addEdge(size * size + 1, percolates(row,col));
		}
		if(row < size - 1 && grid[row+1][col]){ //bottom element
			list.addEdge(percolates(row, col), percolates(row+1, col));
		}
		if(row > 0 && grid[row-1][col]){ //top element
			list.addEdge(percolates(row, col), percolates(row-1, col));
		}
		if(col > 0 && grid[row][col-1]){ //left element
			list.addEdge(percolates(row, col), percolates(row, col + 1));
		}
		if(col < size - 1 && grid[row][col+1]){ //right element
			list.addEdge(percolates(row, col), percolates(row, col - 1));
		}
	}
	public int percolates(int row, int col) {
		return (size * row) + col;
	}

	public boolean isconnected(){
		ConnectedComponents cc = new ConnectedComponents(list);
		if (cc.connected(size * size, size * size + 1)) {
			return true;
		}return false;
	}
}
