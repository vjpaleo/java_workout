import java.io.*;
import java.util.*;

public class DivisibleSumPair {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int n = 0, k = 0;
		
		n = scn.nextInt();
		k = scn.nextInt();
		
		scn.nextLine();
		
		int[] set = new int[n];
	    for (int x = 0; x < n; x++) {
	        set[x] = scn.nextInt();
	    }

	    for (int i = 0; i < n; i++) {
	    	System.out.print(set[i] + " ");
		}
		System.out.println("\n " + k);
		
		System.out.println(getPair(set, n, k));
    }

    public static int getPair(int[] set, int n, int k) {
    	
    	if(n==0) {
    		return 1;
    	}
    	int m = 0;
    	int[][] tail = new int[n][n];

    	for (int i = 0; i < n; i++) {
    		for ( int j = i+1; j < n; j++) {
    			System.out.println( set[i]+ " + " + set[j] + " -> "+ ((set[i] + set[j]) % k));

    			if ( tail[i][j] == 0 && ( (set[i] + set[j]) % k == 0 ) ) {
    		
	    			m += 1;
	    			
	    		}
    		}
    		
    	}

    	return m;
    }
}