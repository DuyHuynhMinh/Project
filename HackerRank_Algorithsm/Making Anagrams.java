/* https://www.hackerrank.com/challenges/making-anagrams/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        
        int []freqS1 = new int[26];
        int []freqS2 = new int[26];
        
        for(int i = 0 ; i < s1.length();++i) {
            ++freqS1[s1.charAt(i)-'a'];
        }
        for(int i = 0 ; i < s2.length();++i) {
            ++freqS2[s2.charAt(i)-'a'];
        }
        int count =0;
        for(int i= 0; i <26;++i) {
            count+=Math.abs(freqS1[i]-freqS2[i]);
        }
        
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
