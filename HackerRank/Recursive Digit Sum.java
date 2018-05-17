/* https://www.hackerrank.com/challenges/recursive-digit-sum/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int digitSum(String n, int k) {
        // Complete this function
        BigInteger b = new BigInteger("0");
        BigInteger out ;

        for(int i =0 ; i < n.length();++i) {
            char digit = n.charAt(i);
            out=  new BigInteger(digit+"");
            b= b.add(out);
        }

        b=b.multiply(new BigInteger(Integer.toString(k)));
      
        if(b.toString().length()>=2) {
            return digitSum(b.toString(),1);
        } else {
            return Integer.parseInt(b.toString());
        }
        
        
    }
    
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        int result = digitSum(n, k);
        System.out.println(result);
        in.close();
    }
}
