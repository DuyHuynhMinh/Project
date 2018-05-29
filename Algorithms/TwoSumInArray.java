// Fid two number in Array sum ==target//

package Main;

public class Main {
    public static void main(String []arg) {

        int A[]= {3,5,2 ,9,4,10,1,6};
        int target = 17;

        System.out.println(twoSumInArray(A,target));


    }

    static boolean twoSumInArray(int []A, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i = 0; i < A.length;++i) {
            if(map.containsKey(target-A[i])) {
                return true;
            }
            map.put(A[i],i);
        }

        return false;
}