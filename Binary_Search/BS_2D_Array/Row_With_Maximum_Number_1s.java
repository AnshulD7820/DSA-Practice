//  GFG Problem : Row with Max 1s in Rowwise Sorted
//  Link : https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1

//  LeetCode Problem : 2643. Row With Maximum Ones
//  Link : https://leetcode.com/problems/row-with-maximum-ones

//  In LeetCode 2643, the problem does not guarantee that each row of the binary matrix is sorted. Binary search can
//  only be applied to sorted arrays because it relies on the ordering of elements to eliminate half of the search
//  space in each step. Since a row like [1, 0] is valid in this problem, using binary search to find the first 1
//  would produce incorrect results. Therefore, we cannot use binary search here and instead need to count the number
//  of 1s in each row using a linear scan (brute force).

public class Row_With_Maximum_Number_1s {
    public static void main(String[] args) {
        int[][] mat = {
                        {0, 1, 1, 1},
                        {0, 0, 1, 1},
                        {1,1,1,1},
                        {0,0,0,0}
                      };

        System.out.println("Brute Force Approach : " + rowWithMaxOnesBrute(mat));
        System.out.println("Optimal Approach : " + rowWithMaxOnesOptimal(mat));
    }

//    Brute Force Approach :
    public static int rowWithMaxOnesBrute(int[][] mat){
        int maxOnes = 0;
        int answer = -1;

        for (int i = 0; i < mat.length; i ++){
            int count = 0;
            for (int j = 0; j< mat[0].length; j ++){
                if(mat[i][j] == 1){
                    count ++;
                }
            }
            if(count > maxOnes){
                maxOnes = count;
                answer = i;
            }
        }
        return answer;
    }

//    Time Complexity : O(n × m)
//                      Where : n = Rows and m = Columns
//    Space Complexity : O(1)

//    Optimal Approach :
    public static int rowWithMaxOnesOptimal(int[][] mat){
        int rows = mat.length;
        int columns = mat[0].length;

        int maxOnes = 0;
        int ans = -1;

        for (int i = 0; i < rows ; i ++){
            int firstOnes = lowerBound(mat[i]);

            int ones = columns - firstOnes;

            if(ones > maxOnes){
                maxOnes = ones;
                ans = i;
            }
        }
        return ans;
    }

    public static int lowerBound(int[] mat){
        int low = 0;
        int high = mat.length - 1;

        int ans = mat.length;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(mat[mid] >= 1){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

//    Time Complexity : O(n × log m)
//                      Where : n = Rows and m = Columns
//                      O(n) - lowerBound
//                      O(log m) - Binary Search
//    Space Complexity : O(1)
}
