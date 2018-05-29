/* https://www.hackerrank.com/challenges/happy-ladybugs/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        
        int []table= new int[26];
        boolean isUnderscore = false;
        
        for(int i = 0 ; i < b.length();++i) {
            if(b.charAt(i)!='_') {
             table[b.charAt(i)-'A']++;
            } else{
                isUnderscore =true;
            }
        }
    
        for(int i =0; i <26;++i) {
            if(table[i]==1) return "NO";
        }
        
        if(!isUnderscore) {
            for(int i = 0; i <b.length()-2;++i) {
                if((b.charAt(i+1)!=b.charAt(i))&&(b.charAt(i+1)!=b.charAt(i+2))) {
                    return "NO";
                }
            }
        }
    
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
