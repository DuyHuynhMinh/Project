/* https://www.hackerrank.com/challenges/pangrams/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        
        boolean []check = new boolean [26];
        
        for(int i= 0; i< s.length();++i) {
            
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z') {
               check[s.charAt(i)-65] =true;
            }
            
             if(s.charAt(i)>='a'&&s.charAt(i)<='z') {
                check[s.charAt(i)-97] =true;
            }
        }
        
        for(int i =0; i <26;++i) {
            if(!check[i]) {
                return "not pangram";
            }
        }

        return "pangram";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
