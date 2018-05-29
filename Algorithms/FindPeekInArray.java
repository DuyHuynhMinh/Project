/* Find the maximum element in that array. */

package Main;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String []arg) {
        int []a = {1,2,3,4,6,9,12,19,20,27,33,45,46,75,84,19,15,13,12,11,8,5,2,1};
        System.out.println(findPeekInArray(a));

    }
    static int findPeekInArray(int []a) {
        int mid = a.length/2;
        int startIndex = 0;
        int  endIndex = a.length-1;
        while(startIndex<endIndex) {
           if((a[mid]>a[mid+1])&&(a[mid]>a[mid-1])){
               return a[mid];
           }
           if(a[mid]>a[mid-1]) {
               startIndex = mid;
           } else{
               endIndex=mid;
           }

            mid=(startIndex+endIndex)/2;
        }
        return -1;
    }
}