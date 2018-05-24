/* https://www.hackerrank.com/challenges/k-factorization/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kFactorization function below.
    static int[] kFactorization(int n, int[] A) {
        
         Arrays.sort(A);
        Stack<Integer> st = new Stack<>();
        st.push(n);
        int index = A.length-1;
       
        while(index>=0&&n!=1){
            while(n%A[index]==0) {
                n/=A[index];
                st.push(n);
            }
            --index;
        }
        int []result;
        int size = st.size();
        if(n!=1 ) {
            result = new int[1];
            result [0] = -1;
            return result;
        }

        result = new int[size];



        for(int i = 0; i <size;++i) {
            result[i] = st.pop();
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] A = new int[k];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < k; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] result = kFactorization(n, A);

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