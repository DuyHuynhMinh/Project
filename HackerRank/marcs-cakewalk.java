/* https://www.hackerrank.com/challenges/marcs-cakewalk/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long marcsCakewalk(int[] calorie) {
        // Complete this function
        Arrays.sort(calorie);
        long sum =0;
        for(int i=0;i<calorie.length;++i) {
            sum+=Math.pow(2,calorie.length-i-1)*calorie[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calorie = new int[n];
        for(int calorie_i = 0; calorie_i < n; calorie_i++){
            calorie[calorie_i] = in.nextInt();
        }
        long result = marcsCakewalk(calorie);
        System.out.println(result);
        in.close();
    }
}
