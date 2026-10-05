//  GFG Problem : Solve the Sudoku
//  Link : https://www.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1

//  LeetCode Problem : 37. Sudoku Solver
//  Link : https://leetcode.com/problems/sudoku-solver

public class Sudoko_Solver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        sudokoSolver(board);

//        Print the output :
        printBoard(board);
    }

//    Print the solved board :
    public static void printBoard (char[][] board) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

//    Optimal Approach :
    public static void sudokoSolver (char[][] board) {
        solve (board);
    }

    public static boolean solve (char[][] board) {
//        Base Case :
        int[] emptyCell = new int[2];
//        If all the cells has been filled then we don't need to do anything the problem is already been solved just return true
        if (!findEmptyCell (board, emptyCell)) {
            return true;
        }
//        If we found an empty cell :
        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        for (int value = 1; value <= 9 ; value++) {
            char charValue = (char) (value + '0');
            if (isSafeToPlace (rowIndex, colIndex, charValue, board)) {
//                Place the value or the number :
                board[rowIndex][colIndex] = charValue;
//                Other will be solved by the recursion :
                if (solve(board) == true) {
                    return true;
                }
//                Undo or backtracking step :
                board[rowIndex][colIndex] = '.';
            }
        }
//        If we are not able to solve the problem then just return false
        return false;
    }

    public static boolean findEmptyCell(char[][] board, int[] emptyCell) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
//                    Store cell of the row
                    emptyCell[0] = i;
//                    Store cell of the column
                    emptyCell[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSafeToPlace (int rowIndex, int colIndex, char charValue, char[][] board) {
//        1. Check for row or horizontal line :
        for (int col = 0; col < 9; col ++) {
            if (board[rowIndex][col] == charValue) {
                return false;
            }
        }

//        2. Check for column or vertical line :
        for (int row = 0; row < 9; row ++) {
            if (board[row][colIndex] == charValue) {
                return false;
            }
        }

//        3. Check for 3 * 3 sub - box :
        int startRow = rowIndex - rowIndex % 3;
        int startColumn = colIndex - colIndex % 3;

        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                int actualRow = startRow + i;
                int actualColumn = startColumn + j;
                if (board[actualRow][actualColumn] == charValue) {
                    return false;
                }
            }
        }
        return true;
    }

//    Time Complexity :
//    There can be up to 81 empty cell, and for each empty cell we may try up to 9 values
//    So the time complexity can be :
//                                      O(9 ^ 81)
//    for a generalized N * N Sudoko, this can be expressed as :
//                                                                  O(N^N²)
//    because there can be N² cells and up to N choices per cell.

//    Space Complexity :
//    There can be up to 81 empty cells
//    So the auxiliary space complexity can be : O(81)
}
