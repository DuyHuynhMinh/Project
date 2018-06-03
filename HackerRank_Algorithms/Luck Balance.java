/* https://www.hackerrank.com/challenges/luck-balance/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int n, int k, int[][] contests) {
        
        Arrays.sort(contests,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer t1= o1[0];
                Integer t2 =o2[0];
                return t2.compareTo(t1);
            }
        });
        
        int sum =0;
        int count =0;
        
        for(int i = 0; i < contests.length;++i ){
                        
            if(contests[i][1] ==0) {
                sum+=contests[i][0];
            }
            
            if(contests[i][1] ==1) {                
                if(count <k) {
                    sum+=contests[i][0];
                } else{
                     sum-=contests[i][0];
                }
                ++count;
            }
            
        }
    
        return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(n, k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
