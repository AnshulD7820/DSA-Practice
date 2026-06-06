//  GFG Problem : Implement Upper Bound
//  Link : https://www.geeksforgeeks.org/problems/implement-upper-bound/1

public class Upper_Bound {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 11;

        System.out.println("Brute Force Approach : " + UP_Brute(arr, target));
        System.out.println("Optimal Approach : " + UP_Optimal(arr, target));
    }

//    Brute Force Approach :
    public static int UP_Brute(int[] arr, int target){
        for (int i = 0 ; i < arr.length; i ++){
            if(arr[i] > target){
                return i;
            }
        }
        return arr.length;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    Optimal Approach :
    public static int UP_Optimal(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > target){
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
