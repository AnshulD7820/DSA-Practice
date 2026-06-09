//  GFG Problem : Search in Rotated Sorted Array
//  Link : https://www.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1

//  LeetCode Problem : 33. Search in Rotated Sorted Array
//  Link : https://leetcode.com/problems/search-in-rotated-sorted-array

public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] arr ={4,5,6,7,0,1,2};
        int target = 0;

        System.out.println("Brute Force Approach : " + searchRotatedBrute(arr,target));
        System.out.println("Optimal Approach : " + searchRotatedOptimal(arr,target));
    }

//    NOTE : Whenever you see search or sorted, you should directly think about Binary Search

//    Brute Force Approach :
    public static int searchRotatedBrute(int[] arr, int target){
        for (int i = 0 ; i < arr.length ; i ++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    Optimal Approach : Binary Search
    public static int searchRotatedOptimal(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] == target){
                return mid;
            }
//            Left half sorted
            if(arr[low] <= arr[mid]){
                if(target >= arr[low] && target < arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
//            Right half sorted
            else{
                if(target > arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

//    Time Complexity : O(log n)
//    Space Complexity : O(1)
}
