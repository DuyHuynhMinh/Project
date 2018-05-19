/*
Given a sequence of non-negative integers, find the subsequence of length 3 having maximum product with the numbers of the subsequence being in ascending order.
*/

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String []arg) {

        int []a  = {1, 3,5, 8,9,12,7,10,9} ;
        int []left = new int[a.length];
        int [] right = new int[a.length];
        left[0] = -1;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(a[0],0);
        for(int i =1; i <a.length;++i) {
            if(map.lowerEntry(a[i])!=null){
                Map.Entry e = map.lowerEntry(a[i]);
                Integer key = (Integer)e.getKey();
                left[i] = key;
            } else{
                left[i] = -1;
            }
            map.put(a[i],i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = a.length -1; i >=0;--i) {
            if(max<a[i]) {
                max= a[i];
            }
            right[i] = max;
        }
        int maxProduct = Integer.MIN_VALUE;

       for(int i = 1; i < a.length;++i) {
           if((a[i]!=left[i])&&(a[i]!=right[i])) {
               if(maxProduct<a[i]*left[i]*right[i]) {
                   maxProduct= a[i]*left[i]*right[i];
               }

           }

       }

       System.out.println(maxProduct);
    }

