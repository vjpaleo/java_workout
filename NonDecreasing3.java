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

class NonDecreasing3 {

	
	public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int[][] maxLenTailing = new int[matrix.length][matrix[0].length];
       // store the max length of increasing subsequence that ending at i and j.
        int maxLen = 0;
        // top left to bottom right
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                // scan every element in the matrix.
                maxLenTailing[i][j] = directionalCheck(i, j,matrix, maxLenTailing);
                maxLen = Math.max(maxLen, maxLenTailing[i][j]);
            }
        }
        return maxLen;
    }
        private static int directionalCheck(int i, int j, int[][] matrix, int[][] maxLenTailing){
    // basically recursively check surrounding elements. If they are exist and smaller than current element, we should consider it as the longest increasing sub sequence. However if we already check one element, the value corresponding to that index pair should no longer be zero, thus no need to recursively calculate that value again.
            if (maxLenTailing[i][j] == 0) {
// have not been visited before, need recursive calculation
                // have not recursively checking.
            int len = 1;
            // up
            if (i - 1 > -1 && matrix[i][j] > matrix[i-1][j]) {
                len = Math.max(len, 1 + directionalCheck(i-1, j, matrix, maxLenTailing));
            }
            // down
            if (i + 1 < matrix.length && matrix[i][j] > matrix[i+1][j]) {
                len = Math.max(len, 1 + directionalCheck(i+1, j, matrix, maxLenTailing));
            }
            // left
            if (j-1 > -1 && matrix[i][j] > matrix[i][j-1]) {
                len = Math.max(len, 1 + directionalCheck(i, j -1, matrix, maxLenTailing));
            }
         
            // right
            if (j + 1 < matrix[0].length && matrix[i][j] > matrix[i][j+1]) {
                len = Math.max(len, 1 + directionalCheck(i, j + 1, matrix, maxLenTailing));
            }
            maxLenTailing[i][j] = len; // setting maxLenTailing value here to avoid additional recurssively checking
            return len;
        }
        return maxLenTailing[i][j];
        
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
		int length = longestIncreasingPath(grid);
		System.out.println(length);
	}
}