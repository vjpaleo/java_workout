import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int n = 0;
		int k = 0;
		
		n = scn.nextInt();
		k = scn.nextInt();

		scn.nextLine();
		
		int[] set = new int[n];
	    for (int x = 0; x < n; x++) {
	        set[x] = scn.nextInt();
	    }

	    int[] tail = new int[n];

	    int max_lss = 0;

	    max_lss = Math.max(max_lss, getLss(set, n, k, tail, 1));
	    System.out.println(max_lss);
    }

    public static int getLss(int[] set, int n, int k, int[] tail, int len) {
    	
    	if(n==0) {
    		return 1;
    	}

    	if(k==1) {
    		return 1;
    	}

    	int cur_idx = n - 1;
    	if( tail[cur_idx] == 0 ) {
    		if( cur_idx > 0 && Math.abs(set[cur_idx] - set[cur_idx - 1]) <= k) {
				len += 1; 
			} else {
				len = 1;
			}
			System.out.println(cur_idx + " - " + len);
			tail[cur_idx] = Math.max(len, getLss(set, cur_idx, k, tail, len)); 
    	}
    	return tail[cur_idx];
    	
    }
}