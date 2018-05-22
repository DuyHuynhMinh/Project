/* https://www.hackerrank.com/challenges/crush/problem */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int m, int[][] queries) {
        
        long []table = new long[n+1];
        
        for(int i = 0 ; i <m;++i ){
            int startIndex = queries[i][0];     
            
             int endIndex = queries[i][1];
            
             long value  = queries[i][2];
            
            table[startIndex]+=value;
            if(endIndex+1<=n) {
               
                table[endIndex+1]-=value;
            }
            
        }
        
        long maxSum =Long.MIN_VALUE;
        long sum =0;
        for(int i = 1; i <=n; ++i) {
            sum+=table[i];
            if(sum>maxSum) {
                maxSum=sum;
            }
        }
        
        return maxSum;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n,m, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
