import java.util.*;

//https://www.hackerrank.com/challenges/qheap1/problem

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

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < n; ++i) {
            int c = sc.nextInt();

            if(c==1)  {
                int v = sc.nextInt();
                pq.add(v);

            }

            if(c==2) {
                int v = sc.nextInt();
                pq.remove(v);

            }

            if(c==3) {
                System.out.println(pq.peek());
            }

        }

    }







}