/* https://www.hackerrank.com/challenges/funny-string/problem */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        
        int start =0;
        int end = s.length()-1;
        int limit= s.length()/2;
        
        for(;start <limit;++start, --end) {
            int sum1=Math.abs(s.charAt(start)-s.charAt(start+1));
            int sum2=Math.abs(s.charAt(end)-s.charAt(end-1));
            if(sum1!=sum2) {
                return "Not Funny";
            }
        }

        return "Funny";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
