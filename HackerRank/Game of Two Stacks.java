/* https://www.hackerrank.com/challenges/game-of-two-stacks/problem */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */
        Stack<Long> sumStack =new Stack<>();
        long sum =0;
        for(int i = 0; i <a.length;++i) {

            sum+=a[i];
            if(sum>=x){
                break;
            }
            sumStack.push(sum);
        }
        int maxScore = sumStack.size();

        int i = 0;
        int sumB=0;
      
        for(; i < b.length; ) {

            if(sumB>=x) {
                break;
            }


            if(!sumStack.empty()&&(sumB+sumStack.peek())>x){
                sumStack.pop();
            } else {
                sumB+=b[i];
                ++i;
            }

            maxScore = Math.max(maxScore,sumStack.size()+i-1);


        }
        
        

        return maxScore;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
