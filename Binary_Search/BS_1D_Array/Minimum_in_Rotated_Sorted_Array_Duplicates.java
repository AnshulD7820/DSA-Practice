//  LeetCode Problem : 154. Find Minimum in Rotated Sorted Array II
//  Link : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

public class Minimum_in_Rotated_Sorted_Array_Duplicates {
    public static void main(String[] args) {
        int[] arr = {2,2,2,0,1};

        System.out.println("Minimum : " + minimumWithDuplicates(arr));
    }

//    Approach :
    public static int minimumWithDuplicates(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high){

            int mid = low + (high - low) / 2;
//          Ambiguous Case :
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                ans = Math.min(ans, arr[low]);
                low ++;
                high --;
                continue;
            }
//          Left half sorted
            if(arr[low] <= arr[mid]){
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }
//          Right half sorted
            else{
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
//        Time Complexity :-
//                          Average Case = O(log N)   |   Worst Case = O(N)
//    Space Complexity : O(1)

//    Why is the complexity not always O(log N)?
//    Because duplicates can make it impossible to determine the sorted half, forcing us to shrink the search space
//    one element at a time.
}
