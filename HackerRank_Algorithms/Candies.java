/* https://www.hackerrank.com/challenges/candies/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static int candies(int n, int[] arr) {
        
        int []results = new int[arr.length];
        
        for(int i = 0; i < arr.length;++i) {
            results[i]= 1;
        }
        
        for(int i =1; i < arr.length;++i ) {
            if(arr[i]>arr[i-1]) {
                results[i] = results[i-1] +1;
            }
        }
        
        for(int i = arr.length -2; i >=0; --i ) {
            
            if((arr[i] >arr[i+1])&&(results[i]<=results[i+1])){
                results[i] = results[i+1]+1;
            }
            
        }
               
               int sum =0;
               for(int i =0; i<arr.length;++i) {
                   sum+=results[i];
               }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
