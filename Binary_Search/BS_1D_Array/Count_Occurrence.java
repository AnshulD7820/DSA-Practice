//  GFG Problem : Number of occurrence
//  Link : https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

public class Count_Occurrence {
    public static void main(String[] args) {
        int[] arr = {8, 9, 10, 12, 12, 12};
        int target = 12;

        System.out.println("Occurrence : " + countOccurrence(arr,target));
    }

//    Approach :
//    Formula / Concept => UpperBound - LowerBound

//    LowerBound :-
    public static int lowerBound(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while(low <= high){
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

//    UpperBound :-
    public static int upperBound(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while(low <= high){
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

    public static int countOccurrence(int[] arr, int target){
        int lb = lowerBound(arr, target);
        if(lb == arr.length || arr[lb] != target){
            return 0;
        }
        int ub = upperBound(arr, target);

        return ub - lb;
    }
}
