/* https://www.hackerrank.com/challenges/largest-rectangle/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        
         Stack<Integer> st = new Stack<>();

        long maxArea = -1;
        long weight =0;

        int i = 0 ;
        while(i<h.length) {

            if (st.empty() || h[i] > h[st.peek()]) {

                st.push(i++);

            } else {

                int peek = st.pop();

                if (st.empty()) {
                    weight = i;
                } else {
                    weight = i - st.peek()-1;
                }
                maxArea = Math.max(maxArea, weight * h[peek]);
            }
        }
            while (!st.empty()) {
                int peek = st.pop();
                if(st.empty()) {
                    weight = i;
                } else {
                    weight = i - st.peek()-1;
                }
                maxArea= Math.max(maxArea,weight*h[peek]);
            }
        return maxArea;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
