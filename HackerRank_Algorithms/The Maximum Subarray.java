/* https://www.hackerrank.com/challenges/maxsubarray/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
        
        int sumSubArray = Integer.MIN_VALUE; 
        int sumSubSequence = 0 ;
        int currentSum =0;        
        int max = Integer.MIN_VALUE;    
        
        for(int i = 0 ; i < arr.length;++i ) {            
            max = Math.max(max,arr[i]);           
            
            if(arr[i] >0) {
                sumSubSequence+=arr[i];
            }            
            currentSum+=arr[i];
            if(currentSum<0) {
                currentSum=0;
            }                
            sumSubArray = Math.max(sumSubArray,currentSum);            
            
        }
        
        if(max<0) {
            sumSubArray = max ;
            sumSubSequence = max;
        }
        
        int [] result = new int [2];
        result[0] = sumSubArray;
        result[1] = sumSubSequence;
        
        return result;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
