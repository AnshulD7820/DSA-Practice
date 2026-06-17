//  GFG Problem : Square Root
//  Link : https://www.geeksforgeeks.org/problems/square-root/1

//  LeetCode Problem : 69. Sqrt(x)
//  Link : https://leetcode.com/problems/sqrtx/description/

public class Square_Root_Of_Number {
    public static void main(String[] args) {
        int n = 28;

        System.out.println("Brute Force Approach : " + squareRootBrute(n));
        System.out.println("Optimal Approach : " + squareRootOptimal(n));
    }

//    Brute Force Approach :
    public static int squareRootBrute(int n){
        int ans = 0;

        for (int i = 1; i <= n; i ++){
            if((long) i * i <= n){
                ans = i;
            }
            else{
                break;
            }
        }
        return ans;
    }

//    Time Complexity : O(√N)
//    Space Complexity : O(1)

//    Optimal Approach : Binary Search
    public static int squareRootOptimal(int n){
        int low = 1;
        int high = n;

        int ans = 0;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if((long) mid * mid <= n){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

//    Time Complexity : O(log N)
//    Space Complexity : O(1)
}
