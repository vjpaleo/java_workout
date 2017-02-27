import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MarsExploration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();

        int incorrect = 0;
        
        if(S.length() > 0) {
            
            String[] sarr = S.split("(?!^)");;
            
            int i = 0;
            
            while ( i < S.length()) {
            
                if(!new String(sarr[i+0]).equals("S")) {
                    incorrect += 1;
                }

                if(!new String(sarr[i+1]).equals("O")) {
                    incorrect += 1;
                }

                if(!new String(sarr[i+2]).equals("S")) {
                    incorrect += 1;
                }
                i += 3;
            }
                            
        }

        System.out.println(incorrect);
        
    }
}