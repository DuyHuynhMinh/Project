/* https://www.hackerrank.com/challenges/caesar-cipher-1/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        
       if(k>26){
           k=k%26;
       }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <s.length();++i  ) {
            
            boolean r1 = s.charAt(i)>='a'&&s.charAt(i)<='z';
            boolean r2 = s.charAt(i)>='A'&&s.charAt(i)<='Z';
            
            if((r1&&s.charAt(i)+k>'z')||(r2&&s.charAt(i)+k>'Z')) {
                sb.append((char)(s.charAt(i)+k-26));           
            } else if(r1||r2){
                 sb.append((char)(s.charAt(i)+k));
            } else{
                 sb.append((char)(s.charAt(i)));
            }
        }
        
        return sb.toString();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
