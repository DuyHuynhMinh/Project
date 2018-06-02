/* https://www.hackerrank.com/challenges/pylons/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pylons function below.
    static int pylons(int k, int[] arr) {
        
        --k;
        
        TreeMap<Integer,Integer> tree = new TreeMap<>();
        
        for(int i =0 ; i < arr.length;++i  ) {
            if(arr[i] ==1) {
                tree.put(i,0);
                
            }
        }
        
        int firstKey = tree.firstKey();
        int lastKey = tree.lastKey();
        if(firstKey>k){
                return -1;
        } 
            
        if((lastKey+k)<(arr.length-1)) {
                return -1;
        }
        
        
        
        int count =1;
        int nextValue =0;
        int actualValue = tree.lowerKey(k);
       
        while(nextValue<lastKey||nextValue +k<= arr.length-1) {
           
            nextValue = actualValue+2*k+1;             
            
            if(tree.containsKey(nextValue)) {
                actualValue = nextValue;
            }else{
             actualValue = tree.lowerKey(nextValue);  
            }            
            nextValue =actualValue;         
            ++count;
             
            
        }
        
        return count;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pylons(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
