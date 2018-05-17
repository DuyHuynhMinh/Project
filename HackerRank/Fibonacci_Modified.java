/* https://www.hackerrank.com/challenges/fibonacci-modified/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger temp = new BigInteger("0");
        BigInteger[]table = new BigInteger[n+1];
        table[1]= new BigInteger(Integer.toString(t1));
        table[2] = new BigInteger(Integer.toString(t2));;
        for(int i = 3 ; i<=n;++i) {
            temp= table[i-1].multiply(table[i-1]);
            table[i] = temp.add(table[i-2]);
        }
        return table[n];
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t1 = in.nextInt();
        int t2 = in.nextInt();
        int n = in.nextInt();
        BigInteger result = fibonacciModified(t1, t2, n);
        System.out.println(result);
        in.close();
    }
}
