//  GFG Problem : Maximum Product Subarray
//  Link :  https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1

//  LeetCode Problem : 152. Maximum Product Subarray
//  Link : https://leetcode.com/problems/maximum-product-subarray/description/

public class Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,0};

        System.out.println("Brute Force Approach : " + MaxProSubarrayBrute(arr));
        System.out.println("Optimal Approach : " + MaxProSubarrayOptimal(arr));

    }

//    Brute Force Approach :
    static int MaxProSubarrayBrute(int[] arr){
        int n = arr.length;
        int maxProduct = Integer.MIN_VALUE;
        int curProduct = 1;
        for (int i = 0 ; i < n ; i ++){
            for (int j = i ; j < n ; j ++){
                curProduct *= arr[j];
                maxProduct = Math.max(curProduct, maxProduct);
            }
        }
        return maxProduct;
    }

//    Time Complexity : O(N²)
//    Space Complexity : O(1)

//    Optimal Approach :
    static int MaxProSubarrayOptimal(int[] arr){
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n ; i ++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }

            prefix *= arr[i];
            suffix *= arr[n - i - 1];

            ans = Math.max(ans, Math.max(prefix,suffix));
        }
        return ans;
    }

//    Time Complexity : O(N)
//    Space Complexity : O(1)
}
