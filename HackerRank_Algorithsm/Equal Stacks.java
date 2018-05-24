/* https://www.hackerrank.com/challenges/equal-stacks/copy-from/73194547 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the equalStacks function below.
     */
    static long equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
       Stack <Integer> st1 = new Stack<>();
        Stack <Integer> st2 = new Stack<>();
        Stack <Integer> st3 = new Stack<>();
        int sum1=0;
        int sum2 =0;
        int sum3=0;

        for(int i =  h1.length-1; i >=0;--i) {
            sum1+=h1[i];
            st1.push(sum1);
        }

        for(int i =  h2.length-1; i >=0;--i) {
            sum2+=h2[i];
            st2.push(sum2);
        }

        for(int i =  h3.length-1; i >=0;--i) {
            sum3+=h3[i];
            st3.push(sum3);
        }

        

        if((st1.size()<=st2.size())&&(st1.size()<=st3.size())) {

            while(!st1.empty()) {
                boolean found2 = st2.search(st1.peek())!=-1;
                boolean found3 = st3.search(st1.peek())!=-1;
                if(found2&&found3) {
                    return st1.peek();
                } else{
                    st1.pop();
                }
            }

        } else if((st2.size()<=st1.size())&&(st2.size()<=st3.size())) {
            while(!st2.empty()) {
                boolean found1 = st1.search(st2.peek())!=-1;
                boolean found3 = st3.search(st2.peek())!=-1;
                if(found1&&found3) {
                    return st2.peek();
                } else{
                    st2.pop();
                }
            }
        } else {
            while(!st3.empty()) {
                boolean found1 = st1.search(st3.peek())!=-1;
                boolean found2 = st2.search(st3.peek())!=-1;
                if(found1&&found2) {
                    return st3.peek();
                } else{
                    st3.pop();
                }
            }
        }

        return 0;




    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        long result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
