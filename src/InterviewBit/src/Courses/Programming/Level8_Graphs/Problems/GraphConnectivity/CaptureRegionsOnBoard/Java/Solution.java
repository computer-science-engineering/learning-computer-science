package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.GraphConnectivity.CaptureRegionsOnBoard.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
        a.add(new ArrayList<Character>(Arrays.asList('X', 'X', 'X', 'X')));
        a.add(new ArrayList<Character>(Arrays.asList('X', 'O', 'O', 'X')));
        a.add(new ArrayList<Character>(Arrays.asList('X', 'X', 'O', 'X')));
        a.add(new ArrayList<Character>(Arrays.asList('X', 'O', 'X', 'X')));
        solve(a);
        System.out.println(a);
    }

    public static void solve(ArrayList<ArrayList<Character>> a) {
        if (a == null || a.size() == 0 || a.get(0).size() == 0) {
            return;
        }
    
        int m = a.size(), n = a.get(0).size();
        Queue<Point> queue = new LinkedList<Point>();
        
        // Step 1: Get all 'O' on edges first
        for (int i = 0; i < m; i++) {
            if (a.get(i).get(0) == 'O')   addPoint(a, queue, i, 0);
            if (a.get(i).get(n-1) == 'O') addPoint(a, queue, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (a.get(0).get(j) == 'O')   addPoint(a, queue, 0, j);
            if (a.get(m-1).get(j) == 'O') addPoint(a, queue, m-1, j);
        }
        
        // Step 2: BFS for 'O' and put them to '+'
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.row, y = p.col;
            if (x-1 >= 0   && a.get(x-1).get(y) == 'O') addPoint(a, queue, x-1, y);
            if (x+1 <= m-1 && a.get(x+1).get(y) == 'O') addPoint(a, queue, x+1, y);
            if (y-1 >= 0   && a.get(x).get(y-1) == 'O') addPoint(a, queue, x, y-1);
            if (y+1 <= n-1 && a.get(x).get(y+1) == 'O') addPoint(a, queue, x, y+1);
        }
        
        // Step 3: Put all '+' to 'O' and 'O' to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == 'O') a.get(i).set(j, 'X');
                if (a.get(i).get(j) == '+') a.get(i).set(j, 'O');
            }
        }
    }

    // Change 'O' to '+' and add the point to queue
    private static void addPoint(ArrayList<ArrayList<Character>> board, Queue<Point> queue, int i, int j) {
        board.get(i).set(j, '+');
        queue.add(new Point(i, j));
    }

    private static class Point {
        int row;
        int col;

        public Point(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
}