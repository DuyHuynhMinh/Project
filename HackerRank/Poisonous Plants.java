/* https://www.hackerrank.com/challenges/poisonous-plants/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(long[] p) {
        
        Stack<Long> st1 = new Stack<>();
        Stack<Long> st2 = new Stack<>();

        int day =1 ;
        boolean check =true;

        st1.push(p[0]);

        for(int i = 1;i<p.length;++i ) {
            if(p[i]<=p[i-1]) {
                st1.push(p[i]);
            }
        }

        int lenSt2 = 0;
        int lenSt1 =st1.size();
        if(lenSt1==p.length) return 0;

        while(check) {
            check = false;

            while(!st1.empty()){
                st2.push(st1.pop());
            }

            lenSt2 = st2.size();

                      
            if(st2.empty()) return day;
            long preValue = st2.peek();

            while(!st2.empty()){
                long value = st2.pop();
                if(value<=preValue) {
                    st1.push(value);
                }
                preValue=value;

            }
           
            lenSt1 =st1.size();

            if(lenSt2!=lenSt1) {
                check=true;
            }
            ++day;
        }
        return day-1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] p = new long[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long pItem = Long.parseLong(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
