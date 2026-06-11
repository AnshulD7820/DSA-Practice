//  GFG Problem : Sorted and Rotated Minimum
//  Link : https://www.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1

//  LeetCode Problem : 153. Find Minimum in Rotated Sorted Array
//  Link : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

public class Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] arr ={3,4,5,1,2};

        System.out.println("Brute Force Approach : " + minimumBrute(arr));
        System.out.println("Optimal Approach : " + minimumOptimal(arr));

    }

//    Brute Force Approach :
    public static int minimumBrute(int[] arr){
        int ans = arr[0];

        for (int num : arr){
            ans = Math.min(ans, num);
        }
        return ans;
    }

//    Time Complexity : O(N)
//    Space Complexity : O(1)

//    Optimal Approach :
    public static int minimumOptimal(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high){
//            Entire range sorted
            if(arr[low] <= arr[high]){
                ans = Math.min(ans, arr[low]);
                break;
            }

            int mid = low + (high - low) / 2;

//            Left half sorted
            if(arr[low] <= arr[mid]){
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }
//            Right half sorted
            else{
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

//    Time Complexity : O(log N)
//    Space Complexity : O(1)
}
