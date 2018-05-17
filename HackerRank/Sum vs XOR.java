/* https://www.hackerrank.com/challenges/sum-vs-xor/problem */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long solve(long n) {
        // Complete this function
        
        int r=64-Long.bitCount(n)-Long.numberOfLeadingZeros(n);
        return (long)Math.pow(2,r);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);
    }
}
