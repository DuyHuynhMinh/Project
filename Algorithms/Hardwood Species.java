import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1167

public class Main {

    public static void main(String []arg) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        br.readLine();

       while(T-->0) {

           Map<String,Integer> m =new TreeMap<>();
           String s;
           int count =0;

           while((s=br.readLine())!=null&&!s.isEmpty()){
               ++count;
               if(m.containsKey(s)){
                   int tmp = m.get(s);
                    m.put(s,++tmp);
               } else {
                    m.put(s,1);
               }

           }

           Set<String> key = m.keySet();
           for(String name : key) {
               int tmp = m.get(name);
               System.out.println(String.format("%s %.4f",name,(double)tmp*100/count));
           }
            if(T>0) System.out.println();

       }


    }


}
