//  TakeUForward : 1004. Count all subsequences with sum K
//  Link : https://takeuforward.org/practice/dsa/count-all-subsequences-with-sum-k?tab=problem

public class Count_Subsequences_With_Sum_K {
    static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 2;

        System.out.println(countSubsequencesSumK(arr, k));
    }

//    Recursive Approach :
    public static int countSubsequencesSumK (int[] arr, int k) {
        return count(arr, k, 0, 0);
    }

    public static int count (int[] arr, int k, int sum, int index) {
//        Base Case :
        if (index == arr.length) {
            if (sum == k) {
                return 1;
            }
            else {
                return 0;
            }
        }

//        Include the current element :
        int include = count(arr, k, sum + arr[index], index + 1);
//        Exclude the current element :
        int exclude = count(arr, k, sum, index + 1);

        return include + exclude;
    }

//    Time Complexity : O(2ⁿ)
//    Space Complexity : O(n)
}
