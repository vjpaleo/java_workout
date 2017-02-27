import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class ModifiedFibonacci {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t1 = scn.nextInt();
        int t2 = scn.nextInt();
        int n = scn.nextInt();

        System.out.println(calculateModifiedFib(t1, t2, n));
        

    }

    public static BigInteger calculateModifiedFib(int a, int b, int n) {

    	// modified formula
        // t(n+2) = t(n) + t(n+1)2
        
        BigInteger[] fib_of_all = new BigInteger[n+2];
        fib_of_all[0] = BigInteger.valueOf(a);
        fib_of_all[1] = BigInteger.valueOf(b);



        BigInteger fib_of_n =  BigInteger.valueOf(0);

        //fib_of_n = (fib_of_n+2) - (fib_of_n+1)2;

        for(int c = 2; c < n+2; c++) {
        	fib_of_all[c] = fib_of_all[c-2].add(fib_of_all[c-1].pow(2));
        }

        return fib_of_all[n-1];
    }
}