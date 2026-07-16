//  GFG Problem : Search in a sorted Matrix
//  Link : https://www.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1

//  LeetCode Problem: 74. Search a 2D Matrix
//  Link : https://leetcode.com/problems/search-a-2d-matrix


public class Search_In_2D_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 18, 20},
                {20, 30, 34,45},
                {51, 77, 89, 99}
        };
        int taget = 18;

        System.out.println("Brute Force Approach: " + searchInMatrixBrute(matrix, taget));
        System.out.println("Better Approach: " + searchInMatrixBetter(matrix, taget));
        System.out.println("Optimal Approach: " + searchInMatrixOptimal(matrix, taget));
    }

//    Brute Force Approach :
    public static boolean searchInMatrixBrute(int[][] matrix, int target){
        for (int i = 0; i < matrix.length;i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
//    Time Complexity : O(n × m)
//    Space Complexity : O(1)

//    Better Approach:
    public static boolean searchInMatrixBetter(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i ++){
            if(matrix[i][0] <= target && target <= matrix[i][m-1]){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] matrix, int target){
        int low = 0;
        int high = matrix.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(matrix[mid] == target){
                return true;
            }
            else if(matrix[mid] <= target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }

//    Time Complexity : O(n × log m)
//    Space Complexity : O(1)

//    Optimal Approach:
    public static boolean searchInMatrixOptimal(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int rows = mid / m;
            int column = mid % m;

            if(matrix[rows][column] == target){
                return true;
            }
            else if(matrix[rows][column] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
//    Time Complexity : O(log(n × m))
//    Space Complexity : O(1)

}
