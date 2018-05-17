/* https://www.hackerrank.com/challenges/staircase/problem */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the staircase function below.
     */
    static void staircase(int n) {
        /*
         * Write your code here.
         */
         int space =n-1;
        for(int i=1; i<=n;++i) {
            int number = 1;
            int spaceInLine =1;
            while(number <=n) {

                if(spaceInLine<=space) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
                ++number;
                ++spaceInLine;
            }
            System.out.println();
            --space;
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        staircase(n);
    }
}
