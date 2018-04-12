package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.GraphTraversal.WordSearchBoard.Java;

public class Solution {
    public static void main(String[] args) {
        String[] A = {"FEDCBECD", "FABBGACG", "CDEDGAEC", "BFFEGGBA", "FCEEAFDA", "AGFADEAC", "ADGDCBAA", "EAABDDFF"};
        String B = "BCDCB";
        System.out.println(exist(A, B));
    }

    public static int exist(String[] A, String B) {
        char[][] board = new char[A.length][];
        for (int i=0; i<A.length; i++) {
            board[i] = A[i].toCharArray();
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(dfs(board, visited, i, j, 0, B)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static boolean dfs(char[][] board,boolean[][] visited,int row,int col,int index,String word){
        if(word.length() == index){
            return true;
        }

        if(row<0 || col<0||row>=board.length || col>=board[0].length) {
            return false;
        }
        char ch = word.charAt(index);
        if(ch == board[row][col]) { // "!visited[row][col] &&"
            //visited[row][col] = true;

            boolean res = dfs(board,visited,row-1,col,index+1,word)
            || dfs(board,visited,row+1,col,index+1,word)
            || dfs(board,visited,row,col-1,index+1,word)
            || dfs(board,visited,row,col+1,index+1,word);
            
            //visited[row][col] = false;
            return res;
        }
        return false;
    }
}