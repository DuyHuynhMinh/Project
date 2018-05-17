/* https://www.hackerrank.com/challenges/greedy-florist/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getMinimumCost(int n, int k, int[] c){
        // Complete this function
        Arrays.sort(c);
        int num =1;
        int sum = 0;
        int total = 0 ;
        for(int i = c.length -1; i>=0;i=i-k) {
            sum=0;
            for(int j=i;j>=0&&j>i-k;--j){
                sum+=c[j];
            }
            total+=sum*num;
            ++num;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int minimumCost = getMinimumCost(n, k, c);
        System.out.println(minimumCost);
    }
}
