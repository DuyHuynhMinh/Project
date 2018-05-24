/* https://www.hackerrank.com/challenges/sherlock-and-minimax/problem */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndMinimax function below.
    static int sherlockAndMinimax(int[] a, int p, int q) {
        
         Arrays.sort(a);

        int maxIndex = 0;
        int startIndex =0;
        int endIndex = 0 ;

        int min = Integer.MAX_VALUE;
        int maxOfMin = Integer.MIN_VALUE;
        int result =0;

        for(int i =0 ; i <a.length;++i) {
            if(a[i]<p) {
                ++startIndex;
            }
            if(a[i]<q) {
                ++endIndex;
            }
            if(a[i]>q) {
                break;
            }
        }

        if(startIndex == 0) {
            maxOfMin = a[0] -p;

        } else {
            maxOfMin =Math.max(p-a[startIndex-1],a[startIndex]-p);
        }
        result = p;

        if(q > a[a.length-1]) {
            maxOfMin = Math.max(maxOfMin,q-a[a.length-1]);
        } else {
            min = Math.min(a[endIndex]-q,q-a[endIndex-1]);
        }
        if(maxOfMin < min){
            maxOfMin = min;
            result =q;
        }
        
        if(q>a[a.length-1]||endIndex==a.length-1) {
            --endIndex;
        }

        for(int i = startIndex; i <  endIndex;++i) {
            int value =(a[i+1] - a[i])/2;
            if(value > maxOfMin) {
                maxOfMin =value;
                maxIndex=i;
                result= a[i]+value;
            }
        }        

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        String[] pq = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pq[0]);

        int q = Integer.parseInt(pq[1]);

        int result = sherlockAndMinimax(arr, p, q);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
