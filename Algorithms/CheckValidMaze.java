import java.util.*;

public class Main {




    public static void main(String []arg) {


        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int ii =0; ii<t;++ii) {

            int row = sc.nextInt();
            int colum = sc.nextInt();


            String s = sc.nextLine();
            char[][] m = new char[row][colum];

            for(int k = 0 ; k < row;++k) {

                s = sc.nextLine();


                for(int l =0 ; l < colum;++l) {
                    m[k][l] = s.charAt(l);
                }

            }


            int[] dx = {0, 0, 1, -1};
            int[] dy = {-1, 1, 0, 0};

            boolean[][] visited = new boolean[row][colum];
            LinkedList<ArrayList<Integer>> q = new LinkedList<>();

            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < colum; ++j) {
                    visited[i][j] = false;
                }
            }


            int startR = -1;
            int startC = -1;
            int endR = -1;
            int endC = -1;

            ArrayList<ArrayList<Integer>> mx = new ArrayList<>();

            for (int j = 0; j < colum; ++j) {
                ArrayList<Integer> a = new ArrayList<>();
                if (m[0][j] == '.') {
                    a.add(0);
                    a.add(j);
                    mx.add(a);
                }
            }
            for (int i = 1; i < row; ++i) {
                ArrayList<Integer> a = new ArrayList<>();
                if (m[i][0] == '.') {
                    a.add(i);
                    a.add(0);
                    mx.add(a);
                }
            }

            for (int i = 1; i < row; ++i) {
                ArrayList<Integer> a = new ArrayList<>();
                if (colum!=1&&m[i][colum - 1] == '.') {
                    a.add(i);
                    a.add(colum - 1);
                    mx.add(a);
                }
            }

            for (int j = 1; j < colum - 1; ++j) {
                ArrayList<Integer> a = new ArrayList<>();
                if (row!=1&&m[row - 1][j] == '.') {
                    a.add(row - 1);
                    a.add(j);
                    mx.add(a);
                }
            }


            if (mx.size() != 2) {
                System.out.println("invalid");
            } else {

                q.add(mx.get(0));


                endR = mx.get(1).get(0);
                endC = mx.get(1).get(1);

                boolean check = false;

                while (!q.isEmpty()) {

                    ArrayList<Integer> tmp = q.pop();
                    startR = tmp.get(0);
                    startC = tmp.get(1);
                    visited[startR][startC] = true;

                    for (int i = 0; i < 4; ++i) {
                        int newStartR = startR + dx[i];
                        int newStartC = startC + dy[i];
                        if (newStartR >= row || newStartC >= colum || newStartR < 0 || newStartC < 0) continue;

                        if (m[newStartR][newStartC] == '.') {

                            if ((newStartR == endR) && (newStartC == endC)) {
                                check = true;
                                break;
                            }
                            if (!visited[newStartR][newStartC]) {
                                ArrayList<Integer> pair = new ArrayList<>();
                                pair.add(newStartR);
                                pair.add(newStartC);
                                q.add(pair);
                            }
                        }

                    }
                }
                if (check) {
                    System.out.println("valid");
                } else {
                    System.out.println("invlaid");
                }

            }

        }


    }



}