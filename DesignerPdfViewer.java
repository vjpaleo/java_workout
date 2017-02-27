// DesignerPdfViewer
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DesignerPdfViewer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i=0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        
        int maxh = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] words = word.toCharArray();
        
        for (int i = 0; i < words.length; i++ ) {
            maxh = Math.max(maxh,  h[ new String(alphabet).indexOf(words[i]) ]);
        }
        
        System.out.println(word.length() * maxh);
    }
}