
// separate even and odd numbers.//

package Main;



public class Main {
    public static void main(String []arg) {

        int []a = {20,1,6,4,7,3,16,21,7,8,2,7,12,3,10};
        seperatEvenOdd(a);

    }


    static void seperatEvenOdd(int []a) {

        int oddIndex = 0;
        while(a[oddIndex]%2==0) {
            ++oddIndex;
        }
        for(int i = oddIndex +1 ; i<a.length;++i ) {

             if(a[i]%2==0) {
                 int temp = a[i];
                 a[i] = a[oddIndex];
                 a[oddIndex] = temp;
                 ++oddIndex;
             }
        }
        for(int i : a) {
            System.out.print(i + " ");
        }
    }
}