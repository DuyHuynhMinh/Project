import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int euler004(int n ) {

        int max =  Integer.MIN_VALUE;

         for(int i =999; i >100;--i) {
             for(int j =i; j >100;--j) {
                 if(((i*j)>100000)&&isPalindrome(i*j)){
                     
                     if((i*j<n)&&(i*j>max)) {
                         max=i*j;
                     }
                 }
             }
         }
        return max;
    }

    public static boolean isPalindrome(int n) {

        int m = n;
        int temp =0;
        while(n>0) {
            temp=temp*10+n%10;
            n= n/10;
        }

        return m==temp;
    }
    
    