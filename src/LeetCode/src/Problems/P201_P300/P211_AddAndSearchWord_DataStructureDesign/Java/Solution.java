package LeetCode.src.Problems.P201_P300.P211_AddAndSearchWord_DataStructureDesign.Java;

public class Solution {

    static WordDictionary wordDictionary = new WordDictionary();

    public static void main(String[] args) {
        addWord("bad");
        addWord("dad");
        addWord("mad");
        System.out.println(search("pad"));
        System.out.println(search("bad"));
        System.out.println(search(".ad"));
        System.out.println(search("b.."));
    }   
    
    public static void addWord(String word) {
        wordDictionary.addWord(word);
    }

    public static boolean search(String word) {
        return wordDictionary.search(word);
    }
}