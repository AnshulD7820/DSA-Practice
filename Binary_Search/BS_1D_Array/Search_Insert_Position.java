//  GFG Problem : Sorted Insert Position
//  Link : https://www.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1

// LeetCode Problem : 35. Search Insert Position
// Link : https://leetcode.com/problems/search-insert-position

public class Search_Insert_Position {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 2;

        System.out.println("Search insert position : " + SIP(arr,target));
    }

//    This problem is exact similar to what we have done in lower bound problem.
//    Approach :
    public static int SIP(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

//    Time Complexity : O(log n)
//    Space Complexity : O(1)
}
