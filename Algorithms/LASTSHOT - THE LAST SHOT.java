import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

//http://www.spoj.com/problems/LASTSHOT/

public class Main {




    private static int V = 0;
    private static int E =0;


    public static void main(String []arg) {


        Scanner sc = new Scanner(System.in);


             V = sc.nextInt();
             E = sc.nextInt();


             ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
             boolean check = false;

             for (int i = 0; i <= V; i++) {
                 graph.add(new ArrayList<Integer>());
             }

             for (int i = 1; i <= E; ++i) {
                 int u = sc.nextInt();
                 int v = sc.nextInt();

                 graph.get(u).add(v);


                 //graph.get(v).add(u);




             }



             int max = Integer.MIN_VALUE;

             for(int i = 1; i <=V;++i ) {

                 max = Math.max(max,dfs(i,graph));


             }



             System.out.println(max);

    }

    static int dfs(int startNode,  ArrayList<ArrayList<Integer>> graph) {

        boolean []visited = new boolean[V+1];
        int []path = new int[V+1];

        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<=V;++i) {
            visited[i] = false;
            path[i]=-1;
        }

        visited[startNode] = true;
        st.push(startNode);
        path[startNode]=0;

        while(!st.isEmpty()) {

            int n = st.pop();

            ArrayList<Integer> g = graph.get(n);

            for (int i : g) {

                if(!visited[i]) {
                    st.push(i);
                    visited[i] = true ;
                    path[i] = n;
                }

            }

        }

        int count = 0 ;

        for(int i: path ) {
            if(i!=-1) ++count;
        }

        return count;
    }


}