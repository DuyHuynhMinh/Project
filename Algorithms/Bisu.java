import java.util.*;

public class Main {

    private static int V = 0;

    private static int s = 1;

    private static TreeSet<Integer> g = new TreeSet<> ();

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static ArrayList<Boolean> visited = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();
    private static Stack<Integer> q = new Stack<>();


    public static void main(String []arg) {


        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();

        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i =1; i <= V-1; ++ i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }



        int G  = sc.nextInt();

        for(int i = 0 ; i < G;++ i) {
            g.add(sc.nextInt());
        }


        for(int i = 0 ; i <= V;++i) {
            visited.add(false);
            path.add(-1);
        }


        visited.set(s,true);
        q.add(s);

        while(!q.isEmpty()) {

            int value = q.pop();

                ArrayList<Integer> ar = graph.get(value);

                    for (int i : ar) {
                        if(i!=-1) {
                            if (!visited.get(i)) {
                                visited.set(i, true);
                                q.add(i);
                                path.set(i, value);
                            }
                        }
                    }
        }



        int min = Integer.MAX_VALUE;
        int value = 0;
        for(int i : g) {

            if(path.get(i)<min) {
                value = i;
                min = path.get(i);
            }
        }

        System.out.println(value);

       // printPath(s, 5);

    }


    private static void  printPath(int s, int n) {
        if(s==n) {
            System.out.println(s);
            return;
        }

        if(path.get(n)==-1) {
            System.out.println("No Path");
            return;
        }

        ArrayList<Integer> b= new ArrayList<>();

        int tmp = 0;
        b.add(n);

        while(true) {

            tmp = path.get(n);

            if(tmp == s) {
                break;
            } else{
                b.add(tmp);
                n=tmp;
            }

        }
        b.add(s);

        for(int i = b.size()-1;i>=0;--i) {
            if(i==0){
                System.out.print(b.get(i) );
                break;
            }
            System.out.print(b.get(i) + "->");
        }
    }
}