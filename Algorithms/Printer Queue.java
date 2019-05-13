import java.util.*;

//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3252

public class Main {


    static class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static void main(String []arg) {

        Scanner sc = new Scanner(System.in);


        int testcase = sc.nextInt();

        for (int j = 0; j < testcase; ++j) {


            int n = sc.nextInt();


            int pos = sc.nextInt();

            LinkedList<Integer> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(new MaxHeapComparator());

            for(int k =0; k <n;++k) {
                int tmp  = sc.nextInt();
                q.add(tmp);
                pq.add(tmp);
            }

            int count = 0;

            while(true) {
                /*System.out.println( "q : "  +q );
                System.out.println( " pq : " + pq );
                System.out.println("pos : " + pos);*/

                if(pos==0&&q.peek()==pq.peek()) {
                    ++count;
                    break;
                }

                if(q.peek()==pq.peek()) {
                    //System.out.println("P : " + pq.peek());
                    ++count;
                    pq.remove();
                    q.remove();
                    --pos;
                } else {



                    if(pos!=0&&q.peek()<pq.peek()){
                        int tmp =q.peek();
                        q.remove();
                        q.add(tmp);
                        --pos;
                    }

                    if(pos==0&&q.peek()<pq.peek()) {
                        int tmp =q.peek();
                        q.remove();
                        q.add(tmp);
                        pos=q.size()-1;
                    }
                }



            }

            System.out.println(count);


        }
    }


}
