/* https://www.hackerrank.com/challenges/the-great-xor/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long theGreatXor(long x){
        // Complete this function
        int r=64-Long.numberOfLeadingZeros(x);
       long check = 1;
       long count =0;
       for(int i = 0; i<r ;++i){
           if((x&check)==0) {
               count+=Math.pow(2,i);
           }
           check<<=1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }
}
