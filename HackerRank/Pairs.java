/* https://www.hackerrank.com/challenges/pairs/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int pairs(int k, int[] arr) {
        // Complete this function
        Set<Integer> mySet = new HashSet<>();
        int count = 0;
        for(int i =0 ; i < arr.length; ++i ) {
            if(mySet.contains(-k+arr[i])) {
                ++count;
            }
            if(mySet.contains(k+arr[i])) {
                ++count;
            }
            mySet.add(arr[i]);
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = pairs(k, arr);
        System.out.println(result);
        in.close();
    }
}
