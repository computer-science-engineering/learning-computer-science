package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.GameSolving.NQueens.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> result = solveNQueens(4);
        for (ArrayList<String> internalList : result) {
            for (int i=0; i<internalList.size()-1; i++) {           
                System.out.print(internalList.get(i) + ", ");
            }
            System.out.print(internalList.get(internalList.size()-1));
            System.out.println();          
        }
    }
    
    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        char[][] board = new char[a][a];
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < a; j++) {
                board[i][j] = '.';
            }
        }
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    private static void dfs(char[][] board, int colIndex, ArrayList<ArrayList<String>> res) {
        if(colIndex == board.length) {
            List<String> temp = construct(board);
            res.add(new ArrayList<String>(temp));
            return;
        }
        
        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    private static boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        
        return true;
    }
    
    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}