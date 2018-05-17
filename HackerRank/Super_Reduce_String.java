/* https://www.hackerrank.com/challenges/reduced-string/problem */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the super_reduced_string function below.
    static String super_reduced_string(String s) {
        
    StringBuilder sb = new StringBuilder (s);
        for(int i = 0; i < sb.length()-1;++i) {
             while((i>=0)&&(i<sb.length()-1)&&(sb.charAt(i)==sb.charAt(i+1))) {
                sb.delete(i,i+2);
                --i;
            }

        }
        if(sb.length()>0)       return sb.toString();
        
        return "Empty String";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = super_reduced_string(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
