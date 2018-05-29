//check if a given string contains all the unique characters//

package Main;

public class Main {
    public static void main(String []arg) {

        String s="qAazxswerBm";
        System.out.println(isUnique(s));

    }

    static boolean isUnique(String s) {
        boolean [] check = new boolean [256];
        for(int i =0; i < s.length();++i) {
            if(check[s.charAt(i)]) {
                return false;
            }
            check[s.charAt(i)] =true;
        }
        return  true;
    }
}