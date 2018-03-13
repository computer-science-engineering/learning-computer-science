package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Tries.HotelReviews.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String A = "cool_ice_wifi";
        ArrayList<String> B = new ArrayList<String>(Arrays.asList(
            "water_is_cool", "cold_ice_drink", "cool_wifi_speed"));
            ArrayList<Integer> result = solve(A, B);
            for (Integer item : result) {
                System.out.print(item + " ");
            }
    }
    
    public static ArrayList<Integer> solve(String A, ArrayList<String> B) {
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>(); // k - count, v - list of indexes
        String[] goodWords = A.split("_");
        Character c;
        TrieNode root = new TrieNode();
        TrieNode current;
        TrieNode node;

        // create dictionary
        for (String word: goodWords) {
            current = root;
            for (int i = 0; i < word.length(); i++) {
                c = word.charAt(i);
                if (current.children.containsKey(c)) {
                    current = current.children.get(c);
                } else {
                    node = new TrieNode();
                    current.children.put(c, node);
                    current = node;
                }
                if (i == word.length() - 1) {
                    current.endOfWord = true;
                }
            }
        }

        // search words
        for (int i = 0; i < B.size(); i++) {
            String[] review = B.get(i).split("_");
            int count = 0;

            for (String w: review) {
                boolean exists = search(root, w);
                if (exists) count++;
            }
            ArrayList<Integer> indexes = treeMap.getOrDefault(count, new ArrayList<>());
            indexes.add(i);
            treeMap.put(count, indexes);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int key: treeMap.descendingKeySet()) {
            result.addAll(treeMap.get(key));
        }

        return result;
    }

    private static boolean search(TrieNode root, String word) {
        Character c;
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }

        return current.endOfWord;
    }

    // Editorial solution

    static final int ALPHABET_SIZE = 26;
     
    // trie node
    static class TrieNode_Editorial
    {
        TrieNode_Editorial[] children = new TrieNode_Editorial[ALPHABET_SIZE];
      
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
         
        TrieNode_Editorial(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };
      
    static TrieNode_Editorial root; 
    static void insert(String key)
    {
        int level;
        int length = key.length();
        int index;
      
        TrieNode_Editorial pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode_Editorial();
      
            pCrawl = pCrawl.children[index];
        }
      
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }
    static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode_Editorial pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
      
            if (pCrawl.children[index] == null)
                return false;
      
            pCrawl = pCrawl.children[index];
        }
      
        return (pCrawl != null && pCrawl.isEndOfWord);
    }
    public ArrayList<Integer> solve_editorial(String A, ArrayList<String> B) {
        root =  new TrieNode_Editorial();
        TreeMap<Integer,ArrayList<Integer>> tm = new TreeMap<Integer,ArrayList<Integer>>();
        int i= 0,n=A.length();
        while(i<n){
            StringBuilder temp = new StringBuilder();
            while(i<n&&A.charAt(i)!='_'){
                temp.append(A.charAt(i));
                i++;
            }
            insert(temp.toString());
            i++;
        }
        i=0;n=B.size();
        ArrayList<Integer> useMe = new ArrayList<Integer>();
        while(i<n){
            String b = B.get(i);
            int count = 0;
            int j = 0,k=0,m=b.length();
            while(k<m){
                j=k;
                while(k<m&&b.charAt(k)!='_'){
                    k++;
                }
                if(search(b.substring(j,k))){
                    count++;
                }
                k++;
            }
            if(tm.containsKey(count)){
                useMe = tm.get(count);
                useMe.add(i);
                tm.put(count,useMe);
            }
            else{
                ArrayList<Integer> val = new ArrayList<Integer>();
                val.add(i);
                tm.put(count,val);
            }
            i++;
        }
        ArrayList<Integer> fresult = new ArrayList<Integer>();
        while(!tm.isEmpty()){
            int high = tm.lastKey();
            ArrayList<Integer> pointer = tm.get(high);
            for(int ad : pointer){
                fresult.add(ad);
            }
            tm.remove(high);
        }
        return fresult;
    }
}