/* https://www.hackerrank.com/challenges/and-product/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long andProduct(long a, long b) {
        // Complete this function
        long sum =a&b;
        for(long i = a+1;i<=b-1;++i) {
            sum&=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            long a = in.nextLong();
            long b = in.nextLong();
            long result = andProduct(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
