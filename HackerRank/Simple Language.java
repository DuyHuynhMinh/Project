/* https://www.hackerrank.com/contests/w37/challenges/simple-language/submissions/code/1307633348 */


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the maximumProgramValue function below.
     */
    static long maximumProgramValue(int n,String []query) {
        /*
         * Write your code here.
         */
        BigInteger  result = new BigInteger("0");
        long len = query.length;
        
        for(int i = 0 ; i < len;++i) {
            String []parsedQuery = query[i].split(" ");
            if((parsedQuery[0].contains("add"))&&(Long.parseLong(parsedQuery[1]))>0) {
                result =result.add(new BigInteger(parsedQuery[1]));
            }
            
            if((parsedQuery[0].contains("set"))&&(Long.parseLong(parsedQuery[1]))>result.longValue()) {
                result =new BigInteger(parsedQuery[1]);
            }
            
            
        }
        
        
        
        return result.longValue();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        
        String []query = new String[n];
        
        for (int i = 0;i < n;i++) {            
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            query[i] = scanner.nextLine();
        }


        long result = maximumProgramValue(n,query);

        bufferedWriter.write(String.valueOf(result));
       
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
