package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.RobotRoomCleaner.Java;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Robot robot = new Asimo();
        cleanRoom(robot);
    }

    public static void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtracking(robot, visited, 0, 0, 0);
    }
    
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0, -1}};

    private static void backtracking(Robot robot, Set<String> visited, int x, int y, int arrow) {
        String path = x + "-" + y;
        if (visited.contains(path)) return;
        visited.add(path);
        robot.clean();
        
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                //go all the way till cannot move, then back one step
                int nx = x + dir[arrow][0];
                int ny = y + dir[arrow][1];
                
                backtracking(robot, visited, nx, ny, arrow);
                //trace back
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            arrow = (arrow + 1) % 4;
        }
    }
}