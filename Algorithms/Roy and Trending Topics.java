import java.util.*;

//https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/roy-and-trending-topics-1/description/

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
        System.out.println(n);


        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashMap<Long, ArrayList<Integer>> hm = new HashMap<>();
        HashMap<Integer,Long> hmm = new HashMap<>();




        for(int i = 0 ; i < n ;++i ){

            int id = sc.nextInt();
            long z_score = sc.nextInt();
            long p = sc.nextInt();
            long l =sc.nextInt();
            long c = sc.nextInt();
            long s =  sc.nextInt();

            long sum =(long) 50*p + 5*l+ 10*c+ 20*s ;

            long dis = sum -z_score;

            hmm.put(id,sum);

            if(i<5) {
                pq.add(dis);
            } else {
                if(dis>pq.peek()) {
                    pq.remove();
                    pq.add(dis);
                }
            }

            if(hm.get(dis)!=null){
                hm.get(dis).add(id);
            } else{
                ArrayList<Integer> a = new ArrayList<>(Arrays.asList(id));
                hm.put(dis,a);
            }

        }

        long []top =new long[5];
        for(int i= 0; i <5;++i) {
            top[i] = pq.peek();
            pq.remove();
        }

        int count =0;
        for(int i= 4; i >=0;) {
            ArrayList<Integer> r = hm.get(top[i]);
            Collections.sort(r,Collections.reverseOrder());
            for(int j : r) {
                ++count;
                System.out.println(j + " " + hmm.get(j));

                if(count ==5){
                    break;
                }
            }
            i-=r.size();

        }





    }


}