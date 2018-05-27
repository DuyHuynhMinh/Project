/* https://www.hackerrank.com/challenges/maximum-subarray-sum/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        
      long max = Long.MIN_VALUE;
        long []mod= new long[a.length];
        long sum=0l;

        for(int i =0 ; i < a.length;++i) {
            sum+=a[i]%m;
            sum%=m;
            mod[i] =sum;
            if(max<sum) {
                max =sum;
            }
        }

        TreeMap<Long,Integer> tree = new TreeMap<>();
        long currentMax = 0 ;

        for(int i = 0; i<mod.length;++i) {
            currentMax =0;
            tree.put(mod[i],i) ;
            if(tree.higherEntry(mod[i])!=null) {
               Map.Entry<Long,Integer> e = tree.higherEntry(mod[i]);
               long pj = e.getKey();
                currentMax = mod[i]- pj + m;
            }

            max = Math.max(max,currentMax);

        }
        return max;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
