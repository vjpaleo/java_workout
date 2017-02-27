import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

class NonDecreasing {

	public static int walk(int[][] grid, int r, int c, int len, int[][] path) {

		int numRows = grid.length;
		int numCols = 0;
		if(numRows > 0) {
			numCols = grid[0].length;
		}

		
		if (path[r][c] == 0) {
			len += 1;
		
			path[r][c] = grid[r][c];

			System.out.println(len + " - " + r + " - " + c + " - " + path[r][c] );


			if ( c+1 < numCols &&  path[r][c+1] == 0 && ( Math.abs(grid[r][c] - grid[r][c+1]) ) > 3) {
				System.out.println("RIGHT");
				// move right
				len = walk ( grid, r, c + 1 , len, path); 

			} else if ( (r > 0 && c + 1 <  numCols) &&  path[r-1][c+1] == 0 &&  ( Math.abs(grid[r][c] - grid[r-1][c+1]) ) > 3 ) {
				System.out.println("RIGHT TOP");
				
				// move right top
				len = walk ( grid, r - 1, c + 1, len, path); 
			
			} else if (r+1 < numRows &&  path[r+1][c] == 0 && ( Math.abs(grid[r][c] - grid[r+1][c]) ) > 3) {
				System.out.println("DOWN");
				
				// move down
				len = walk ( grid, r + 1, c , len, path); 

			} else if ( ( c + 1 < numCols && r + 1 < numRows) &&  path[r+1][c+1] == 0 && ( Math.abs(grid[r][c] - grid[r+1][c+1]) ) > 3 ) {
				System.out.println("DOWN RIGHT");
				
				// move down right
				len = walk ( grid, r + 1, c + 1, len, path); 

			} else if ( (c > 0 && r+1 < numCols) &&  path[r+1][c-1] == 0  &&  ( Math.abs(grid[r][c] - grid[r+1][c-1]) ) > 3 ) {
				System.out.println("DOWN LEFT");
				
				// move down left
				len = walk ( grid, r + 1, c - 1, len, path);

			} else if (c > 0 &&  path[r][c-1] == 0  &&  ( Math.abs(grid[r][c] - grid[r][c-1]) ) > 3 ) {
				System.out.println("LEFT");
				// move left
				len = walk ( grid, r, c - 1, len, path); 
				
			} else if ( (r > 0 && c > 0) &&  path[r-1][c-1] == 0 &&  ( Math.abs(grid[r][c] - grid[r-1][c-1]) ) > 3 ) {
				System.out.println("LEFT TOP");
				// move left top
				len = walk ( grid, r - 1, c - 1, len, path); 
			} 
		}

		return len;
		
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

		int len = 0;
		int final_len = 0;
		int in_len = 0;

		// path
		int[][] path = new int[numRows1][numCols1];

		// initialize 0 to all the elements of the array
		for (int r1 = 0; r1 < numRows1; r1++) {
			for (int c1 = 0; c1 < numCols1; c1++) {
				path[r1][c1] = 0;
			}
		}

		// work on grid
		for (int r = 0; r < numRows1; r++) {
			for (int c = 0; c < numCols1; c++) {
				
				len = 0;
				
				// initialize 0 to all the elements of the array
				for (int r1 = 0; r1 < numRows1; r1++) {
					for (int c1 = 0; c1 < numCols1; c1++) {
						path[r1][c1] = 0;
					}
				}

				in_len = walk ( grid, r, c, len, path);

				System.out.println("Update final length from " + in_len + "." );

				if (in_len > final_len) {
					final_len = in_len;
					System.out.println("Update final length from " + final_len + " to " + in_len + "." );
				} 

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