package Pramp.src.Problems.DataStructuresAndAlgorithms.DecryptMessage.Java;

public class Solution {
    public static void main(String[] args) {
        String word = "dnotq";
        System.out.println(decrypt(word));
    }

    public static String decrypt(String word) {
        int secondStep = 1;
        String decryption = "";

        for(int i = 0; i < word.length(); i++) {
            int newLetterAscii = (int)(word.charAt(i));
            newLetterAscii -= secondStep;

            while(newLetterAscii < 97) {
                newLetterAscii += 26;
            }

            decryption += (char) newLetterAscii;
            secondStep += newLetterAscii;
        }

        return decryption;
    }
}