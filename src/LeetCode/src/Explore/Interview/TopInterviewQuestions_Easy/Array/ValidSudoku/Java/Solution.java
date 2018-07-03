package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.ValidSudoku.Java;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        char[][] board = 
        {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char val = board[row][col];
                if (val != '.') {
                    int block = (row / 3 * 3) + (col / 3);
                    if (set.contains("r" + row + val) || 
                        set.contains("c" + col + val) ||
                        set.contains("b" + block + val)) {
                            return false;
                        } else {
                        set.add("r" + row + val);
                        set.add("c" + col + val);
                        set.add("b" + block + val);
                    }   
                }
            }
        }
        
        return true;
    }

    public static boolean isValidSudoku_threeHashSets(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++) {
                if(board[i][j]!='.' && !rows.add(board[i][j])) {
                    return false;
                }
                if(board[j][i]!='.' && !columns.add(board[j][i])) {
                    return false;
                }
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3])) {
                    return false;
                }
            }
        }
        return true;
    }
}