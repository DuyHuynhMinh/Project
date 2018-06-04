/* https://www.hackerrank.com/contests/hourrank-28/challenges/clock-delay/submissions/code/1307961389 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the lagDuration function below.
    static int lagDuration(int h1, int m1, int h2, int m2, int k) {
        // Return an integer denoting the duration of time in minutes by which the clock has been lagging.
        
        return h1*60+k*60+m1-h2*60-m2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] h1M1H2M2 = scanner.nextLine().split(" ");

            int h1 = Integer.parseInt(h1M1H2M2[0]);

            int m1 = Integer.parseInt(h1M1H2M2[1]);

            int h2 = Integer.parseInt(h1M1H2M2[2]);

            int m2 = Integer.parseInt(h1M1H2M2[3]);

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = lagDuration(h1, m1, h2, m2, k);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
