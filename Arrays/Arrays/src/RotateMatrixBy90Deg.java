import java.util.Arrays;

// LeetCode Problem : 48. Rotate Image
// Link : https://leetcode.com/problems/rotate-image

// GFG Problem : Rotate by 90 degree
// Link : https://www.geeksforgeeks.org/problems/rotate-by-90-degree0356/1

public class RotateMatrixBy90Deg {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Brute Force Approach : " + Arrays.deepToString(rotateMatrixBy90DegBrute(matrix)));

        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Optimal Approach : " + Arrays.deepToString(rotateMatrixBy90DegOptimal(matrix1)));
    }

//     Brute Force Approach :
    static int[][] rotateMatrixBy90DegBrute(int[][] matrix){
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int r = 0 ; r < n ; r ++){
            for (int c = 0 ; c < n ; c ++){
                result[c][n-1-r] = matrix[r][c];
            }
        }
        return result;
    }
//    Time Complexity : O( N * N )
//    Space Complexity : O( N * N )

//    Optimal Approach :
    static int[][] rotateMatrixBy90DegOptimal(int[][] matrix1){
        int n = matrix1.length;

//        Step 1 : Transpose
        for (int r = 0 ; r < n ; r ++){
            for (int c = r + 1 ; c < n ; c ++){
                int temp = matrix1[r][c];
                matrix1[r][c] = matrix1[c][r];
                matrix1[c][r] = temp;
            }
        }
//        Step 2 : Reverse each row
        for (int r = 0 ; r < n ; r ++){
            int left = 0;
            int right = n - 1;

            while (left < right){
                int temp = matrix1[r][left];
                matrix1[r][left] = matrix1[r][right];
                matrix1[r][right] = temp;

                left ++;
                right --;
            }
        }
        return matrix1;
    }
//    Time Complexity : O( N * N )
//    Space Complexity : O(1)

//    -> If the problem state to rotate the matrix in Anti - Clockwise direction , then First Transpose the matrix and
//    then Reverse the Columns

//      Trick To Remember :
//      Rotation                                          Steps
//      Clockwise                ----->                   Transpose + Reverse rows
//      Anti-Clockwise           ----->                   Transpose + Reverse Columns

}
