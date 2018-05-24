/* https://www.hackerrank.com/challenges/game-of-thrones/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        
        if(s.length()==1) return "YES";
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return "YES";
            }
             return "NO";
        } 
           
        
        
        Map<Character,Integer> table = new HashMap<>();
        int count =1;
        
        for(int i = 0 ; i < s.length();++i) {            
            if(table.containsKey(s.charAt(i))) {
                 count = table.get(s.charAt(i));   
                ++count;
            } else {
                count =1;
            }
            table.put(s.charAt(i),count);
        }
        
        int check =0;
        Set<Character> keys = table.keySet();
        
        for(char c : keys ) {
            
            if(table.get(c)%2!=0) {
                ++check;
            }
            
            if(check>=2) {
                return "NO";
            }
            
        }
        
        return "YES";


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
