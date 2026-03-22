public class MaxSubarraySumKadaneAlgo {
    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Better Approach : " + maxSubarraySumBruteForce(arr));

    }

    // In Brute Force we are using 3 nested loops and actually that doesn't need , we can do it using 2 loops which are
    // shown in the better approach

    // Better Approach :
    static int maxSubarraySumBruteForce(int[] arr){
        int n = arr.length;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];

                maxLen = Math.max(maxLen,sum);
            }
        }
        return maxLen;
    }

    // Time Complexity : O(N * N)
    // Space Complexity : O(1)

    // Optimal Approach : Kadane's Algorithm
}
