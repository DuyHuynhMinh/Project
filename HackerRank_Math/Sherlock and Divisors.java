/* https://www.hackerrank.com/challenges/sherlock-and-divisors/problem */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the divisors function below.
     */
    static int divisors(int n) {
        /*
         * Write your code here.
         */
        
        int input =n; 
        
        if(n%2!=0) return 0;
        int count =0;
        
        while(n%2==0) {
            ++count;
            n/=2;
        }
       
        if(n==1) {
            return count;
        }
        
        int factor =0;
        int len = (int) Math.sqrt(n);
        for(int i =3 ; i<=len+1; i=i+2) {
            if(n%i==0) {
                ++factor;
            }
        }
        
        if(len*len ==n) {
            factor*=2;
        }else{
            factor=2*factor+1;
        }
        
        return (factor+1)*count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = divisors(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
