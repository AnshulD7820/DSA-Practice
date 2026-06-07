//  GFG Problem : Floor : Floor in a Sorted Array
//  Link : https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

//  GFG Problem : Ceil : Ceil in a Sorted Array
//  Link : https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1

public class Floor_Ceil_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        int x = 5;

        System.out.println("Brute Force Approach : Floor = " + floorBrute(arr,x));
        System.out.println("Brute Force Approach : Ceil = " + ceilBrute(arr,x));

        System.out.println("Optimal Approach : Floor = " + floorOptimal(arr,x));
        System.out.println("Optimal Approach : Ceil = " + ceilOptimal(arr,x));
    }

//    Brute Force Approach :
//    Floor :
    public static int floorBrute(int[] arr, int x){
        int ans = -1;
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] <= x){
                ans = arr[i];
            }
        }
        return ans;
    }

//    Ceil:
    public static int ceilBrute(int[] arr, int x){
        for (int i = 0 ; i < arr.length ; i ++){
            if(arr[i] >= x){
                return arr[i];
            }
        }
        return -1;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    Optimal Approach :
//    Floor :
    public static int floorOptimal(int[] arr, int x){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while(low <= high){
           int mid = low + (high - low ) / 2;

           if(arr[mid] <= x){
               ans = arr[mid];
               low = mid + 1;
           }else {
               high = mid - 1;
           }
        }
        return ans;
    }

//    Ceil :
    public static int ceilOptimal(int[] arr, int x){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] >= x){
                ans = arr[mid];
                high = mid - 1 ;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

//    Time Complexity : O(log n)
//    Space Complexity : O(1)

//    Ceil is exactly same to what we have done in lower bound. (Same logic and code)
}
