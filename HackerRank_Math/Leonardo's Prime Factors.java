/* https://www.hackerrank.com/challenges/leonardo-and-prime/problem*/
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the primeCount function below.
     */
    static int primeCount(long n) {
        /*
         * Write your code here.
         */
       int [] table = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        
        int count =0 ;
        long p =1;
        
        for(int i = 0; i <table.length;++i) {           
            p*=table[i];
            if(p<=n) {
                ++count;
            }else{
                break;
            }
            
        }
        
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            long n = Long.parseLong(scanner.nextLine().trim());

            int result = primeCount(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
