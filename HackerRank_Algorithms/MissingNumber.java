/* https://www.hackerrank.com/challenges/missing-numbers/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] missingNumbers(int[] arr, int[] brr) {
        // Complete this function
        
        int count =1;
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < brr.length;++i) {
            if(map.containsKey(brr[i])) {
                count = map.get(brr[i]);
                ++count;
            } else {
                count =1;
            }
            map.put(brr[i],count);

        }
     
      for(int i = 0; i < arr.length; ++ i) {
            count = map.get(arr[i]);
            --count;
            map.put(arr[i],count);
        }

        
        Set<Integer> set = map.keySet();

        int size = 0;
        for(int k : set) {
            if(map.get(k)>0) {
                ++size;
            }
        }

        int j = 0;
        int [] result = new int [size];      
        
        for(int k : set) {
            if(map.get(k)>0) {
                result[j] = k;
                ++j;
            }
        }
         
        return result;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
