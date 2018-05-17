import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long  sumSquareDifference (long n ) {
        return Math.abs(n*(-3*n*n*n+3*n-2*n*n+2)/12);

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long result = sumSquareDifference(n);
            System.out.println(result);
        }
    }
}