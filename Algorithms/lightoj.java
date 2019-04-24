import java.util.*;

//http://lightoj.com/volume_showproblem.php?problem=1012

public class Main {


    public static void main(String []arg) {


        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int k = 0; k < t; ++k) {


            int colum = sc.nextInt();
            int row = sc.nextInt();


            char[][] m = new char[row][colum];

            String s = sc.nextLine();

            int xStart = -1;
            int yStart = -1;

            for(int i =0 ; i <row; ++i) {
                 s = sc.nextLine();
                 for(int j = 0; j < colum;++j) {
                    m[i][j] = s.charAt(j);
                    if(m[i][j]=='@') {
                        xStart = i;
                        yStart=j;
                    }

                }
            }


            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            boolean[][] visited = new boolean[row][colum];

            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < colum; ++j) {
                    visited[i][j] = false;
                }
            }

            ArrayList<Integer> a = new ArrayList<>();
            a.add(xStart);
            a.add(yStart);

            ArrayList<ArrayList<Integer>> aa = new ArrayList<>();

            aa.add(a);

            LinkedList<ArrayList<ArrayList<Integer>>> q = new LinkedList<>();
            q.add(aa);

            int count = 1;
            visited[xStart][yStart] = true;

            while (!q.isEmpty()) {

                ArrayList<ArrayList<Integer>> na = q.pop();

                int x = na.get(0).get(0);
                int y = na.get(0).get(1);

                for (int i = 0; i < 4; ++i) {
                    int xNew = x + dx[i];
                    int yNew = y + dy[i];

                    if (xNew < 0 || yNew < 0 || xNew >= row || yNew >= colum) continue;

                    if (m[xNew][yNew] == '.' && !visited[xNew][yNew]) {
                        visited[xNew][yNew] = true;
                        ++count;
                        ArrayList<Integer> newA = new ArrayList<>();
                        newA.add(xNew);
                        newA.add(yNew);
                        ArrayList<ArrayList<Integer>> newAA = new ArrayList<>();
                        newAA.add(newA);
                        q.add(newAA);
                    }
                }

            }

            System.out.println("Case " + (k+1)+": " + count);

        }

    }


}