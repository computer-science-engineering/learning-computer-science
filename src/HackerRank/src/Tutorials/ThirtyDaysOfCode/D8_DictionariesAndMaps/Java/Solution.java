package HackerRank.src.Tutorials.ThirtyDaysOfCode.D8_DictionariesAndMaps.Java;

import java.util.*;

class Solution{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> phoneMap = new HashMap<String, Integer>(); 
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            phoneMap.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            if (phoneMap.containsKey(s)){
                System.out.println(s + "=" + phoneMap.get(s));
            }
            else{
                System.out.println("Not found");
            }
        }
        
        in.close();
    }
}
