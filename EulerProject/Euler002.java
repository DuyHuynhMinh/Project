import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
     public static BigInteger euler002(long n) {

       long []evenFabonicci= {2, 8, 34, 144, 610, 2584, 10946, 46368, 196418, 832040, 3524578, 14930352, 63245986, 267914296, 1134903170, 4807526976l, 20365011074l, 86267571272l, 365435296162l, 1548008755920l, 6557470319842l, 27777890035288l, 117669030460994l, 498454011879264l, 2111485077978050l, 8944394323791464l, 37889062373143906l};

       BigInteger sum = new BigInteger("0");

       for(int i = 0 ; i <evenFabonicci.length;++i  ) {

           if(evenFabonicci[i]< n) {
               sum=sum.add(new BigInteger (Long.toString(evenFabonicci[i])));
           } else {
               break;
           }

       }      


        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            BigInteger sum = euler002(n);
            System.out.println(sum);
        }
    }
}