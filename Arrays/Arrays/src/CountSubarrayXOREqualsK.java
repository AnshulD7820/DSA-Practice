import java.util.HashMap;

// GFG Problem : Count Subarrays with given XOR
// Link : https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1

public class CountSubarrayXOREqualsK {
    public static void main(String[] args) {
        int[] arr ={4, 2, 2, 6, 4};
        int k = 6;

        System.out.println("Brute Force Approach : " + countSubarrayBrute(arr,k));
        System.out.println("Optimal Approach : " + countSubarrayOptimal(arr,k));
    }

//    Brute Force Approach :
    static int countSubarrayBrute(int[] arr, int k){
        int n = arr.length;
        int count = 0;

        for (int i = 0 ; i < n ; i ++){
            int xor = 0;
            for (int j = i ; j < n ; j ++){
                xor ^= arr[j];
                if (xor == k){
                    count ++;
                }
            }
        }
        return count;
    }
//    Time Complexity : O(n²)
//    Space Complexity : O(1)

//    Optimal Approach :
    static int countSubarrayOptimal(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int xor = 0;
        int count = 0;

        map.put(0,1);            // IMPORTANT

        for (int num : arr){
            xor ^= num;
            if (map.containsKey(xor ^ k)){
                count += map.get(xor ^ k);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
//    Time Complexity : O(n)
//    Space Complexity : O(n)
}
