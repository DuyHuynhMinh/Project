//https://www.hackerrank.com/challenges/cut-the-sticks/problem

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String []arg) {

        int []arr = {1,13,3,8,14,9,4,4};
        int []a = new int[1000];
        ArrayList<Integer> r = new ArrayList<>();

        int sum = arr.length;
        r.add(sum);


        for(int i = 0 ; i<arr.length;++i) {
            ++a[arr[i]];
        }


        for(int i=0; i <a.length; ++i) {
            if(a[i]!=0) {
                if(sum-a[i]>0) {
                    r.add(sum-a[i]);
                    sum-=a[i];
                }
            }
        }

        int []rs = new int[r.size()];
        for(int i = 0 ; i < rs.length; ++ i) {
            rs[i] = r.get(i);
        }

        for(int i : rs) {
            System.out.println(i);
        }




    }



}