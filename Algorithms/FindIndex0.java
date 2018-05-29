//Find the starting index of 0.//
package Main;


public class Main {
    public static void main(String []arg) {
        int []a = {1,1,1,1,0,0};
        System.out.println(firstZeroIndex(a));

    }

    static int firstZeroIndex(int []a) {
        if(a[a.length-1]==1) return -1;
        if(a[0]==0) return 0;
        int mid = a.length/2;
        int startIndex = 0;
        int  endIndex = a.length-1;
        while(startIndex<endIndex) {
            if(a[mid]==1) {
                if(a[mid+1]==0) {
                    return mid+1;
                }  else {
                    startIndex = mid;
                }
            }
            if(a[mid]==0) {
                if(a[mid-1]==1){
                    return mid;
                } else{
                    endIndex=mid;
                }

            }
            mid=(startIndex+endIndex)/2;
        }
        return mid;
    }

}