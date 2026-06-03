//  GFG Problem : Count Reverse Pairs
//  Link : https://www.geeksforgeeks.org/problems/count-reverse-pairs/1

//  LeetCode Problem : 493. Reverse Pairs
//  Link : https://leetcode.com/problems/reverse-pairs/submissions/2021519582/

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 1, 20};
        System.out.println("Brute Force Approach : " + ReversePairBrute(arr));
        System.out.println("Optimal Approach : " + ReversePairsOptimal(arr));
    }

//    Brute Force Approach :
    static int ReversePairBrute(int[] arr){
        int n = arr.length;

        int count = 0;

            for (int i = 0 ; i < n ; i ++){
                for (int j = i + 1 ; j < n; j ++){
                    if(arr[i] > 2L * arr[j]){
                        count ++;
                    }
                }
            }
        return count;
    }

//    Time Complexity : O(N²)
//    Space Complexity : O(1)

//    Optimal Approach : {Merge Sort}

    static int ReversePairsOptimal(int[] arr){
        return mergeSort(arr, 0 , arr.length - 1);
    }

    static int mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return 0;
        }
        int mid = (low + high ) / 2;
        int count = 0;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        count += countPairs(arr, low, mid, high);

        merge(arr, low, mid, high);

        return count;
    }

    static int countPairs(int[] arr, int low, int mid, int high){
        int count = 0;
        int right = mid + 1;

        for (int i = low ; i <= mid ; i ++){
            while (right <= high && arr[i] > 2L * arr[right]){
                right++;
            }
            count += right - (mid + 1);
        }

        return count;
    }

    static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid){
            temp[k ++] = arr[left ++];
        }

        while (right <= high){
            temp[k ++] = arr[right ++];
        }

        for (int i = low ; i <= high ; i ++){
            arr[i] = temp[i - low];
        }
    }

//    Time Complexity : O(N log N)
//    Space Complexity : O(N)

}
