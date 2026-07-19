//  GFG Problem : Search in a Row-Column Sorted
//  Link : https://www.geeksforgeeks.org/problems/search-in-a-matrix17201720/1

//  LeetCode Problem : 240. Search a 2D Matrix II
//  Link : https://leetcode.com/problems/search-a-2d-matrix-ii

public class Search_In_2D_Matrix_II {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 18;

        System.out.println("Brute Force Approach: " + searchInMatrixBrute(matrix, target));
        System.out.println("Better Approach: " + searchInMatrixBetter(matrix, target));
        System.out.println("Optimal Approach: " + searchInMatrixOptimal(matrix, target));

    }

//    Brute Force Approach :
    public static boolean searchInMatrixBrute(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j ++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

//    Time Complexity : O(n × m)
//    Space Complexity : O(1)

//    Better Approach :
    public static boolean searchInMatrixBetter(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i ++){
            if(matrix[i][0] <= target && target <= matrix[i][m - 1]){
               if(binarySearch(matrix[i], target)){
                   return true;
                }
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
            else{
                high = mid - 1;
            }
        }
        return false;
    }
//    Time Complexity: O(n × log m)
//    Space Complexity: O(1)

//    Optimal Approach :
    public static boolean searchInMatrixOptimal(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int column = m - 1;

        while (row < n && column >= 0){
            if(matrix[row][column] == target){
                return true;
            }
            else if(matrix[row][column] > target){
                column --;
            }
            else{
                row ++;
            }
        }
        return false;
    }
//    Time Complexity : O(n + m)
//    Space Complexity : O(1)
}
