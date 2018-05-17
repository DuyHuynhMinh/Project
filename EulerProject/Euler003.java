import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
     public static long euler003(long n) {
        
         long r =0 ;
        if(n%2==0) {
            while(n%2==0) {
                n/=2;
            }
        }

        long i =3;
         
        long bound =(long)Math.sqrt(n);
        for( ; i <= bound+1;i+=2){
            while(n%i==0) {
                r=i;
                n/=i;
            }
        }
         if(n>1)         return n;
         
         return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long result = euler003(n);
            System.out.println(result);
        }
    }
}