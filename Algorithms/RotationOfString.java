package Main;

public class Main {
    public static void main(String []arg) {

        String s1 = "abcdef";
        String s2 ="efabcd";
        System.out.println(isRotation(s1,s2));


    }


    public static boolean isRotation (String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        StringBuilder sb = new StringBuilder(s1);
        sb.append(s1);
        if(sb.toString().contains(s2)){
            return true;
        }
        return false;
    }
}