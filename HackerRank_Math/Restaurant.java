import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the restaurant function below.
     */
    static int restaurant(int l, int b) {
        /*
         * Write your code here.
         */
        int length = GCD(l,b);
        
        return (l*b)/(length*length);

    }
    
     public static int GCD(int a, int b) {

        if(a%b==0)
        {           
            return b;
        }else {
            return GCD(b%a, a);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] lb = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int l = Integer.parseInt(lb[0]);

            int b = Integer.parseInt(lb[1]);

            int result = restaurant(l, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
