import java.util.*;
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1594

public class Main {


    static class Cell {
        int r, c;

        public Cell(int _r, int _c) {
            r = _r;
            c = _c;
        }


    };

    public static void main(String []arg) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int colum = sc.nextInt();

        while(true) {

            int dx[] = {0, 0, 1, -1};
            int dy[] = {1, -1, 0, 0};

            int[][] a = new int[row][colum];
            boolean visited[][] = new boolean[row][colum];
            int count[][] = new int[row][colum];

            int rowBoom = sc.nextInt();

            for (int i = 0; i < rowBoom; ++i) {
                int roww = sc.nextInt();

                int numberBoom = sc.nextInt();

                for (int j = 0; j < numberBoom; ++j) {
                    int columm = sc.nextInt();
                    a[roww][columm] = -1;
                    visited[roww][columm] = true;

                    count[roww][columm] = -1;
                }
            }

       /*for(int i = 0 ; i < row; ++i) {
           System.out.println();
           for(int j = 0 ; j < colum;++j) {
               System.out.print(a[i][j] + " ");
           }
       }*/

            int startR = sc.nextInt();
            int startC = sc.nextInt();

            int endR = sc.nextInt();
            int endC = sc.nextInt();


            LinkedList<Cell> q = new LinkedList<>();
            q.add(new Cell(startR, startC));

            visited[startR][startC] = true;


            count[startR][startC] = 0;


            while (!q.isEmpty()) {

                Cell u = q.pop();

                visited[u.r][u.c] = true;

                if (u.r == endR && u.c == endC) {

                    break;
                }

                for (int i = 0; i < 4; i++) {

                    int r = u.r + dx[i];
                    int c = u.c + dy[i];
                    if (r >= row || c >= colum || r < 0 || c < 0 || a[r][c] == -1) continue;

                    //System.out.println("Test : " + u.r + " " +  u.c +  " " + r + " " +  c);

                    if (!visited[r][c]) {
                        //System.out.println("Test : " + u.r + " " +  u.c +  " " + r + " " +  c);
                        visited[r][c] = true;
                        q.add(new Cell(r, c));
                        count[r][c] = count[u.r][u.c] + 1;
                        //System.out.println(r + " " + c + " " + count[r][c]);

                    }

                }

                //System.out.println();


            }

        /*for(int i = 0 ; i < row; ++i) {
            System.out.println();
            for(int j = 0 ; j < colum;++j) {
                System.out.print(count[i][j] + " ");
            }
        }*/
            System.out.println(count[endR][endC]);

            row = sc.nextInt();
            colum = sc.nextInt();
            if(row==0||colum==0) break;
        }




    }


}
