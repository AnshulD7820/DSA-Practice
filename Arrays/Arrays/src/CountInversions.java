
//  GFG Problem : Count Inversions
//  Link : https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        System.out.println("Brute Force Approach : " + countInversionBrute(arr));

        long[] arr1 = {5,3,2,4,1};
        System.out.println("Optimal Approach : " + countInversionOptimal(arr1));
    }

//    Brute Force Approach :
    static int countInversionBrute(int[] arr){
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i ++){
            for (int j = i + 1; j < n; j ++){
                if (arr[i] > arr[j])
                    count ++;
            }
        }
        return count;
    }
//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    Optimal Approach : { Merge Sort }
    static long countInversionOptimal(long[] arr1){
        return mergeSort(arr1, 0, arr1.length - 1);
    }
    static long mergeSort(long[] arr1, int low, int high){
        long count = 0;
        if (low >= high)
            return 0;
        int mid = (low + high) / 2;
        count += mergeSort(arr1, low, mid);
        count += mergeSort(arr1,mid +1, high);
        count += merge(arr1, low, mid, high);
        return count;
    }
    static long merge(long[] arr1, int low, int mid, int high){
        long[] temp = new long[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        long count = 0;

        while (left <= mid && right <= high){
            if (arr1[left] <= arr1[right]){
                temp[k ++] = arr1[left ++];
            }
            else{
                temp[k ++] = arr1[right ++];
                count += (mid - left + 1);      // All remaining left > arr[right]
            }
        }
        while (left <= mid){
            temp[k ++] = arr1[left ++];
        }
        while (right <= high){
            temp[k ++] = arr1[right ++];
        }
        for (int i = low ; i <= high ; i ++){
            arr1[i] = temp[i - low];
        }
        return count;
    }
//    Time Complexity : O(n log n)  --> Merge Sort
//    Space Complexity : O(n)  --> Temp array in merge
}
