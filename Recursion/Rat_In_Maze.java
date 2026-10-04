//  GFG Problem : Rat in a Maze
//  Link : https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

import java.util.ArrayList;

public class Rat_In_Maze {
    static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        System.out.println(ratInMaze(maze));

    }

//    Optimal Backtracking Approach :
    public static ArrayList<String> ratInMaze (int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;

//        If starting cell is blocked :
        if (maze[0][0] == 0) {
            return result;
        }

        boolean[][] visited = new boolean[n][n];

        generate (0, 0, maze, n, visited, result, "");

        return result;
    }

    public static void generate (int row, int col, int[][] maze, int n, boolean[][] visited, ArrayList<String> result, String path) {
//        Base Case :
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }
//        Mark the current cell :
        visited[row][col] = true;

//        4 Directions :
//        1. Down :
        int newR = row + 1;
        int newC = col;
        if (isSafeToPlace (newR, newC, n, maze, visited)) {
            generate(newR, newC, maze, n, visited, result, path + "D");
        }

//        2. Left :
        newR = row;
        newC = col - 1;
        if (isSafeToPlace(newR, newC, n, maze, visited)) {
            generate(newR, newC, maze, n, visited, result, path + "L");
        }

//        3. Right :
        newR = row;
        newC = col + 1;
        if (isSafeToPlace(newR, newC, n, maze, visited)){
            generate(newR, newC, maze, n, visited, result, path + "R");
        }

//        4. Up :
        newR = row - 1;
        newC = col;
        if (isSafeToPlace(newR, newC, n, maze, visited)) {
            generate(newR, newC, maze, n, visited, result, path + "U");
        }

//        Undo or Backtracking :
        visited[row][col] = false;

    }

    public static boolean isSafeToPlace (int newR, int newC, int n, int[][] maze, boolean[][] visited) {
//        Out of bound case :
        if (newR <  0 || newR >= n || newC < 0 || newC >= n) {
            return false;
        }
//        Already visited case :
        else if (visited[newR][newC] == true) {
            return false;
        }
//        Blocked cell case :
        else if (maze[newR][newC] == 0) {
            return false;
        }
        else {
            return true;
        }
    }

//    Time Complexity :
//    There are up to 4 choices from each cell
//    In the worst case, the number of possible paths can be exponential
//    So the Time Complexity can be : O(4^(N²))
//    Because there can be up to (N²) cells and up to 4 directional choices

//    Auxiliary Space Complexity : O(N²)
}
