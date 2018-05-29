import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static String maxString(int n ) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int y =0; 5*y<=n;++y) {
            if((n-5*y)%3==0) {
                int x = (n-5*y)/3;
                x*=3;                
                while(x>0) {
                    sb.append('5');
                    --x;
                }
                y*=5;
                while(y>0) {
                    sb.append('3');
                    --y;
                }
                
                return sb.toString();
            }
                           
        }
        return "-1";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();            
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println (maxString(n));
            
        }

        scanner.close();
    }
}
