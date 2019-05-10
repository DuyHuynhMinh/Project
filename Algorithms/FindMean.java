import java.util.*;
//https://www.hackerrank.com/challenges/find-the-running-median/problem

public class Main {

    static class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static void main(String []arg) {

        /*Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        int []a =new int[n];

        for(int i= 0; i< n;++i) {
            a[i]=sc.nextInt();
        }*/


       int []a={12,4,3,5,8,7};

        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>(new MaxHeapComparator());
        ArrayList<Double> arr = new ArrayList<>();

        for(int i = 0; i < a.length;++i) {
            if(i%2==0) {
                minH.add(a[i]);

                if(i==0) {
                    arr.add((double) minH.peek());
                }else {
                    double tmp = Math.max((double) minH.peek(),(double) maxH.peek());
                    arr.add(tmp);
                }

            } else {
               maxH.add(a[i]);

                while(maxH.peek()>minH.peek()) {
                    int tmp = maxH.peek();
                    maxH.remove();
                    maxH.add(minH.peek());
                    minH.remove();
                    minH.add(tmp);
                }

                arr.add(((double)minH.peek()+(double)maxH.peek())/2);
            }


        }

        //System.out.println(arr);

        double []d = new double[arr.size()];

        for(int i = 0 ; i<d.length;++i) {
            d[i] = arr.get(i);
            System.out.println(d[i]);
        }

    }


}