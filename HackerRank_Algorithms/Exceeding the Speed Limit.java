//https://www.hackerrank.com/contests/university-codesprint-5/challenges/exceeding-speed-limit/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the solve function below.
    static void solve(int s) {
        
        if(s<=90) {
            System.out.println (0 + " " + "No punishment");
        }else if (s>=91&&s<=110) {
            s=(s-90)*300;
            System.out.println(s + " " + "Warning" );
        }else {
             s=(s-90)*500;
            System.out.println(s + " " + "License removed" );
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        solve(s);

        bufferedReader.close();
    }
}

