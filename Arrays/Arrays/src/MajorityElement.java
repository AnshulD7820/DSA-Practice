import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 2, 2, 1};

        System.out.println("Brute Force Approach : " + majorityElementBrute(arr));
        System.out.println("Better Approach : " + majorityElementBetter(arr));
        System.out.println("Optimal Approach : " + majorityElementOptimal(arr));

    }

    // Brute Force Approach:
    static int majorityElementBrute(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i])
                    count++;
                if (count > n / 2)
                    return arr[i];
            }
        }
        return -1;
    }

    // Time Complexity : O(N * N)
    // Space Complexity : O(1)

    // Better Approach: Use Hashmap
    static int majorityElementBetter(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;;
        for (int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > n / 2)
                return num;
        }
        return -1;
    }

    // Time Complexity : O(N)
    // Space Complexity : O(N)

    // Optimal Approach: Moore's Voting Algorithm
    static int majorityElementOptimal(int[] arr){
        int count = 0;
        int candidate = 0;
        for (int num : arr){
            if(count == 0)
                candidate = num;
            if (num == candidate)
                count ++;
            else
                count--;
        }
        return candidate;
    }
    // Time Complexity : O(N)
    // Space Complexity : O(1)

}
