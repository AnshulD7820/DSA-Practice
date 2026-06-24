//  GFG Problem : Kth Missing Positive Number in a Sorted Array
//  Link : https://www.geeksforgeeks.org/problems/kth-missing-positive-number-in-a-sorted-array/1

//  LeetCode Problem : 1539. Kth Missing Positive Number
//  Link : https://leetcode.com/problems/kth-missing-positive-number

public class Kth_Missing_Positive_Number {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        System.out.println("Brute Force Approach : " + kthMissingBrute(arr, k));

        System.out.println("Optimal Approach : " + kthMissingOptimal(arr, k));
    }

//    NOTE : This problem is pure "binary search" not binary search on answers

//    Brute Force Approach :
    public static int kthMissingBrute(int[] arr, int k){
        for (int num : arr){
            if(num <= k){
                k ++;
            }
            else{
                break;
            }
        }
        return k;
    }

//    Time Complexity : O(N)
//    Space Complexity : O(1)

//    Optimal Approach :
    public static int kthMissingOptimal(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int missing = arr[mid] - (mid + 1);

            if(missing < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low + k;
    }

//    Time Complexity : O(log n)
//    Space Complexity : O(1)
}
