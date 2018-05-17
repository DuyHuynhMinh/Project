/* https://www.hackerrank.com/challenges/an-interesting-game-1/problem */
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the gamingArray function below.
     */
    static String gamingArray(int[] arr) {
        /*
         * Write your code here.
         */
        int turn =0;
        int pivot = arr.length;
        
        while(pivot>0) {
            ++turn;
            pivot = findMax(arr,pivot);
        }
        
        if(turn%2==0) {
            return "ANDY";
        }
        
        return "BOB";
    }
    
    static int findMax(int []arr, int pivot) {
        int max = Integer.MIN_VALUE;
        int indexMax = 0; 
        for(int i= 0; i <=pivot-1;++i) {
            if(max<arr[i]) {
                max = arr[i];
                indexMax = i;
            }
        }
        
        return indexMax;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            int arrCount = Integer.parseInt(scanner.nextLine().trim());

            int[] arr = new int[arrCount];

            String[] arrItems = scanner.nextLine().split(" ");

            for (int arrItr = 0; arrItr < arrCount; arrItr++) {
                int arrItem = Integer.parseInt(arrItems[arrItr].trim());
                arr[arrItr] = arrItem;
            }

           String result = gamingArray(arr);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
