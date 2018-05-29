/* https://www.hackerrank.com/challenges/weighted-uniform-string/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        
        
        Map<Integer,Integer> map = new HashMap<>();
        
        map.put(s.charAt(0)-'a'+1,0);
        
        int sum = s.charAt(0)-'a'+1;
        
        for(int i = 1 ; i < s.length();++i) {
            
            if(s.charAt(i)==s.charAt(i-1)) {
                sum+=s.charAt(i)-'a'+1;
            } else{
                sum=s.charAt(i)-'a'+1;
            }
            
            map.put(sum,i);
            
        }
    
        String [] result = new String[queries.length];
        
        for(int i = 0 ; i < queries.length;++i) {
            
            if(map.containsKey(queries[i])) {
                result[i]="Yes";
            } else {
                result[i]="No";
            }
        }
        
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
