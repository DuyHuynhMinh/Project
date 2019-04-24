import java.util.*;

public class Main {




    public static void main(String []arg) {


        Scanner sc = new Scanner(System.in);

        long ownerKey = sc.nextInt();
        long trueKey = sc.nextInt();
        int n = sc.nextInt();

        long []keys = new long[n];

        for(int i = 0 ; i < n;++i) {
            keys[i]=sc.nextInt();
        }

        int []arr = new int[100000];
        for(int i = 0; i< 100000;++i) {
            arr[i] = -1;
        }

        LinkedList<Long> q = new LinkedList<>();
        //HashMap<Long, Long> hm = new HashMap<>();


        arr[(int)ownerKey]=0;

        //hm.put(ownerKey,0l) ;
        q.add(ownerKey);

        while(!q.isEmpty()) {

            long valueKey = q.pop();

            if(valueKey == trueKey) {
                break;
            }


            for (int i = 0; i < keys.length; ++i) {

                    long tmp = (valueKey * keys[i]) % 100000;

                    /*if(!hm.containsKey(tmp)) {
                        long pos = hm.get(valueKey);
                        hm.put(tmp, pos + 1);
                        q.add(tmp);
                    }*/

                    if(arr[(int)tmp]==-1) {
                        arr[(int)tmp]= arr[(int)valueKey]+1;
                        q.add(tmp);
                    }

            }


        }


           System.out.println(  arr[(int)trueKey]);



    }

}