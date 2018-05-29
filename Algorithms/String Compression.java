package Main;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String []arg) {
        String s = "aaaabbbgggooop";
        System.out.println(compressString(s));


    }

    public static String compressString(String s) {
        if(s.length()==1) return s;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < s.length()-1;++i)  {
            count =1;
            while( i < s.length()-1&&s.charAt(i)==s.charAt(i+1)) {
                ++count;
                ++i;
            }
            sb.append(s.charAt(i)+""+count);
        }
        if(s.charAt(s.length()-1)!=s.charAt(s.length()-2)) {
            sb.append(s.charAt(s.length()-1)+""+1);
        }
        if(sb.length()>=s.length()) return s;
        return sb.toString();
    }
}
