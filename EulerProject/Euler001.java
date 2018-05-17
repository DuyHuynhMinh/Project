import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long euler001(int n ) {

      long n3=n/3;
      long n5=n/5;
      long n15=n/15;

       if(n%3==0) {
           --n3;
       }
       if(n%5==0) {
           --n5;
       }
       if(n%15==0) {
           --n15;
       }

       long s3 = (n3*(n3+1))/2;
       s3*=3;
       long s5 = (n5*(n5+1))/2;
       s5*=5;
       long s15 = (n15*(n15+1))/2;
        s15*=15;
       
        return s3+s5-s15;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
             long result = euler001(n);
        System.out.println(result);
        }
       
    }
}