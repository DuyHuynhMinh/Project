import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
///http://codeforces.com/problemset/problem/602/B

public class Main {

    public static void main(String []arg) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int []a= new int[n];

        for(int i = 0; i < n;++i) {
            a[i] = sc.nextInt();
        }




        int count = 0 ;

        int result = 0;

        int Lmax = 0;
        int Lmin = 0;


        for(int i = 0 ; i <a.length;++i) {

            if(a[i]>=a[Lmax]) Lmax=i;
            if(a[i]<=a[Lmin]) Lmin =i;

            int disMax= Math.abs(a[Lmax]-a[i]);
            int disMin= Math.abs(a[Lmin]-a[i]);

            if(disMax<=1&&disMin<=1) {
                ++count;
                result = Math.max(count,result);
            } else {

                if(a[i]-a[Lmin]==2) {
                    count = i - Lmin;
                    if(i-Lmin>1) {
                        Lmin=Lmax-1;
                    }else{
                        Lmin = Lmax;
                    }

                }else if(a[Lmax]-a[i]==2) {
                    count = i-Lmax;
                    ++Lmax;
                    Lmin=i;

                } else{
                    count =1;
                    Lmax =i;
                    Lmin = i;
                }

            }



        }

        System.out.println(result);


    }
}