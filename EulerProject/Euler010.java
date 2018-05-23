import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
     static long sumPrime(int n) {

        boolean []table = new boolean[n+1];
        for(int i =2 ; i <=n;++i) {
            table[i] = true;
        }
        int p= 2;
        while(p<=n) {
            int init =2;
            if(2*p>n) {
                break;
            }
            while(init*p<=n) {
                table[init*p] = false;
                ++init;
            }
            for(int i=p+1; i<=n;++i) {
                if(table[i]) {
                    p=i;
                    break;
                }
            }
        }
         
        long sum =0;
        for(int i = 2 ; i <= n;++i) {
            if(table[i]) {
                sum+=i;
            }
        }      
         return sum;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long result = sumPrime(n);
            System.out.println(result);
        }
    }
}