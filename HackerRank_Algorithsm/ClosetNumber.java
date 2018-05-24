/* https://www.hackerrank.com/challenges/closest-numbers/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] closestNumbers(int[] arr) {
        // Complete this function
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr) ;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length-1;++i) {          
            if(min>(arr[i+1]-arr[i])) {
                min = arr[i+1] - arr[i];                
            }      
           
        }
        for(int i = 0; i < arr.length-1;++i) {          
            if(min==(arr[i+1]-arr[i])) {
                list.add(arr[i]);
                list.add(arr[i+1]);
            }      
           
        }
        
        
        int []a = new int [list.size()];
        int j =0;
        for(int i : list) {
            a[j] = i;
            ++j;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = closestNumbers(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
