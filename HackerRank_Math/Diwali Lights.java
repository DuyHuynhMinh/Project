/* https://www.hackerrank.com/challenges/diwali-lights/problem */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the lights function below.
     */
    static long lights(int n) {
        /*
         * Write your code here.
         */
        
        int p = n/62;
        int r = n%62;
        long result =1;
        for(int i =0 ; i <p;++i) {
            result*=(long)Math.pow(2,62)%100000;
            result%=100000;
            
        }
        result*=(long)Math.pow(2,r)%100000;
        result%=100000;
        return result-1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            long result = lights(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
