//  GFG Problem : Subsequence with Sum K
//  Link : https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1

//  On GFG, the recursive approach gives a time limit exceed because the recursive approach for this
//  particular problem is considered as the brute force approach and further it can be optimized using
//  dynamic programming, for now we are just trying to master or understand the recursive approach
//  that's why this problem is included here

public class Check_Exist_Subsequence_With_Sum_K {
    static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 2;

        System.out.println(checkSubsequenceSumK(arr, k));
    }

//    Recursive Approach :
    public static boolean checkSubsequenceSumK (int[] arr, int k) {
        return check(arr, k, 0, 0);
    }

    public static boolean check (int[] arr, int k, int sum, int index) {
//        Base Case :
        if (index == arr.length) {
            if (sum == k) {
                return true;
            }
            else {
                return false;
            }
        }

//        Include the current element :
        boolean include = check(arr, k, sum + arr[index], index + 1);
//        Exclude the current element :
        boolean exclude = check(arr, k, sum, index + 1);

        return include || exclude;
    }

//    Time Complexity : O(2ⁿ)
//    Space Complexity : O(n)
}
