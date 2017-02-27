import java.util.*;
import java.io.*;

public class DecToBin {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int max = 0;
		int m = 0;
		while (n > 0) {
			int r = n % 2;
			n = n / 2;

			if (r == 1) {
				max += 1;
			} else {
				max = 0;
			}

			if(max > m) {
				m = max;
			}
		}

		System.out.println(m);
	}
} 