import java.util.*;

//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1895

public class Main {

   static class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static void main(String []arg) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while(n!=0) {
            long[] a = new long[n];

            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }

            PriorityQueue<Long> minH = new PriorityQueue<>();
            long sum = 0;

            for (int i = 0; i < a.length; ++i) {
                minH.add(a[i]);
            }


            while (!minH.isEmpty()) {
                long x = minH.peek();
                minH.remove();
                long y = minH.peek();
                minH.remove();

                sum+=x+y;
                minH.add(x+y);


                if(minH.size()==1) {
                    break;
                }

            }

            System.out.println(sum);

            n=sc.nextInt();
        }






    }


}