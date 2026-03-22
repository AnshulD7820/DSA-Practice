import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1 ,2, 3, 5};

        System.out.println("Brute Force Approach : " + missingBrute(arr));
        System.out.println("Better Approach : " + missingBetter(arr));
        System.out.println("Optimal Approach Using Sum : " + missingOptimalSum(arr));
        System.out.println("Optimal Approach Using XOR : " + missingOptimalXOR(arr));
    }

    // Brute Force Approach:
    // Time Complexity: O(N * N)
    // Space Complexity: O(1)
    static int missingBrute(int[] arr){
        int n = arr.length + 1;
        for (int i = 1; i <= n; i++){
            boolean found = false;
            for (int j = 0; j < n - 1;j++){
                if(arr[j] == i){
                    found = true;
                    break;
                }
            }
            if(!found)
                return i;
        }
        return  -1;
    }


    // Better Approach:
    //Time Complexity: O(N)
    // Space Complexity: O(N)
    static int missingBetter(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n-1;i++){
            if(arr[i] != i){
                return i;
            }
        }
        return n;

    }



    // Optimal Approach: 1. Sum
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    static int missingOptimalSum(int[] arr){
        long n = arr.length + 1;

        long total = n * (n + 1) / 2;
        long sum = 0;

        for (int j : arr) {
            sum += j;
        }
        return (int) (total - sum);
    }


    // Optimal Approach: 1. XOR
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    static int missingOptimalXOR(int[] arr){
//        int n = arr.length + 1;
//       int xor1 = 0;
//       int xor2 = 0;
//       for (int i = 0;i<n-1;i++){
//           xor2 ^= arr[i];
//           xor1 ^= i + 1;
//       }
//       return xor1 ^ xor2;

        int xor = 0;
        for (int i = 1; i <= arr.length + 1;i++){
            xor ^= i;
        }
        for (int num : arr){
            xor ^= num;
        }
        return xor;
    }
}
//Teach me Missing Number Problem from array using Brute , better and optimal approach, teach me in easy language