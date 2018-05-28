/* https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        
        int []freq = new int[26];
        for(int i = 0; i < s.length();++i) {
            ++freq[s.charAt(i)-'a'];
        }
        
        Arrays.sort(freq);        
                
        int i=0;
        int count = 0;
        int buff=0;
        int init=0;
        boolean flag =true;
        
        for(; i < 25;++i) {      
            
           if(freq[i]!=0) {                
               if(flag) {
                init = i;
                   flag=false;
               }    
               
                if(freq[i+1]!=freq[i]) {
                    ++count; 
                    if(count==2) {
                        return "NO";
                    }
                    buff=i;
                }
           }
            
        }        
        if(buff==init) return "YES";        
        if(buff<24) return "NO";        
        if(buff==24) {
            if((freq[25]-freq[24])>1) return "NO";
        }
        
        return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
