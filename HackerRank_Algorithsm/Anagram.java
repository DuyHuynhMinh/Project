/* https://www.hackerrank.com/challenges/anagram/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
    
        
        if(s.length()%2!=0) return -1;
        
        int len =s.length()/2;
        
        String s1 = s.substring(0,len);
        String s2 = s.substring(len,2*len);
        
               
        int []freq = new int[26];
        
        for(int i = 0; i<len;++i) {             
            ++freq[s1.charAt(i)-'a'];
        }
        for(int i = 0; i<len;++i) {            
            --freq[s2.charAt(i)-'a'];
        }
        
        int sum =0;
        for(int i = 0; i <26;++i) {
            if(freq[i]>0) {
                sum+=freq[i];
            }
        }
        
        return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
