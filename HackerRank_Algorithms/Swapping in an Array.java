// https://www.hackerrank.com/contests/101hack55/challenges/swapping-in-an-array/submissions/code/1308981759

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the swapToSort function below.
    static int swapToSort(int[] a) {
        // Return -1 or 0 or 1 as described in the problem statement.
        
        int []b= new int[a.length];
        for(int i= 0; i<a.length;++i) {
            b[i]=a[i];
        }        
        Arrays.sort(b);
        int count =0 ;
        
        for(int i =0 ; i <a.length;++i) {
            if(a[i]!=b[i]) {
                ++count;
            }
        }
        
        switch (count) {
            case 0 :
                return 0;
            case 2 :
                return 1;
                           
        }
        
        return -1;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = swapToSort(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
