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

class NonDecreasing1 {

	
	public static int walk(int[][] grid, int r, int c, int len, int[][] path) {

		int numRows = grid.length;
		int numCols = 0;
		if(numRows > 0) {
			numCols = grid[0].length;
		}
		
		if (path[r][c] == 0) {

			path[r][c] = 1;
			System.out.println("Covered: (" + r + ", " + c + ").");
			
			len += 1;
			int[] ps = checkPossiblePaths(grid, r, c, path);
			int mr = 0, mc = 0;
			int len1 = 0;
			
			int[] i = new int[ps.length];
			for (int p = 0; p < ps.length; p++) {	

				if (ps[p] == 1) {
					switch(p) {
						case 0: mr = r;
								mc = c + 1;
								break;
						case 1: mr = r + 1;
								mc = c + 1;
								break;
						case 2: mr = r + 1;
								mc = c;
								break;
						case 3: mr = r + 1;
								mc = c - 1;
								break;
						case 4: mr = r;
								mc = c - 1;
								break;
						case 5: mr = r - 1 ;
								mc = c - 1;
								break;
						case 6: mr = r - 1;
								mc = c;
								break;
						case 7: mr = r - 1;
								mc = c + 1;
								break;
					}
					System.out.println("Possible paths from " + " - " + r + " - " + c + " - " + grid[mr][mc] + " length: " + len);
					i[p] = walk(grid, mr, mc, len, path);
					
				} else {

					//System.out.println("Length: " + len);
					if(i[p] > len) {
						len = i[p];
					}
				}

				
				
			}




			/*
			if ( c+1 < numCols &&  path[r][c+1] == 0 && ( Math.abs(grid[r][c] - grid[r][c+1]) ) > 3) {
				System.out.println("RIGHT");
				// move right
				len1 = walk ( grid, r, c + 1 , len+1, path); 
				
				if(len < len1) {
					len = len1;
				}
			}

			if ( (r > 0 && c + 1 <  numCols) &&  path[r-1][c+1] == 0 &&  ( Math.abs(grid[r][c] - grid[r-1][c+1]) ) > 3 ) {
				System.out.println("RIGHT TOP");
				
				// move right top
				len1 = walk ( grid, r - 1, c + 1, len+1, path); 
				
				if(len < len1) {
					len = len1;
				}
			
			}

			if (r+1 < numRows &&  path[r+1][c] == 0 && ( Math.abs(grid[r][c] - grid[r+1][c]) ) > 3) {
				
				System.out.println("DOWN");
				
				// move down
				len1 = walk ( grid, r + 1, c , len+1, path); 
				
				if(len < len1 - 1) {
					len = len1;
				}

			}

			if ( ( c + 1 < numCols && r + 1 < numRows) &&  path[r+1][c+1] == 0 && ( Math.abs(grid[r][c] - grid[r+1][c+1]) ) > 3 ) {
				
				System.out.println("DOWN RIGHT");
				
				// move down right
				len1 = walk ( grid, r + 1, c + 1, len+1, path); 
				
				if(len < len1 - 1) {
					len = len1;
				}

			}

			if ( (c > 0 && r+1 < numRows) &&  path[r+1][c-1] == 0  &&  ( Math.abs(grid[r][c] - grid[r+1][c-1]) ) > 3 ) {
				System.out.println("DOWN LEFT -> " + grid[r][c] + " - " + grid[r+1][c-1]);
				
				// move down left
				len1 = walk ( grid, r + 1, c - 1, len+1, path);

				if(len < len1) {
					len = len1;
				}

			}

			if (c > 0 &&  path[r][c-1] == 0  &&  ( Math.abs(grid[r][c] - grid[r][c-1]) ) > 3 ) {
				
				System.out.println("LEFT -> " + grid[r][c] + " - " + grid[r][c-1]);
				// move left
				len1 = walk ( grid, r, c - 1, len+1, path); 

				if(len < len1) {
					len = len1;
				}
				
			}

			if ( (r > 0 && c > 0) &&  path[r-1][c-1] == 0 &&  ( Math.abs(grid[r][c] - grid[r-1][c-1]) ) > 3 ) {
				
				System.out.println("LEFT TOP");
				// move left top
				len1 = walk ( grid, r - 1, c - 1, len+1, path); 

				if(len < len1) {
					len = len1;
				}
			} 

			if ( (r > 0) &&  path[r-1][c] == 0 &&  ( Math.abs(grid[r][c] - grid[r-1][c]) ) > 3 ) {
				
				System.out.println("TOP");
				// move left top
				len1 = walk ( grid, r - 1, c, len+1, path); 

				if(len < len1) {
					len = len1;
				}
			} 
			*/

		}

		return len;
		
	}

	public static int[] checkPossiblePaths(int[][] grid, int row, int col, int[][] path) {

		int numRows = grid.length;
		int numCols = 0;
		if(numRows > 0) {
			numCols = grid[0].length;
		}

		// r, rd, d, dl, l, lt, t, tr
		int[] possiblePaths = new int[8];
		int numPossiblePaths = 0;

		for (int p = 0; p < 8; p++) {
			possiblePaths[p] = 0;
		}

		if ( col+1 < numCols &&  path[row][col+1] == 0 && ( Math.abs(grid[row][col] - grid[row][col+1]) > 3 ) ) {
			possiblePaths[0] = 1;
			numPossiblePaths++;
		}

		if ( (col+1 < numCols && row+1 < numRows) &&  path[row+1][col+1] == 0  && Math.abs(grid[row][col] - grid[row+1][col+1]) > 3 ) {
			possiblePaths[1] = 1;
			numPossiblePaths++;
		}

		if (  (col < numCols && row+1 < numRows) &&  path[row+1][col] == 0 &&  Math.abs(grid[row][col] - grid[row+1][col]) > 3 ) {
			possiblePaths[2] = 1;
			numPossiblePaths++;
		}

		if (  (col-1 > 0 && row+1 < numRows) &&  path[row+1][col-1] == 0 &&  Math.abs(grid[row][col] - grid[row+1][col-1]) > 3 ) {
			possiblePaths[3] = 1;
			numPossiblePaths++;
		}
		
		if (  (row < numRows && col > 0) &&  path[row][col-1] == 0 && Math.abs(grid[row][col] - grid[row][col-1]) > 3 ) {
			possiblePaths[4] = 1;
			numPossiblePaths++;
		}

		if ( (row > 0 && col > 0) &&  path[row-1][col-1] == 0 && Math.abs(grid[row][col] - grid[row-1][col-1]) > 3 ) {
			possiblePaths[5] = 1;
			numPossiblePaths++;
		}
		
		if ( (row > 0 ) &&  path[row-1][col] == 0 && Math.abs(grid[row][col] - grid[row-1][col]) > 3 ) {
			//System.out.println(">>>>>>> " + Math.abs(grid[row][col] - grid[row-1][col]));
			possiblePaths[6] = 1;
			numPossiblePaths++;
		}

		if ( (row > 0 && col+1 < numCols) &&  path[row-1][col+1] == 0  &&  Math.abs(grid[row][col] - grid[row-1][col+1]) > 3 ) {
			possiblePaths[7] = 1;
			numPossiblePaths++;
		}
		
		return possiblePaths;
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
		int in_len = 0;

		// path
		int[][] path = new int[numRows1][numCols1];

		// work on grid
		for (int r = 0; r < numRows1; r++) {
			for (int c = 0; c < numCols1; c++) {
				
				// initialize 0 to all the elements of the array
				for (int r1 = 0; r1 < numRows1; r1++) {
					for (int c1 = 0; c1 < numCols1; c1++) {
						path[r1][c1] = 0;
					}
				}

				
				
			}
		}		
		
		in_len = walk ( grid, 2, 1, 0, path);

				if (in_len > final_len) {
					System.out.println("Update final length from " + final_len + " to " + in_len + "." );
					final_len = in_len;
				} 

				System.out.println("============================================");
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