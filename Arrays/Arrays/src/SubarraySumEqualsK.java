import java.util.HashMap;

// LeetCode Problem : 560. Subarray Sum Equals K
// Link : https://leetcode.com/problems/subarray-sum-equals-k

// GFG Problem : Subarrays with sum K
// Link : https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr ={3,-3,1,1,1};
        int k = 3;

        System.out.println("Better Approach : " + subarraySumBrute(arr,k));
        System.out.println("Optimal Approach : " + subarrayOptimal(arr,k));

    }

//    Better Approach :
    static int subarraySumBrute(int[] arr, int k){
        int count = 0;

        for (int i = 0 ; i < arr.length; i ++){
            int sum = 0;
            for (int j = i ; j < arr.length; j ++){
                sum += arr[j];
                if(sum == k){
                    count ++;
                }
            }
        }
        return count;
    }
//    Time Complexity : O(N * N)
//    Space Complexity : O(1)

//    Optimal Approach : PrefixSum + HashMap
    static int subarrayOptimal(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        map.put(0,1);  // Very Important (Empty prefix seen once)

        for (int num : arr){
            prefixSum += num;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
//    Time Complexity : O(N)
//    Space Complexity : O(N)
}
