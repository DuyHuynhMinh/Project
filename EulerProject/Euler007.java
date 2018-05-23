import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int primeNumber(int n) {

        if(n==1) return 2;
        if(n ==2 ) return 3;
        List<Integer> ls = new ArrayList<>();
        ls.add(2);
        ls.add(3);
        int count = 2;

        int value =5;
        boolean isPrime =true;
        while(count <n) {

            for(int i : ls) {
                if(value%i==0) {
                    isPrime=false;
                    break;
                }
            }
            if(isPrime) {
                ls.add(value);
                ++count;
            }
            isPrime=true;
            value+=2;
        }
       
        return value-2;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = primeNumber(n);
            System.out.println(result);
        }
    }
}