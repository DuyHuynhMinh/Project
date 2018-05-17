/* https://www.hackerrank.com/challenges/string-reduction/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stringReduction function below.
    static int stringReduction(String s) {
        
        int []r = new int[3];
        
        for(int i = 0; i < s.length();++i) {
            ++r[s.charAt(i) -'a'];
        }
        
        int count =0;
        for(int i = 0;i <3;++i){
            if(r[i]==0) {
                ++count;
            }
        }
        if(count>=2) {
            return s.length();
        }
         
        if(r[0]%2==0&&r[1]%2==0&&r[2]%2==0) {
            return 2;
        }
        
        if((r[0]+1)%2==0&&(r[1]+1)%2==0&&(r[2]+1)%2==0) {
            return 2;
        }
        
        return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            int result = stringReduction(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
