/* https://www.hackerrank.com/challenges/gem-stones/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        
         boolean [][]A = new boolean[arr.length][];
        for(int i =0; i <arr.length; ++i ) {
            A[i] = new boolean[26];
        }
        
        for(int j =0; j < arr.length;++j) {
            for(int i = 0; i < arr[j].length();++i) {            
                A[j][arr[j].charAt(i)-'a'] = true;                        
            }
        }
                
        int count =0;
        for(int j = 0; j < 26;++j) {
            boolean result = true;
            for(int i = 0; i <arr.length;++i) {
                result=result&&A[i][j];
            }
            if(result) {
                ++count;
            }
        }
        
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));       
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
