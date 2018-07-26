// https://www.hackerrank.com/challenges/drawing-book/problem

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        
        
        if(p==1||n==p) {return 0;}
        
        int front =0;        
        int end =0;
        
        if(p%2==0) {
            front =p/2;
        }else {
            front=(p-1)/2;
        }
        
        
        if(n%2==0) {
            --p;
        }
        if((n%2==0&&p%2==0)||(n%2!=0&&p%2!=0)) {
            end=(n-p)/2;
        }else{
            end=(n-p-1)/2;
        }
        
        return Math.min(front,end);
            

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

