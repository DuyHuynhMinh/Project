/* https://www.hackerrank.com/contests/hourrank-27/challenges/impressing-the-boss/problem */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the canModify function below.
     */
    static String canModify(int[] a) {
        /*
         * Write your code here.
         */
        
       
        
        int count = 0;
        int index =0;
        int temp=0;    
        
        for(int i = 0; i < a.length-1;++i) {            
            if( (a[i+1]-a[i])<0) {
                index = i;
                temp=a[i];
                a[i] =a[i+1];
                break;
            }          
        }
        
        
        for(int i = 0 ; i<a.length-1;++i) {            
            if((a[i+1]-a[i])<0) {
                ++count;
                break;
            }
        }
        
        if(count ==0 ) return "YES";
         
        a[index] = temp;
        a[index+1] = temp;
        for(int i = 0 ; i<a.length-1;++i) {            
            if((a[i+1]-a[i])<0) {
                ++count;
                break;
            }
        }
            
            if(count==2) return "NO";
        
        return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr]);
                a[aItr] = aItem;
            }

            String result = canModify(a);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
