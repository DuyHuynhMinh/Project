/* https://www.hackerrank.com/challenges/strong-password/problem */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int minimumNumber(int n, String s) {
        // Return the minimum number of characters to make the password strong
        String  numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean []check = new boolean[4];
        int count =0;

        for(int i = 0; i < s.length();++i) {
            if(numbers.indexOf(s.charAt(i))!=-1) {
                check[0]=true;
            } else if(lower_case.indexOf(s.charAt(i))!=-1){
                check[1]=true;
            } else if(upper_case.indexOf(s.charAt(i))!=-1) {
                check[2]=true;
            }else if(special_characters.indexOf(s.charAt(i))!=-1) {
                check[3] = true;
            }
        }

        for(boolean b : check) {
            if(!b) ++count;
        }

        if (s.length() + count < 6) {
            return count +(6-(s.length()+count));
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
