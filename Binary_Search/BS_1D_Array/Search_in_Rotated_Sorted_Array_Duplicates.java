//  GFG Problem : Search in Rotated Array 2
//  Link : https://www.geeksforgeeks.org/problems/search-in-rotated-array-2/1

//  LeetCode Problem : 81. Search in Rotated Sorted Array II
//  Link : https://leetcode.com/problems/search-in-rotated-sorted-array-ii

public class Search_in_Rotated_Sorted_Array_Duplicates {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target = 0;

        System.out.println(search(arr,target));
    }

//    Approach : Binary Search
    public static boolean search(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] == target){
                return true;
            }
//            Handle ambiguity:
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low ++;
                high --;
                continue;
            }
//            Apply normal rotated sorted array logic :
//            left half sorted
            if(arr[low] <= arr[mid]){
                if(target >= arr[low] && target < arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
//            right half sorted
            else{
                if(target > arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }

//    Time Complexity :-
//                          Average Case = O(log N)   |   Worst Case = O(N)
//    Space Complexity : O(1)

//    Why is the complexity not always O(log N)?
//    Because duplicates can make it impossible to determine the sorted half, forcing us to shrink the search space
//    one element at a time.
}
