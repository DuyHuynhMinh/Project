
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {

        public Integer id;
        public Long dist;

        public Node(Integer id , Long dist) {
            this.id = id;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist.compareTo(o.dist);
        }
    }

    public static void main(String []arg) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N =sc.nextInt();



        Map<Integer, ArrayList> map =new TreeMap<>();

        int count = 0;

        for(int i = 0; i <N;++i) {

            int tmp =sc.nextInt();

            if(map.containsKey(tmp)) {
                map.get(tmp).add(i+1);
                ++count;
            } else{
                map.put(tmp,new ArrayList<>(Arrays.asList(i+1)));
            }

        }

        if (count<2) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
           // System.out.println(map);

            Set<Integer> keys = map.keySet();

            int T =3;


            int prev=-1;
            int offset=0;

            while(T-->0) {


                boolean change = true;

                for (int key : keys) {

                    ArrayList<Integer> arr = map.get(key);

                    for (int i : arr) {
                        System.out.print(i + " ");
                    }

                    if(offset<2&&arr.size()>=3&&change) {
                        int i = arr.get(offset);
                        int j = arr.get(offset+1);
                        arr.set(offset, j);
                        arr.set(offset+1, i);
                        map.put(key, arr);
                        change=false;
                        ++offset;
                    } else if (offset==0&&arr.size() == 2&&change&&prev!=key) {
                        int i = arr.get(0);
                        int j = arr.get(1);
                        arr.set(0, j);
                        arr.set(1, i);
                        map.put(key, arr);
                        change=false;
                        prev=key;
                    }

                }
                System.out.println();
            }


        }

    }

    public static void prim(int src, ArrayList<ArrayList<Node>> graph) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = graph.size();
        boolean []visited = new boolean[n];
        int []path = new int[n];
        long []dist = new long[n];

        Arrays.fill(visited,false);
        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(path, -1);

        pq.add(new Node(src,0l));

        dist[src] = 0;

        while(!pq.isEmpty()) {


           Node node = pq.poll();
           int id = node.id;

           visited[id] = true;

           int size = graph.get(id).size();

           for(int i = 0 ; i<size;++i) {

               Node neighbor = graph.get(id).get(i);

               int v = neighbor.id;
               long valueNeighbor = neighbor.dist;

               if(!visited[v]&&valueNeighbor<dist[v]){
                   dist[v] = valueNeighbor;
                   pq.add(new Node(v,valueNeighbor));
                   path[v]= id;
               }


           }

        }

        double  ans = 0;

    for(int i = 1 ; i <n; ++i) {

        if(path[i]==-1) continue;

        ans+=Math.sqrt(dist[i]);
    }


    System.out.println(String.format("%.2f",ans));

    }


}
