import java.util.*;

//https://www.codechef.com/problems/RRATING

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

        PriorityQueue<Integer> maxH = new PriorityQueue<>(new MaxHeapComparator());
        PriorityQueue<Integer> minH = new PriorityQueue<>();

        int count =0;

        for (int i = 0; i < n; ++i) {
            int c = sc.nextInt();

            if (c == 1) {

                int v = sc.nextInt();

                if(count<3) {
                    maxH.add(v);
                }

                ++count;

                if(count%3==0) {
                    minH.add(maxH.peek());
                    maxH.remove();
                } else if (count>=3&&v>minH.peek()) {
                   int tmp = minH.peek();
                    minH.remove();
                    minH.add(v);
                    maxH.add(tmp);
                } else{
                    maxH.add(v);
                }

            }

            if (c == 2) {

                if(count<3) {
                    System.out.println("No reviews yet");
                } else {
                    System.out.println(minH.peek());
                }
            }


        }


    }


}