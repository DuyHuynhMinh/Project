/* https://www.hackerrank.com/challenges/sparse-arrays/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static int[] solve(String[] strings, String[] queries) {
        
        Map<String,Integer> map = new HashMap<>();
        
        int []result= new int[queries.length];
        
        for(int i = 0; i<strings.length;++i) {
            int count =1;
            if(map.containsKey(strings[i])) {
                count = map.get(strings[i]);
                ++count;
            }
            
            map.put(strings[i],count);
        }

        for(int i =0; i < queries.length;++i) {
            
            int count =0;
            if(map.containsKey(queries[i])) {
                count =map.get(queries[i]);
            }
            result[i]  = count;   
            
        }    
               
        return result;       

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = solve(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
