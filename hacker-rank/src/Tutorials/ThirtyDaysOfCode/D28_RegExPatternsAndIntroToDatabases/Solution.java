package Tutorials.ThirtyDaysOfCode.D28_RegExPatternsAndIntroToDatabases;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        List<String> result = new ArrayList();
        scan.nextLine();
        for (int i=0; i< num; i++){
            String temp = ParseString(scan.nextLine());
            if (temp != ""){
                result.add(temp);
            }
        }

        Collections.sort(result);
        for(int j=0; j<result.size(); j++){
            System.out.println(result.get(j));
        }
    }

    public static String ParseString(String myString){
        String myRegExString = ".@gmail.com";
        Pattern p = Pattern.compile(myRegExString);
        Matcher m = p.matcher(myString);
        if( m.find() ) {
            return myString.split(" ")[0];
        }
        return "";
    }
}
