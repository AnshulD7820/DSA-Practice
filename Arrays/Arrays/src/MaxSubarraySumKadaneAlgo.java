import java.util.Arrays;

// LeetCode Problem : 53. Maximum Subarray.
// Link : https://leetcode.com/problems/maximum-subarray

// GFG Problem : Kadane's Algorithm.
// Link : https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1

public class MaxSubarraySumKadaneAlgo {
    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Better Approach : " + maxSubarraySumBruteForce(arr));
        System.out.println("Optimal Approach : " + maxSubarraySumOptimal(arr));
        System.out.println("Optimal Follow Up Approach : " + Arrays.toString(subarrayWithIndices(arr)));

    }


    // Brute Force Approach :
    static int maxSubarraySumBruteForce(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];

                max = Math.max(max,sum);
            }
        }
        return max;
    }

    // Time Complexity : O(N * N)
    // Space Complexity : O(1)

    // Optimal Approach : Kadane's Algorithm

    static int maxSubarraySumOptimal(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int num : arr){
            curSum += num;
            maxSum = Math.max(maxSum,curSum);

            if(curSum < 0){
                curSum = 0;
            }
        }
        return maxSum;
    }
    // Time Complexity : O(N)
    // Space Complexity : O(1)

    // Follow-Up Problem : Subarray with Indices
    static int[] subarrayWithIndices(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0;i < arr.length; i++){
            curSum += arr[i];

            if(curSum > maxSum){
                maxSum = curSum;
                start = tempStart;
                end = i;
            }

            if(curSum < 0){
                curSum = 0;
                tempStart = i + 1;
            }
        }
        return new int[] {maxSum, start, end};
    }

    // Time Complexity : O(N)
    // Space Complexity : O(1)
}
