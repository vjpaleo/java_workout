import java.io.*;
import java.util.*;

public class OddEven {

	Scanner scanner = new Scanner(System.in);

	int num;

	public void setNum(int n) {
		this.num = n;
	}

	public int getNum() {
		return this.num;
	}

	public void process() {

		int index = 0;
		int num = getNum();
		while (index <= num) {

			char[] myStrArr = this.scanner.nextLine().toCharArray();
			String odd = "";
			String even = "";
			for (int i = 0; i < myStrArr.length; i++) {
				if(i % 2 == 0) {
					even += myStrArr[i];
				} else {
					odd += myStrArr[i];
				}
			}
			if(myStrArr.length > 1) {
				System.out.println(even + " " + odd);	
			}
			

			index++;
		}
	}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        OddEven sol = new OddEven();
        sol.setNum(sol.scanner.nextInt());
        sol.process();

    }
}