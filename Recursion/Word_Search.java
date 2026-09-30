//  GFG Problem : Word Search
//  Link : https://www.geeksforgeeks.org/problems/word-search/1

//  LeetCode Problem : 79. Word Search
//  Link : https://leetcode.com/problems/word-search

public class Word_Search {
    static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        System.out.println(wordSearch(board, word));
    }

//    Optimal Recursive Approach :
    public static boolean wordSearch (char[][] board, String word) {
        for (int row = 0; row <= board.length; row ++) {
            for (int col = 0; col < board[0].length; col ++) {
                if (search (0, row, col, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean search (int index, int row, int col, char[][] board, String word) {
//        Base Case :
        if (index == word.length()) {
            return true;
        }
//        Check Invalid Cases :
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(index)
        ) {
            return false;
        }

//        Choose :
        char temp = board[row][col];
        board[row][col] = '#';

//        Explore :
        boolean found =
                search(index + 1, row + 1, col, board, word) ||
                search(index + 1, row - 1, col, board, word) ||
                search(index + 1, row, col + 1, board, word) ||
                search(index + 1, row, col - 1, board, word);

//        Undo or Backtrack :
        board[row][col] = temp;

        return found;
    }

//    Time Complexity :
//    Let,
//          R = number of rows
//          C = number of columns
//          L = length of word
//    We can start from every cell : R × C
//    After the first character, there are four direction at most we can search for the next character
//    So, Overall time complexity becomes : O(R × C × 4^L)

//    Space Complexity : O(L)
//                          Where, L is the length of the word
}
