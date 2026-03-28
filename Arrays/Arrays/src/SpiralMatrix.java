import java.util.ArrayList;
import java.util.List;

// LeetCode Problem : 54. Spiral Matrix
// Link : https://leetcode.com/problems/spiral-matrix

// GFG Problem : Spirally traversing a matrix
// Link : https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1

public class SpiralMatrix {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println("Optimal Approach : " + spiralMatrixOptimal(matrix));
    }

//    Optimal Approach :
    static List<Integer> spiralMatrixOptimal(int[][] matrix){
        List<Integer> result = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0 ;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while (top <= bottom && left <= right){
//            Step 1 : left --> right
            for (int c = left; c <= right ; c++){
                result.add(matrix[top][c]);
            }
            top ++;
//            Step 2 : top --> bottom
            for (int r = top ; r <= bottom ; r ++){
                result.add(matrix[r][right]);
            }
            right --;
//            Step 3 : right --> left
            if(top <= bottom){
                for (int c = right ; c >= left ; c --){
                    result.add(matrix[bottom][c]);
                }
                bottom --;
            }
//            Step 4 : bottom --> top
            if(left <= right){
                for (int r = bottom ; r >= top ; r --){
                    result.add(matrix[r][left]);
                }
                left ++;
            }
        }
        return result;
    }
//    Time Complexity : O( n * m )
//    Space Complexity : O(1)
}
