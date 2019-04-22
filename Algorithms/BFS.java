import java.util.*;

public class Main {

    private static int V = 9;

    private static int s = 0 ;

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static ArrayList<Boolean> visited = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();
    private static LinkedList<Integer> q = new LinkedList<>();


    public static void main(String []arg) {


        /*Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();*/


      ArrayList<Integer> arr = new ArrayList<> (Arrays.asList(1,3,8));
      graph.add(arr);

      arr = new ArrayList<> (Arrays.asList(0,7));
      graph.add(arr);

        arr = new ArrayList<> (Arrays.asList(3,5,7));
        graph.add(arr);
        arr = new ArrayList<> (Arrays.asList(0,2,4));
        graph.add(arr);
        arr = new ArrayList<> (Arrays.asList(3,8));
        graph.add(arr);
        arr = new ArrayList<> (Arrays.asList(2,6));
        graph.add(arr);

        arr = new ArrayList<> (Arrays.asList(5));
        graph.add(arr);
        arr = new ArrayList<> (Arrays.asList(1,2));
        graph.add(arr);
        arr = new ArrayList<> (Arrays.asList(0,4));
        graph.add(arr);


        for(int i = 0 ; i < V;++i) {
            visited.add(false);
            path.add(-1);
        }

        visited.set(s,true);
        q.add(s);


        while(!q.isEmpty()) {
            int value = q.pop();
            ArrayList<Integer> ar = graph.get(value);
            for(int i :ar) {
                if(!visited.get(i))  {
                    visited.set(i,true);
                    q.add(i);
                    path.set(i,value);
                }
            }
        }

      System.out.println(path);
        printPath(0, 2);
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