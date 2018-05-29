//* find out duplicates in Array//

package Main;

public class Main {
    public static void main(String []arg) {
        int a [] = {1,4, 6, 4, 5, 2, 3, 8,3, 2};
        findDuplcate(a);
    }

    static void findDuplcate(int []a) {
        for(int i = 0; i < a.length;++i) {
            if(a[Math.abs(a[i])] < 0) {
                System.out.println("Duplicate Value : " + Math.abs(a[i]));
            }else{
                a[Math.abs(a[i])] = a[Math.abs(a[i])]*-1;
            }

        }

    }
}