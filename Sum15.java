import java.util.HashMap;
import java.util.Map;

public class Sum15
{

    public static void main(String args[])
    {
        // create tests to validate the problem
        Map<String, Boolean> tests = new HashMap();

        tests.put("a8b!!!c3", false);
        tests.put("a8b!!!c7", true);
        tests.put("abc", true);
        tests.put("a8b1", true);
        tests.put("a8b1a8b!!!c3", false);
        tests.put("a8b1a8b!a!!c7", true);
        tests.put("10!!!6", false);
        tests.put("14!!!1", true);
        tests.put("15!!!0", true);

        // loop through each test to validate the output with expected value.
        for (Map.Entry<String, Boolean> entry : tests.entrySet()) {
            if (Sum15.validate(entry.getKey()) == entry.getValue()) {
                System.out.println("Test passed!");
            } else {
                System.out.println("Test failed!");
            }
        }

    }

    /**
     * Validate if the given string passed the problem condition.
     * @param str String
     * @return boolean
     */
    static boolean validate(String str)
    {
        int firstNum = -1;
        int secondNum = -1;
        int countExclamations = 0;

        int strLen = str.length();

        boolean result = true;

        for (int idx = 0; idx < strLen; idx++) {

            // find number in the string from index idx.
            int num = Sum15.findNumber(str, strLen, idx);

            if (num > -1) {
                // increment index by number of digits found in the number.
                idx += Integer.toString(num).length() - 1 ;
                if (firstNum == -1) {
                    firstNum = num;
                } else if (firstNum > -1) {
                    secondNum = num;
                    if (countExclamations == 3 && (firstNum + secondNum) != 15) {
                        result = false;
                        break;
                    }
                    // make second number as first number
                    firstNum = secondNum;
                    // reset the second number
                    secondNum = -1;
                    // reset the exclamation counts to 0
                    countExclamations = 0;
                }
            }
            // count !s
            if (firstNum > -1 && secondNum == -1) {
                if (str.charAt(i) == '!') {
                    countExclamations++;
                }
            }
        }
        return result;
    }

    /**
     * Find and return the possible number in the string from the idx passed in param.
     * @param str String Actual string
     * @param len int length of the string.
     * @param idx int current index
     * @return int
     */
    static int findNumber(String str, int len, int idx)
    {
        // consider we only need to find the number greater than 0.
        // default the number to -1 which is invalid for this problem
        int num = -1;

        // Create a string buffer in case the number is multi-digit.
        StringBuffer strBuff = new StringBuffer();
        while (idx < len) {
            if (Character.isDigit(str.charAt(idx))) {
                strBuff.append(str.charAt(idx));
            } else {
                break;
            }
            idx++;
        }

        if (strBuff.length() > 0) {
            num = Integer.parseInt(strBuff.toString());
        }
        return num;
    }
}
