//  GFG Problem : Find Kth Rotation
//  Link : https://www.geeksforgeeks.org/problems/rotation4723/1

public class How_Many_Times_Array_Rotated {
    public static void main(String[] args) {
        int[] arr= {5, 1, 2, 3, 4};

        System.out.println(findKthRotation(arr));
    }

//      This problem is actually a direct extension of : Find Minimum in Rotated Sorted Array
//      Because: Number of rotations = Index of the minimum element

//    Optimal Approach :
    public static int findKthRotation(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high){
//            Entire range sorted
            if(arr[low] <= arr[high]){
                if(arr[low] < ans){
                    ans = arr[low];
                    index = low;
                }
                break;
            }

            int mid = low + (high - low) / 2;
//            Left half sorted
            if(arr[low] <= arr[mid]){
               if(arr[low] < ans){
                   ans = arr[low];
                   index = low;
               }
               low = mid + 1;
            }
//            Right half sorted (Right half will contain minimum i.e. ans)
            else{
                if(arr[mid] < ans){
                    ans = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }

//    Time Complexity : O(log N)
//    Space Complexity : O(1)
}
