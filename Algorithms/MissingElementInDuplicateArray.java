package Main;


public class Main {
    public static void main(String []arg) {

        int []a = {1,2,1,6,5,3,6,3,5,7,8,2,10,8,7};
        System.out.println(missingDuplicate(a));

    }

    static int missingDuplicate(int []a) {
        int result =0;
        for(int i =0 ; i < a.length;++i) {
            result^=a[i];
        }
        return result;
    }
}