//check if elements in array is Consecutive//

package Main;
public class Main {
    public static void main(String []arg) {
        int []a = {22,19,24,23,20,25};
        System.out.println(checkConsecutive(a));

    }

    static boolean checkConsecutive(int []a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < a.length;++i) {
            max =Math.max(max,a[i]);
            min = Math.min(min,a[i]);
        }
        if((max-min+1)!=a.length) return false;
        boolean []check = new boolean[max-min+1];
        for(int i = 0; i < a.length;++i) {
            if(check[a[i]-min]) {
                return false;
            }
            check[a[i]-min] = true;
        }
        return true;
    }
}