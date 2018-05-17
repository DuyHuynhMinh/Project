/* https://www.hackerrank.com/challenges/flipping-bits/problem */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long flippingBits(long N) {
        // Complete this function
    
           N=~N;

      long count =0xffffffff;
      count<<=32;
        
      count=count^N;
       
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            long N = in.nextLong();
            long result = flippingBits(N);
            System.out.println(result);
        }
        in.close();
    }
}
