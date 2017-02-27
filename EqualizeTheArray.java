import java.io.*;
import java.util.*;

public class EqualizeTheArray {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int temp, n = 0;
		
		n = scn.nextInt();
		
		scn.nextLine();
		
		int[] set = new int[n];
	    for (int x = 0; x < n; x++) {
	        set[x] = scn.nextInt();
	    }

	    // sort the array
	    for (int i = 0; i < n; i++) {
	    	for (int j = i+1; j < n; j++) {
	    		if(set[i] > set[j]) {
	    			temp = set[i];
	    			set[i] = set[j];
	    			set[j] = temp;
	    		}
	    	}
	    }
	    /*
	    for (int i = 0; i < n; i++) {
	    	System.out.print(set[i] + " ");
		}
		System.out.print("\n ");
		*/
	    System.out.println(getPair(set, n));
    }

    public static int getPair(int[] set, int n) {
    	
    	if(n==0) {
    		return 1;
    	}
    	int m = 1;
    	int[] tail = new int[n];
    	int c = 0;

    	for (int i = 1; i <= n; i++) {
    		if ((i < n) && set[i-1] == set[i]) {
    		
    			if(c == 0) {
    				c = 1;
    			}
    			c += 1;
    			

    			m = Math.max(m, c);
    			//System.out.println( i + " -> " + set[i] + " -> " + m);
    			
    		} else {
    			c = 0;
    		}

    		

    	}

    	return n-m;
    }
}