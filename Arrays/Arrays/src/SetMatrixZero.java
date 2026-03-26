import java.util.Arrays;

// LeetCode Problem : 73. Set Matrix Zeros
// Link : https://leetcode.com/problems/set-matrix-zeroes

// GFG Problem : Set Matrix Zeros
// Link : https://www.geeksforgeeks.org/problems/set-matrix-zeroes/1

public class SetMatrixZero {
    public static void main(String[] args) {

        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Brute Force Approach : " + Arrays.deepToString(setMatrixZerosBrute(matrix)));

        int[][] matrix1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Better Approach : " + Arrays.deepToString(setMatrixZeroBetter(matrix1)));

        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Optimal Approach : " + Arrays.deepToString(setMatrixZeroOptimal(matrix2)));

        }

//    Brute Force Approach :
    static int[][] setMatrixZerosBrute(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

//      Step 1 : Mark rows and columns with -1    {r -> rows and c -> columns}
        for (int r = 0; r < n; r ++){
            for (int c = 0; c < m; c ++){
                if(matrix[r][c] == 0){
//                    mark row with -1
                    for (int k = 0; k < m ; k++){
                        if (matrix[r][k] != 0){
                            matrix[r][k] = -1;
                        }
                    }
//                    mark columns with -1
                    for (int k = 0; k < n; k++){
                        if(matrix[k][c] != 0){
                            matrix[k][c] = -1;
                        }
                    }
                }
            }
        }
//        Step 2 : Convert -1 to 0
        for (int r = 0; r < n; r ++){
            for (int c = 0; c < m; c ++){
                if(matrix[r][c] == -1){
                    matrix[r][c] = 0;
                }
            }
        }
        return matrix;
    }
//    Time Complexity : O(n × m × (n + m))
//    Space Complexity : O(1)

//    Better Approach :
    static int[][] setMatrixZeroBetter(int[][] matrix1){
        int n = matrix1.length;
        int m = matrix1[0].length;

        int[] row = new int[n];
        int[] column = new int[m];

//        Step 1 : Mark rows and Columns
        for (int r = 0; r < n; r ++){
            for (int c = 0; c < m; c ++){
                if(matrix1[r][c] == 0){
                    row[r] = 1;
                    column[c] = 1;
                }
            }
        }
//        Step 2 : Update Matrix
        for (int r = 0; r < n; r ++){
            for (int c = 0; c < m ; c ++){
                if(row[r] == 1 || column[c] == 1){
                    matrix1[r][c] = 0;
                }
            }
        }
        return matrix1;
    }
//    Time Complexity : O(n × m)
//    Space Complexity : O(n + m)

//    Optimal Approach :
    static int[][] setMatrixZeroOptimal(int[][] matrix2){
        int n = matrix2.length;
        int m = matrix2[0].length;

        int col0 = 1;

//        Step 1 : marking
        for (int r = 0; r < n; r ++){
            for (int c = 0 ; c < m; c ++){
                if(matrix2[r][c] == 0){
                    matrix2[r][0] = 0;
                    if(c == 0){
                        col0 = 0;
                    }
                    else{
                        matrix2[0][c] = 0;
                    }
                }
            }
        }
//        Step 2 :
        for (int r = 1 ; r < n ; r ++){
            for (int c = 1; c < m ; c ++){
                if(matrix2[r][0] == 0 || matrix2[0][c] == 0){
                    matrix2[r][c] = 0;
                }
            }
        }
//        Step 3 : fill the first row
        if(matrix2[0][0] == 0){
            for (int c = 0 ; c < m ; c ++){
                matrix2[0][c] = 0;
            }
        }
//        Step 4 : fill the first column
        if(col0 == 0){
            for (int r = 0 ; r < n ; r ++){
                matrix2[r][0] = 0;
            }
        }
        return matrix2;
    }
//    Time Complexity : O(n × m)
//    Space Complexity : O(1)
}
