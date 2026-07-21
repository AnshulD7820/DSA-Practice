//  GFG Problem : Median in a Row-Wise Sorted Matrix
//  Link : https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

import java.util.Arrays;

public class Matrix_Median {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        System.out.println("Brute Force Approach : " + medianBrute(matrix));
        System.out.println("Optimal Approach : " + medianOptimal(matrix));
    }

//    Brute Force Approach :
    public static int medianBrute(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[] arr = new int[n * m];
        int index = 0;

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j ++){
                arr[index ++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);

        return arr[(n * m) / 2];
    }
//    Time Complexity : O((n×m) log(n×m))
//    Space Complexity : O(n × m)

//    Optimal Approach :
    public static int medianOptimal(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
//        Find Global Minimum And Maximum
        for (int i = 0; i < n; i ++){
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }
        int required = (n * m) / 2;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int count = 0;

            for (int i = 0; i < n; i ++){
                count += upperBound(matrix[i], mid);
            }

            if(count <= required){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int upperBound(int[] mat, int x){
        int low = 0;
        int high = mat.length - 1;
        int ans = mat.length;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(mat[mid] > x){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

//    Time Complexity : O(n × log m × log(max - min))
//    Space Complexity : O(1)

}
