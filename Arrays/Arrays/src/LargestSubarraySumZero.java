import java.util.HashMap;

// GFG Problem : Largest subarray with 0 sum
// Link : https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

public class LargestSubarraySumZero {
    public static void main(String[] args) {
        int[] arr ={15, -2, 2, -8, 1, 7, 10, 23};

        System.out.println("Brute Force Approach : " + largestSubarraySum0Brute(arr));
        System.out.println("Optimal Approach : " + largestSubarraySum0Optimal(arr));

    }

//    Brute Force Approach :
    static int largestSubarraySum0Brute(int[] arr){
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i ++){
            int sum = 0;
            for (int j = i; j < n; j ++){
                sum += arr[j];
                if(sum == 0){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
//    Time Complexity : O(n²)
//    Space Complexity : O(1)

//    Optimal Approach :
    static int largestSubarraySum0Optimal(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i ++){
            sum += arr[i];
//            Case 1 : sum = 0
            if(sum == 0){
                maxLen = i + 1;
            }
//            Case 2 : seen before
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i - map.get(sum));
            }else{
                map.put(sum, i);       // Store first occurrence
            }
        }
        return maxLen;
    }
//    Time Complexity : O(n)
//    Space Complexity : O(n)
}
