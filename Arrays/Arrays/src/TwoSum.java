import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Brute Force Approach : " + Arrays.toString(TwoSumBrute(arr, target)));
        System.out.println("Better Approach : " + Arrays.toString(TwoSumBetter(arr, target)));

        int[] arr1 ={2,7,11,15};
        int target1 = 9;
        System.out.println("Optimal Approach : " + Arrays.toString(TwoSumOptimal(arr1,target1)));
    }

    //Brute Force Approach:
    static int[] TwoSumBrute(int[] arr, int target){
        for (int i = 0; i < arr.length; i ++){
            for (int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[] {i , j};
                }
            }
        }
        return new int[] {-1, -1};
    }
    // Time Complexity : O(N * N)
    // Space Complexity : O(1)

    // Better Approach: Using HashMap
    static int[] TwoSumBetter(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < arr.length; i ++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)

    // Optimal Approach:
    // Use this approach only when the array is sorted because here we are gonna use two pointer approach which only
    // works on the sorted array. We can also do it like this : first sort the array then use this optimal approach but
    // this will end up taking more time complexity so if the array is not sorted then the hashing approach is the
    // optimistic approach.
    // If an interviewer says that without using HashMap solve this problem(Two Sum), then you have to first sort the
    // array if it doesn't , then use the two pointer approach.

    static int[] TwoSumOptimal(int[] arr1, int target1){
        int left = 0;
        int right = arr1.length - 1;

        while(left < right){
            int sum = arr1[left] + arr1[right];
            if(sum == target1){
                return new int[]{left, right};
            }
            else if(sum < target1){
                left++;
            }
            else{
                right--;
            }
        }

        return new int[]{-1,-1};
    }

    // Time Complexity : O(N)
    // Space Complexity : O(1)


}
