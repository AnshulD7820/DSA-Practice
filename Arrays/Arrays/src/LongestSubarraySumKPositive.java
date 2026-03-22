import java.util.HashMap;

public class LongestSubarraySumKPositive {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1};
        int k = 3;

        System.out.println("Brute Force Approach : " + longestSubarrayBrute(arr, k));
        System.out.println("Better Approach : " + longestSubarrayBetter(arr, k));
        System.out.println("Optimal Approach : " + longestSubarrayOptimal(arr, k));
        System.out.println("LeetCode 560 Solution : " + leetcode(arr, k));
    }

    //NOTE : Remember on thing that when the array contains positives , negatives and zeros then use better approach,
    //       And when the array contains only positive and zeros then use the optimal approach, here the better approach
    //       will not work, means in terms of time and space complexity.

    // Brute Force Approach:
    static int longestSubarrayBrute(int[] arr, int k){
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for (int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum == k){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    // Time Complexity : O(N * N)
    // Space Complexity : O(1)

    // Better Approach : This approach will work for any type of integers, including positive, negative and also zeros.
    static int longestSubarrayBetter(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,1);

        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++){
            prefixSum += arr[i];
            if(prefixSum == k){
                maxLen = i + 1;
            }
            if(map.containsKey(prefixSum - k)){
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
        }
        return maxLen;
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)

    static int longestSubarrayOptimal(int[] arr , int k){
        int right = 0;
        int left = 0;
        int sum = 0;
        int maxLen = 0;
        int n = arr.length;

        while (right < n){
            sum += arr[right];       // Expand Right

            while (sum > k && left <= right){
                sum -= arr[left++];           // Shrink Left
            }

            if(sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    // Time Complexity : O(N)
    // Space Complexity : O(1)


    // in this leetcode question , the problem is asking to find the count of number of subarray not the longest subarray.
    static int leetcode( int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0 , 1);   // Most Important

        int prefixSum = 0;
        int count = 0;

        for (int i = 0 ; i < arr.length; i++){
            prefixSum += arr[i];

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

}
