import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

/**
 * 3 3
 * 8 2 6
 * 0 6 1
 * 3 7 9
 */

class NonDecreasing2 {

	
	public static int checkPossiblePaths(int[][] grid, int row, int col, int[][] path) {
    	
    	int numRows = grid.length;
		int numCols = 0;
		if(numRows > 0) {
			numCols = grid[0].length;
		}

    	// basically recursively check surrounding elements. If they are exist and smaller than current element, we should consider it as the longest increasing sub sequence. However if we already check one element, the value corresponding to that index pair should no longer be zero, thus no need to recursively calculate that value again.
        if (path[row][col] == 0) {
			int len = 1;
			if ( col+1 < numCols && Math.abs((grid[row][col]) - (grid[row][col+1])) > 3 ) {
	        	System.out.println( grid[row][col] + " ---> " + grid[row][col+1]);
				len = Math.max(len, 1 + checkPossiblePaths(grid, row, col + 1, path));
				path[row][col] = len;
			}
			
			if ( (col+1 < numCols && row+1 < numRows)  && Math.abs((grid[row][col]) - (grid[row+1][col+1])) > 3 ) {
				System.out.println( grid[row][col] + " ---> " + grid[row+1][col+1]);
				len = Math.max(len, 1 + checkPossiblePaths(grid, row + 1, col + 1, path));
				path[row][col] = len;
			}
			
			if (  (row+1 < numRows) &&  Math.abs((grid[row][col]) - (grid[row+1][col])) > 3 ) {
				System.out.println( grid[row][col] + " ---> " + grid[row+1][col] + " --->  " + Math.abs((grid[row][col]) - (grid[row+1][col])));
				
				len = Math.max(len, 1 + checkPossiblePaths(grid, row + 1, col, path));
				path[row][col] = len;
			}

			if (  (col > 0 && row+1 < numRows) &&  Math.abs((grid[row][col]) - (grid[row+1][col-1])) > 3 ) {
				System.out.println( grid[row][col] + " ---> " + grid[row+1][col-1]);
				len = Math.max(len, 1 + checkPossiblePaths(grid, row + 1, col - 1, path));
				path[row][col] = len;
			}
			
			if (  (row < numRows && col > 0) && Math.abs((grid[row][col]) - (grid[row][col-1])) > 3 ) {
				System.out.println( grid[row][col] + " ---> " + grid[row][col-1]);
				len = Math.max(len, 1 + checkPossiblePaths(grid, row, col - 1, path));
				path[row][col] = len;
			}

			if ( (row > 0 && col > 0) && Math.abs((grid[row][col]) - (grid[row-1][col-1])) > 3 ) {
				System.out.println( grid[row][col] + " ---> " + grid[row-1][col-1]);
				len = Math.max(len, 1 + checkPossiblePaths(grid, row -1, col - 1, path));
				
			}
			
			if ( (row > 0 )  && Math.abs((grid[row][col]) - (grid[row-1][col])) > 4 ) {
				System.out.println( grid[row][col] + " --- " + grid[row-1][col] + " ---  " + Math.abs((grid[row][col]) - (grid[row-1][col])));
				len = Math.max(len, 1 + checkPossiblePaths(grid, row - 1, col, path));
				path[row][col] = len;
			}

			if ( (row > 0 && col+1 < numCols) &&  Math.abs((grid[row][col]) - ( grid[row-1][col+1])) > 4 ) {
				System.out.println( grid[row][col] + " ---> " + grid[row-1][col+1]);
				len = Math.max(len, 1 + checkPossiblePaths(grid, row - 1, col + 1, path));
				path[row][col] = len;
			}
			System.out.println( " +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ");
			path[row][col] = len; 

	        return len;
        }
        return path[row][col];
        
    }

	/**
	 * Take a rectangular grid of numbers and find the length
	 * of the longest sub-sequence.
	 * @return the length as an integer.
	 */
	public static int longestSequence(int[][] grid) {

		int numRows1 = grid.length;
		int numCols1 = 0;
		
		if(numRows1 > 0) {
			numCols1 = grid[0].length;
		}

		int final_len = 0;
		
		// path
		int[][] path = new int[numRows1][numCols1];

		// work on grid
		for (int r = numRows1 -1; r >= 0; r--) {
			for (int c = numCols1 -1; c >= 0; c--) {
				//System.out.println(r+"-"+c);
				path[r][c] = checkPossiblePaths ( grid, r, c, path);
				final_len = Math.max(final_len, path[r][c]);
				
				System.out.println("============================================");
				
			}
		}		
		
		
		// TODO: implement this function
		return final_len;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int numRows = 0;
		int numCols = 0;
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
		int length = longestSequence(grid);
		System.out.println(length);
	}
}