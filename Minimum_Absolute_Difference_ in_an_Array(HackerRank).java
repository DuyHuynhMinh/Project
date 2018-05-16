/* https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int minimumAbsoluteDifference(int n, int[] arr) {
        // Complete this function
        Arrays.sort(arr);
        int minPair = Integer.MAX_VALUE;
        for(int i =0; i <arr.length-1;++i) {
            if(Math.abs(arr[i+1]-arr[i])<minPair){
                minPair=Math.abs(arr[i+1]-arr[i]);
            }
        }
        return minPair;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }
}