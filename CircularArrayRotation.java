//Circular Array Rotation

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CircularArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int r= k % n;
        
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            if( (m-r) >=0) {
				System.out.println(a[(m-r)]);
           } else {
           		System.out.println(a[(m-r) + a.length]);
           }
            
        }
    }
}
