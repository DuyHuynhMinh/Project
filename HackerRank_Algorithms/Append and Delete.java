/* https://www.hackerrank.com/challenges/append-and-delete/problem */


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        
        int lenS= s.length();
        int lenT = t.length();
        if(s.equals(t)) {
            if((k%2==0)||(k>s.length())) return "Yes";
            return "No";
        }
        
        if(lenS==lenT) {
            if(k>=2*lenS) return "Yes";
        }
        
       
        int limit = Math.min(lenS,lenT);
        
        int remainLenS= 0;
        int remainLenT = 0 ;
        int i =0 ;
        while(i<limit&&s.charAt(i)==t.charAt(i)) {
            ++i;
        }
        
       
        
        
        remainLenS=lenS-i;
        remainLenT=lenT-i;     
       System.out.println(remainLenS + " " + remainLenT);
        
        if(remainLenS+remainLenT > k) return "No";        
        if((remainLenS+remainLenT+k)%2==0) return "Yes";
        
        
        return "No";


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
