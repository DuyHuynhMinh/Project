/* https://www.hackerrank.com/challenges/palindrome-index/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        
        int len = s.length()/2;
        int i = 0;
        int j = s.length()-1;
                
        for(;i<len;++i,--j) {            
           if(s.charAt(i)!=s.charAt(j))  {               
               break;
           }
        }           
        
        boolean b1= s.charAt(j-1)==s.charAt(i);
        boolean b2 = s.charAt(i+1)==s.charAt(j) ;
        
        if(b1&&b2) {           
           
            int buff1 =i;
            int buff2 = j;
            ++i;                    
            for(;i<len;++i,--j) {            
               if(s.charAt(i)!=s.charAt(j))  {               
                   return buff2;
               }
            } 
            
            return buff1;           
            
            
        } else if(b1){
            return j;
        } else  if (b2) {
            return i;
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
