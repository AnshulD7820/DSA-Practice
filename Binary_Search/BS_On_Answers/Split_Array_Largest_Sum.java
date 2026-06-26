//  GFG Problem : Split Array Largest Sum
//  Link : https://www.geeksforgeeks.org/problems/split-array-largest-sum--141634/1

//  LeetCode Problem : 410. Split Array Largest Sum
//  Link : https://leetcode.com/problems/split-array-largest-sum

public class Split_Array_Largest_Sum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;

        System.out.println("Split Array Largest Sum : " + splitArrLargestSum(nums, k));
    }

//    Optimal Binary Search Approach :
    public static int splitArrLargestSum(int[] nums, int k){
        int low = 0;
        int high = 0;

        for (int num : nums){
            low = Math.max(low, num);
            high += num;
        }

        int ans = 0;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int requiredSubarray = countSubarray(nums, mid);

            if(requiredSubarray <= k){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int countSubarray(int[] nums, int maxSum){
        int subarray = 1;
        int currentSum = 0;

        for (int num : nums){
            if(currentSum + num <= maxSum){
                currentSum += num;
            }
            else{
                subarray ++;
                currentSum = num;
            }
        }
        return subarray;
    }

//        Time Complexity : O(n × log S)
//                          Where : O(n) - Helper function that we used to calculate the number of subarrays
//                                  O(log S) - Binary Search
//                                                Where S is the sum of subarray : sum(nums[]) - max(nums[]) + 1
//    Space Complexity : O(1)
}
