//  LeetCode Problem : 51. N-Queens
//  Link : https://leetcode.com/problems/n-queens

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    static void main(String[] args) {
        int n = 4;

        System.out.println(nQueens(n));
    }

//    Optimal Approach :
    public static List<List<String>> nQueens (int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i ++) {
            Arrays.fill(board[i], '.');
        }

        generate(0, board, result);

        return result;
    }

    public static void generate (int colIndex, char[][] board, List<List<String>> result ) {
//        Base Case :
        if (colIndex == board.length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i ++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }

        for (int rowIndex = 0; rowIndex < board.length; rowIndex ++) {
            if (isSafeToPlace(rowIndex, colIndex, board)) {
//                Place Queen :
                board[rowIndex][colIndex] = 'Q';
//                Another will be solved by recursion
                generate(colIndex + 1, board, result);
//                Undo or Backtracking :
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    public static boolean isSafeToPlace (int rowIndex, int colIndex, char[][] board) {
        int row = rowIndex;
        int col = colIndex;

//        Check left horizontal :
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col --;
        }

//        Check left upper diagonal :
        row = rowIndex;
        col = colIndex;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row = row - 1;
            col = col - 1;
        }

//        Check left lower diagonal :
        row = rowIndex;
        col = colIndex;

        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row = row + 1;
            col = col - 1;
        }

        return true;
    }

//    Time Complexity :
//    There are up to N choices for each of N columns, so the recursion tree has a rough upper bound of: O(N!)
//    With the O(N) safety check:
//                                  O(N ⋅ N!)

//    Space Complexity :
//                      Board : O(N²)     || Arrays : O(N)     || Recursion : O(N)
//    So auxiliary space apart from storing all solutions is: O(N²) because of the board

}
