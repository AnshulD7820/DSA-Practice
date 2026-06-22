//  GFG Problem : Smallest Divisor
//  Link : https://www.geeksforgeeks.org/problems/smallest-divisor/1

//  LeetCode Problem : 1283. Find the Smallest Divisor Given a Threshold
//  Link : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold

public class Smallest_Divisor_Given_Threshold {
    public static void main(String[] args) {
        int[] arr = {44,22,33,11,1};
        int threshold = 5;

        System.out.println("Brute Force Approach : " + smallestDivisorBrute(arr, threshold));
        System.out.println("Optimal Approach : " + smallestDivisorOptimal(arr, threshold));
    }

//    NOTE : THIS PROBLEM IS ALMOST A CLONE OF KOKO EATING BANANAS.

//    Brute Force Approach :
    public static int smallestDivisorBrute(int[] arr, int threshold){
        int n = arr.length;

        int max = Integer.MIN_VALUE;

        for (int num : arr){
            max = Math.max(max, num);
        }

        for(int d = 1; d <= max ; d ++){
            int sum = 0;
            for (int i = 0; i < n ; i ++){
                sum += (int)Math.ceil((double) arr[i] / d);
            }

            if(sum <= threshold){
                return d;
            }
        }
        return -1;
    }

//    Time Complexity : O(max(arr) × n)
//    Space Complexity : O(1)

    public static int smallestDivisorOptimal(int[] arr, int threshold){
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int num : arr){
            high = Math.max(high, num);
        }

        int ans = high;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int sum = findSum(arr, mid);

            if(sum <= threshold){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int findSum(int[] arr, int divisor){
        int sum = 0;

        for (int num : arr){
            sum += (int)Math.ceil((double) num / divisor);
        }
        return sum;
    }

//    Time Complexity : O(log(M) × n)
//                          Where : M = max(arr)
//                                  n = arr.length
//    Space Complexity : O(1)
}
