/* https://www.hackerrank.com/challenges/jim-and-the-orders/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        
        int [][] result = new int [orders.length][2];
        
        for(int i =0; i < orders.length;++i) {
            result[i][0] = orders[i][0] + orders[i][1];            
            result[i][1] = i+1;            
        }
        Arrays.sort(result,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer t1= o1[0];
                Integer t2 =o2[0];
                return t1.compareTo(t2);
            }
        });      
         
        
        int []r = new int[orders.length];
        
        for(int i = 0; i < orders.length;++i) {
            r[i] = result[i][1];
        }

        return r;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
