import java.util.*;
import java.util.stream.Collectors;

//http://codeforces.com/problemset/problem/723/D

public class Main {



    static class Cell {
        int x, y;

        public Cell(int _x, int _y) {
            x = _x;
            y = _y;
        }
    };


    public static void main(String []arg) {




         Scanner sc = new Scanner(System.in);

        //V = sc.nextInt();

       int row =sc.nextInt();
       int colum =sc.nextInt();
       int k =sc.nextInt();


       char [][]m =new char [row][colum];

       boolean [][]visited = new boolean[row][colum];
       int []size = new int[2500];

       int []dx ={0,0,-1,1};
       int []dy ={-1,1,0,0};

       Stack<Cell> st = new Stack<>();
       ArrayList<Cell> ac  = new ArrayList<>();
       HashMap<Integer,ArrayList<Cell>> hm = new HashMap<>();


       String s =  sc.nextLine();
       for( int i = 0; i < row; ++ i) {
           s = sc.nextLine();
           for(int j = 0; j< colum;++j) {
               m[i][j] =s.charAt(j);
               if(m[i][j]=='*' ){
                   visited[i][j]= false;
               } else {
                   visited[i][j] = true;
               }
           }
       }


       int kk=0;

       for(int i = 0; i <row;++i) {
          for(int j = 0 ; j < colum; ++j ) {

              boolean valid =false;

              if(m[i][j]=='.'&&visited[i][j]) {

                 valid =true;

                  visited[i][j]=false;

                  if(i==0||j==0||i==row-1||j==colum-1) {
                       valid=false;
                  }

                  st.push(new Cell(i,j));


                  while(!st.isEmpty()) {

                      Cell cell = st.pop();
                      ac.add(cell);

                      for(int l = 0 ; l < 4;++l) {

                          int xNew = cell.x+dx[l];
                          int yNew = cell.y+dy[l];

                          if(xNew<0||yNew<0||xNew>=row||yNew>=colum) continue;

                          if(m[xNew][yNew]=='.'&&visited[xNew][yNew]) {
                              if(xNew==0||yNew==0||xNew==row-1||yNew==colum-1) {
                                  valid=false;
                              }
                              visited[xNew][yNew]=false;
                              st.push(new Cell(xNew,yNew));
                          }
                      }
                  }

                    if(valid) {
                        ++kk;
                        hm.put(kk,ac);
                        size[kk] = ac.size();
                    }

                  ac = new ArrayList<>();

              }

          }
       }


       Arrays.sort(size);

       int value = size[(size.length-1)-k];
       int deletedCell = 0;
       int o = (size.length-1)-k;

       while(o>=0&&size[o]!=0){
           deletedCell+=size[o];
           --o;
       }

       int count = 0;

        o = (size.length-1-k);

        while(o>=0&&size[o]==value){
            ++count;
            --o;
        }



       Set<Integer> keySet = hm.keySet();
       for(Integer i : keySet) {

           ArrayList<Cell> rc = hm.get(i);

           if(rc.size()<value) {
               for(Cell c : rc ) {
                   m[c.x][c.y] ='*';
               }
           }

           if(rc.size()==value&&count>0) {
               for(Cell c : rc ) {
                   m[c.x][c.y] ='*';
               }
               --count;
           }


       }
            System.out.println(deletedCell);
            print(m,row,colum);
    }

    static void print(char [][]matrix, int row, int colum) {

        for(int i = 0; i < row;++i) {
            for(int j = 0; j <colum; ++j) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }




}