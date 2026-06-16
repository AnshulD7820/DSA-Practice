//  GFG Problem : Peak element
//  Link : https://www.geeksforgeeks.org/problems/peak-element/1

//  LeetCode Problem : 162. Find Peak Element
//  Link : https://leetcode.com/problems/find-peak-element

//  LeetCode Problem : 852. Peak Index in a Mountain Array
//  Link : https://leetcode.com/problems/peak-index-in-a-mountain-array


// LeetCode 852 (Peak Index in a Mountain Array) is very similar to LeetCode 162 (Find Peak Element).
//
// In LeetCode 852, the array is guaranteed to be a mountain array, meaning there is exactly one peak element.
//
// Therefore, the binary search approach used in LeetCode 162 also works here.
//
// In LeetCode 162, we additionally check whether the first or last element is a peak because a peak can exist
// anywhere in the array.
//
// However, in LeetCode 852, those boundary checks are unnecessary because
// the problem guarantees that the peak cannot be at index 0 or index n-1.


public class Peak_Element_In_Array {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};

        System.out.println("Optimal Approach : " + peakElementOptimal(arr));

        System.out.println("LeetCode Problem 852 : " + peakElementLeetCode(arr));
    }

//    Optimal Approach :
    public static int peakElementOptimal(int[] arr){
        int n = arr.length;
//        If array contains only one element
        if(n == 1){
            return 0;
        }
//        If first element is peak element
        if(arr[0] > arr[1]){
            return 0;
        }
//        If last element is peak element
        if(arr[n - 1] > arr[n - 2]){
            return n - 1;
        }
//        Start from second index (arr[1]) and go till last second index (arr[n-2]) because we have manually checked
//        the first and last element whether they are peak element or not
        int low = 1;
        int high = n - 2;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            // Increasing slope -> peak lies on the right
            else if(arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }
            // Decreasing slope -> peak lies on the left
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

//    Time Complexity : O(log N)
//    Space Complexity : O(1)

//    LeetCode Problem 852 Solution :
    public static int peakElementLeetCode(int[] arr){
        int n = arr.length;
        int low = 1;
        int high = n - 2;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            // Increasing slope -> peak lies on the right
            else if(arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }
            // Decreasing slope -> peak lies on the left
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
