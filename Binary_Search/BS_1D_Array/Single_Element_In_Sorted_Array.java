//  GFG Problem : Single Among Doubles in a Sorted
//  Link : https://www.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1

//  LeetCode Problem : 540. Single Element in a Sorted Array
//  Link : https://leetcode.com/problems/single-element-in-a-sorted-array


public class Single_Element_In_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4,5,5};

        System.out.println("Brute Force Approach : " + singleElementBrute(arr));
        System.out.println("Optimal Approach : " + singleElementOptimal(arr));
    }

//    Brute Force Approach : xor approach
    public static int singleElementBrute(int[] arr){
        int xor = 0;
        for (int num : arr){
            xor ^= num;
        }
        return xor;
    }

//    Time Complexity : O(N)
//    Space Complexity : O(1)

//    Optimal Approach : use the even/odd pattern
    public static int singleElementOptimal(int[] arr){
        int n = arr.length;

//        If array contains only one element
        if(n == 1){
            return arr[0];
        }
//        If first element is unique in an array
        if(arr[0] != arr[1]){
            return arr[0];
        }
//        If last element is unique in an array
        if(arr[n-1] != arr[n-2]){
            return arr[n-1];
        }
//        Start from second index (arr[1]) and go till last second index (arr[n-2])
        int low = 1;
        int high = n - 2;

        while (low <= high){
            int mid = low + (high - low) / 2;
//            Found answer
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]){
                return arr[mid];
            }
//            We are on the left side
            if((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && arr[mid] == arr[mid - 1])){
                low = mid + 1;
            }
//            We are on the right side
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

//    Time Complexity : O(log N)
//    Space Complexity : O(1)
}
