import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
     public static int smallestMultiple(int n) {
        if(n==1||n==2) return n;
        if (n==3) return 6; 
        int a =2;
        int b = 3;
        int result = a*b;
        for (int i =4;i<=n;++i) {
            int gcd = GCD(result,i);
            result=(result*i)/gcd;
        }
        return result;
    }

    public static int GCD(int a, int b) {
        if(a%b==0) return b;
        if( b%a==0) return a;

        return GCD(b,a%b);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result =smallestMultiple(n);
            System.out.println(result);
        }
    }
}