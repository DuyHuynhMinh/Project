/* https://www.hackerrank.com/challenges/angry-children/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int angryChildren(int k, int[] arr) {
        // Complete this function
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 0; i <arr.length-k+1;++i) {
            if(min>(arr[i+k-1]-arr[i])) {
                min = arr[i+k-1] -arr[i];
            }
        }
               return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = angryChildren(k, arr);
        System.out.println(result);
        in.close();
    }
}