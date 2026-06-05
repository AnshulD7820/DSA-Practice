//  GFG Problem : Binary Search
//  Link : https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1

//  LeetCode Problem : 704. Binary Search
//  Link : https://leetcode.com/problems/binary-search

public class Binary_Search_Basics {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        int target = 9;

        System.out.println("Brute Force Approach : " + BS_Brute(arr,target));
        System.out.println("Optimal (Binary Search) Approach : " + BS_Optimal(arr,target));
    }

//    Brute Force Approach:
    public static int BS_Brute(int[] arr, int target){
        int n = arr.length;
        for (int i = 0 ; i < n ; i ++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    Optimal Approach : Binary Search
    public static int BS_Optimal(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low ) / 2;

            if(arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
//    Time Complexity : O(log n)
//    Space Complexity : O(1)
}