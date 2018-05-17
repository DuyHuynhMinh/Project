/* https://www.hackerrank.com/challenges/lonely-integer/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int lonelyinteger(int[] a) {
        // Complete this function
        int result= 0;
        for(int i= 0; i <a.length;++i) {
            result^=a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = lonelyinteger(a);
        System.out.println(result);
    }
}
