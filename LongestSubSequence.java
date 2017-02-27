//LongestSubSequence.java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class LongestSubSequence 
{

	/**
	 * Main method - will be called by default
	 * @param  args       
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int numRows = 0;
		int numCols = 0;
		int length = 0;		

		String[] firstLine = reader.readLine().split("\\s+");
		numRows = Integer.parseInt(firstLine[0]);
		numCols = Integer.parseInt(firstLine[1]);

		int[][] grid = new int[numRows][numCols];

		for (int row = 0; row < numRows; row++) {
		    String[] inputRow = reader.readLine().split("\\s+");

		    for (int col = 0; col < numCols; col++) {
		        grid[row][col] = Integer.parseInt(inputRow[col]);
		    }
		}

		// find the length of subsequence from each number in the grid.
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				int[][] tail = new int[grid.length][grid[0].length];
				length = Math.max(length, paths(grid, i, j, tail));
			}
		}
		System.out.println(length);
	}

	/**
	 * Method to find the longest subsequeence of the data grid.
	 * This method is called recusrively.
	 * @param  grid data grid
	 * @param  r    row number
	 * @param  c    column number
	 * @param  tail array to trace the active path
	 * @return      length of subsequence
	 */
	public static int paths(int[][] grid, int r, int c, int[][] tail) {

		// initialize len to 1 from r and c
		int len = 1;
		
		// initialize the path covered
		tail[r][c] = 1;

		// right
		if ( c < ( grid[0].length - 1 )  && Math.abs( grid[r][c+1] - grid[r][c] ) > 3 && ( tail[r][c+1] == 0 ) ) {
			len = Math.max( len, 1 + paths(grid, r, c+1, tail) );
		}

		// down
		if ( r < ( grid.length - 1 )  && Math.abs( grid[r+1][c] - grid[r][c] ) > 3 && ( tail[r+1][c] == 0 )) {
			len = Math.max( len, 1 + paths(grid, r+1, c, tail) );
		}

		// left
		if ( c > 0  && Math.abs( grid[r][c-1] - grid[r][c] ) > 3 && ( tail[r][c-1] == 0 )) {
			len = Math.max( len, 1 + paths(grid, r, c-1, tail) );
		}
		
		// up
		if ( r > 0  && Math.abs( grid[r-1][c] - grid[r][c] ) > 3 && ( tail[r-1][c] == 0 )) {
			len = Math.max( len, 1 + paths(grid, r-1, c, tail) );
		}

		// right-top
		if ( (r > 0) && c < ( grid[0].length - 1 )  && Math.abs( grid[r-1][c+1] - grid[r][c] ) > 3 && ( tail[r-1][c+1] == 0 ) ) {
			len = Math.max( len, 1 + paths(grid, r-1, c+1, tail) );
		}

		// right-down
		if ( r < ( grid.length - 1 ) && c < ( grid[0].length - 1 ) && Math.abs( grid[r+1][c+1] - grid[r][c] ) > 3 && ( tail[r+1][c+1] == 0 )) {
			len = Math.max( len, 1 + paths(grid, r+1, c+1, tail) );
		}
		
		// left-down
		if ( c > 0 && r < ( grid.length - 1 ) && Math.abs( grid[r+1][c-1] - grid[r][c] ) > 3 && ( tail[r+1][c-1] == 0 )) {
			len = Math.max( len, 1 + paths(grid, r+1, c-1, tail) );
		}
		
		// left-up
		if ( r > 0  && c > 0  && Math.abs( grid[r-1][c-1] - grid[r][c] ) > 3 && ( tail[r-1][c-1] == 0 )) {
			len = Math.max( len, 1 + paths(grid, r-1, c-1, tail) );
		}
		
		// initialize the tail since root is reached.
		tail[r][c] = 0;
		
		return len;
	}

}