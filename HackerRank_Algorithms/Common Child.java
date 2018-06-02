/* https://www.hackerrank.com/challenges/common-child/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String S, String T) {
            int[][]dp = new int[S.length()][T.length()];
        if(S.charAt(0)==T.charAt(0)) {
            dp[0][0] = 1;
        }else{
            dp[0][0] = 0;
        }
        for(int j = 1; j < T.length();++j) {
            if(S.charAt(0)==T.charAt(j)) {
                dp[0][j] = 1;
            }else{
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i =1; i< S.length();++i) {
            if(S.charAt(i)==T.charAt(0)) {
                dp[i][0] = 1;
            } else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for( int i = 1; i < S.length(); ++i ) {
            for(int j = 1 ; j<T.length();++j) {
                if(S.charAt(i)!=T.charAt(j)) {
                    dp[i][j] =Math.max(dp[i-1][j],dp[i][j-1]);
                } else{
                    dp[i][j]=1+dp[i-1][j-1];
                }

            }
        }
        return dp[S.length()-1][T.length()-1];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
