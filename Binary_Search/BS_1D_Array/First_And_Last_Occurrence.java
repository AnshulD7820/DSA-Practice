//   GFG Problem : First and Last in Sorted
//  Link : https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1

//  LeetCode Problem : 34. Find First and Last Position of Element in Sorted Array
//  Link : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

import java.util.ArrayList;
public class First_And_Last_Occurrence {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,8,8,11,13};
        int target = 8;

        System.out.println("Brute Force Approach : First Occurrence = " + FirstOccBrute(arr,target));
        System.out.println("Brute Force Approach : Last Occurrence = " + LastOccBrute(arr,target));

        System.out.println("Optimal Approach : First Occurrence = " + FirstOccOptimal(arr, target));
        System.out.println("Optimal Approach : Last Occurrence = " + LastOccOptimal(arr, target));

    }

//    Brute Force Approach :
//    First Occurrence: Traverse from left
    public static int FirstOccBrute(int[] arr, int target){
        for (int i = 0; i < arr.length ; i ++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

//    Last Occurrence : Traverse From right
    public static int LastOccBrute(int[] arr, int target){
        for (int i = arr.length - 1; i >= 0 ; i --){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

//    Time Complexity : O(n)
//    Time Complexity : O(1)

//    Optimal Approach : Binary Search
//    First Occurrence :
    public static int FirstOccOptimal(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1 ;

        while (low <= high){
            int mid  = low + (high - low) / 2;

            if(arr[mid] == target){
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

//    Last Occurrence :
    public static int LastOccOptimal(int[] arr, int target){
        int low  = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] == target){
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

//    Time Complexity : O(log n)
//    Time Complexity : O(1)

}
