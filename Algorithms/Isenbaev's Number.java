import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String []arg) throws IOException {


        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
         ArrayList<Boolean> visited = new ArrayList<>();
         ArrayList<Integer> path = new ArrayList<>();
         LinkedList<Integer> q = new LinkedList<>();

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        Map<String,Integer> m =new TreeMap<>();

        int id = 0;



        graph.add(new ArrayList<Integer>());
        visited.add(false);

        while(T-->0) {

           String s = br.readLine();

           String []ss = s.split(" ");

          for(String name : ss) {

              if(name.equals("Isenbaev")) {
                  m.put("Isenbaev",0);
              }
              if(!m.containsKey(name)) {
                  graph.add(new ArrayList<Integer>());
                  visited.add(false);
                  m.put(name,++id);
              }
          }

          int  node0 = m.get(ss[0]);
          int  node1 = m.get(ss[1]);
          int  node2 = m.get(ss[2]);

          graph.get(node0).add(node1);
          graph.get(node0).add(node2);

          graph.get(node1).add(node0);
          graph.get(node1).add(node2);

          graph.get(node2).add(node0);
          graph.get(node2).add(node1);

        }

        visited.set(0,true);
        q.add(0);

        Map<Integer,Integer> level  = new HashMap<>();
        level.put(0,0);

        while(!q.isEmpty()) {

            int value = q.pop();

            ArrayList<Integer> ar = graph.get(value);

            int tmp = level.get(value);

            for (int i : ar) {

                    if (!visited.get(i)) {

                        visited.set(i, true);
                        q.add(i);
                        level.put(i,tmp+1);


                    }

            }
        }

        Set<String> key = m.keySet();
        for(String ss : key) {
            int v = m.get(ss);
            if(level.containsKey(v)) {
                System.out.println (ss + " " + level.get(v));
            } else {
                System.out.println (ss + " undefined");
            }
        }


    }


}
