/* https://www.hackerrank.com/challenges/coin-change/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the getWays function below.
    static long getWays(int n, long[] a) {
        
        long [][]dp = new long [n+1][a.length];
        for(int i = 0; i<a.length;++i) {
            dp[0][i] =0;
        }
        int i =1;
        for( i = 1; i<=n;++i) {

            if(i%a[0]==0) {
                dp[i][0] = 1;
            } else {
                dp[i][0] =0;
            }

            for(int j =1; j <a.length;++j) {
                if(i-a[j]<0) {
                    dp[i][j] = 0;
                    dp[i][j] =dp[i][j-1];
                } else{
                    dp[i][j] =dp[i][j-1]+dp[(int)(i-a[j])][j];
                }
                if(i==a[j]) {                    
                    ++dp[i][j];
                }

            }
        }
       
        return dp[n][a.length-1];


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.close();

        scanner.close();
    }
}
