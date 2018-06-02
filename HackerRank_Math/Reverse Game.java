/* https://www.hackerrank.com/challenges/reverse-game/problem */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static int reverse(int n, int k) {
        
        int bound = (n-1)/2;
        if((n-1)%2!=0) {
            ++bound;
        }
        
        if(k<bound) {
            //Odd
            return 2*k+1;
        } 
            //even
         return  2*(n-1-k);
        
        
    } 


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
   
        for(int i =0; i <t;++i) {
            String[] nk = scanner.nextLine().split(" ");     
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int result = reverse(n,k);
            System.out.println(result);
        }

        scanner.close();
    }
}
