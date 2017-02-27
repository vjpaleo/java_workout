import java.util.Scanner;
import java.util.Arrays;

public class EvenTree {
        public static void main(String[] args) {
                
                Scanner scn = new Scanner(System.in);

                int n = scn.nextInt(); 
                int m = scn.nextInt();

                int[] t = new int[n];
                int[] cnt  = new int[n];
                
                Arrays.fill(cnt, 1);

                for(int i=0; i < m; i++) {
                    int u = scn.nextInt();
                    int v = scn.nextInt();

                    t[u-1] = v;
                    cnt[v-1] += cnt[u-1];

                    int r = t[v-1];

                    while(r != 0){
                        cnt[r-1] += cnt[u-1];
                        r = t[r-1];
                    }
                }

                System.out.println("");

                int counter = -1;
                for(int i=0;i<cnt.length;i++) {
                    if(cnt[i] % 2 == 0) {
                            counter++;
                    }

                }
                System.out.println(counter);
        }

}