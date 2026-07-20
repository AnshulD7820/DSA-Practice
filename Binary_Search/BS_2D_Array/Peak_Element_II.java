//  GFG Problem : Find the Peak Element in a 2D Matrix
//  Link : https://www.geeksforgeeks.org/problems/find-the-peak-element-in-a-2d-matrix/1

//  LeetCode Problem : 1901. Find a Peak Element II
//  Lik : https://leetcode.com/problems/find-a-peak-element-ii

import java.util.Arrays;

public class Peak_Element_II {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32},
        };

        System.out.println("Brute Force Approach : " + Arrays.toString(peakElemBrute(matrix)));
        System.out.println("Optimal Approach : " + Arrays.toString(peakElemOptimal(matrix)));

    }

//    Brute Force Approach :
    public static int[] peakElemBrute(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j ++){
                int up = (i > 0) ?  matrix[i - 1][j] : -1;
                int down = (i < n - 1) ? matrix[i + 1][j] : -1;
                int left = (j > 0) ? matrix[i][j - 1] : -1;
                int right = (j < m - 1) ? matrix[i][j + 1] : -1;

                if(
                        matrix[i][j] > up &&
                        matrix[i][j] > down &&
                        matrix[i][j] > left &&
                        matrix[i][j] > right

                ){
                    return new int[]{i , j};
                }
            }
        }
        return new int[]{-1, -1};
    }
//    Time Complexity : O(n × m)
//    Space Complexity : O(1)

//    Optimal Approach :
    public static int[] peakElemOptimal(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int row = maxRow(matrix, mid);

            int left = (mid - 1 >= 0) ? matrix[row][mid - 1] : -1;
            int right = (mid + 1 < m) ? matrix[row][mid + 1] : -1;

            if(
                    matrix[row][mid] > left &&
                    matrix[row][mid] > right
            ){
                return new int[]{row, mid};
            }
            else if(left > matrix[row][mid]){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static int maxRow(int[][] matrix, int col){
        int row = 0;
        for (int i = 1; i < matrix.length; i ++){
            if(matrix[i][col] > matrix[row][col]){
                row = i;
            }
        }
        return row;
    }

//    Time Complexity : O(n × log m)
//    Space Complexity : O(1)
}
