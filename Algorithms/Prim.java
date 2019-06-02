import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {

        public Integer id;
        public Integer dist;

        public Node(Integer id , Integer dist) {
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

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Node>> graph = new  ArrayList<>();
        for(int i=0; i<=n;++i) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m; ++ i) {
            int u =sc.nextInt();
            int v = sc.nextInt();
            int w =sc.nextInt();
            graph.get(u).add(new Node(v,w));
            graph.get(v).add(new Node(u,w));
        }

        prim(1,graph);


    }

    public static void prim(int src, ArrayList<ArrayList<Node>> graph) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = graph.size();
        boolean []visited = new boolean[n];
        int []path = new int[n];
        int []dist = new int[n];

        Arrays.fill(visited,false);
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        pq.add(new Node(src,0));

        dist[src] = 0;

        while(!pq.isEmpty()) {


           Node node = pq.poll();
           int id = node.id;

           visited[id] = true;

           int size = graph.get(id).size();

           for(int i = 0 ; i<size;++i) {

               Node neighbor = graph.get(id).get(i);

               int v = neighbor.id;
               int valueNeighbor = neighbor.dist;

               if(!visited[v]&&valueNeighbor<dist[v]){
                   dist[v] = valueNeighbor;
                   pq.add(new Node(v,valueNeighbor));
                   path[v]= id;
               }


           }

        }

        long  ans = 0;

    for(int i = 0 ; i < n; ++i) {

        if(path[i]==-1) continue;

        ans+=dist[i];
    }


    System.out.println(ans);

    }


}
