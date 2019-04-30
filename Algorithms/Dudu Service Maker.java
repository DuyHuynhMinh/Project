import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

https://www.urionlinejudge.com.br/judge/en/problems/view/1610

public class Main {




    private static int V = 0;
    private static int E =0;


    public static void main(String []arg) {


        Scanner sc = new Scanner(System.in);

         int N = sc.nextInt();

         for(int j = 0; j<N;++j) {

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

                 if(!graph.get(u).contains(v)){
                     graph.get(u).add(v);
                 }

             }



             for (int i = 1; i <= V; ++i) {
                 if (dfs(i, graph)) {
                     check = true;
                     break;
                 }
             }

             if (check) {
                 System.out.println("SIM");
             } else {
                 System.out.println("NAO");
             }


         }


    }

    static boolean dfs(int startNode,  ArrayList<ArrayList<Integer>> graph) {

        boolean []visited = new boolean[V+1];

        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<=V;++i) {
            visited[i] = false;
        }

        visited[startNode] = true;
        st.push(startNode);

        while(!st.isEmpty()) {

            int n = st.pop();


            ArrayList<Integer> g = graph.get(n);

            for (int i : g) {

                if(!visited[i]) {
                    st.push(i);
                    visited[i] = true ;
                }else {

                    if(i == startNode)   return true;

                }

            }

        }

        return false;
    }


}