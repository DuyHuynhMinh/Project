/* https://www.hackerrank.com/challenges/big-sorting/problem */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the bigSorting function below.
     */
    static String[] bigSorting(String[] s) {
        /*
         * Write your code here.
         */
        Arrays.sort(s, (left, right) -> {
            if (left.length() != right.length()) {
                return left.length() - right.length();
            } else {
                return left.compareTo(right);
            }
        });
        return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String[] unsorted = new String[n];

        for (int unsortedItr = 0; unsortedItr < n; unsortedItr++) {
            String unsortedItem = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            unsorted[unsortedItr] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(result[resultItr]);

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
