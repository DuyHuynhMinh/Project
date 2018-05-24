/* https://www.hackerrank.com/challenges/maximizing-xor/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int maximizingXor(int l, int r) {
        // Complete this function
        int max = Integer.MIN_VALUE;
        for (int i = l; i<=r;++i) {
            for(int j = l;j <=r;++j) {
                if(max<(i^j)){
                    max =i^j;
                }
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int result = maximizingXor(l, r);
        System.out.println(result);
        in.close();
    }
}