import java.util.ArrayList;
import java.util.Arrays;

// LeetCode Problem : 88. Merge Sorted Array
// Link : https://leetcode.com/problems/merge-sorted-array

// GFF Problem : Merge Without Extra Space
// Link : https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

public class MergeTwoSortedArrWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int m = arr1.length;
//        int m= 3;              // For LeetCode Problem
        int[] arr2 = {2,5,6};
        int n = arr2.length;

//        mergeTwoArrayBrute(arr1, m, arr2, n);
//        System.out.println("Brute Force Approach :");

//        mergeTwoArrayBetter(arr1,m,arr2,n);
//        System.out.println("\nBetter Approach :");

//        mergeTwoArrayOptimal(arr1,m,arr2,n);
//        System.out.println("\nOptimal Approach :");

//        leetCodeSol(arr1,m,arr2,n);
//        System.out.println("\nLeetCode Solution : ");

        System.out.print("Array 1 : ");
        for (int x : arr1) {
            System.out.print(x + " ");
        }
        System.out.print("\nArray 2 : ");
        for (int x : arr2) {
            System.out.print(x + " ");
        }
    }

//    Brute Force Approach : { Use Extra Array}  --> Violates the constraints
//    Here, m is the length of arr1
//    And, n is the length of arr2
    static void mergeTwoArrayBrute(int[] arr1, int m , int[] arr2, int n){
        // Extra Array :
        int[] temp = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n){
            if(arr1[i] <= arr2[j]){
                temp[k ++] = arr1[i ++];
            }
            else{
                temp[k ++] = arr2[j ++];
            }
        }
        while (i < m){
            temp[k ++] = arr1[i ++];
        }
        while (j < n){
            temp[k ++] = arr2[j ++];
        }
//        Copy back :
        for (int x = 0; x < m; x ++){
            arr1[x] = temp[x];
        }
        for (int x = m; x < m + n; x ++){
            arr2[x - m] = temp[x];
        }
    }
//    Time Complexity : O(m + n) + O(m + n)
//    Space Complexity : O(m + n)  {Extra Array}

//    Better Approach : Two Pointer + Sorting
    static void mergeTwoArrayBetter(int[] arr1, int m , int[] arr2, int n){
        int left = m - 1;
        int right =  0;

        while (left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
//                Swap
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;

                left --;
                right ++;
            }
            else{
                break;
            }
        }
//        Sort both the array separately
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
//    Time Complexity : O(min(m,n)) + O(m log m + n log n)
//    Space Complexity : O(1)

//    Optimal Approach : Gap Method (Shell Short)
    static void mergeTwoArrayOptimal(int[] arr1, int m, int[] arr2, int n){
        int len = m + n;
        int gap = (len / 2) + (len % 2);

        while (gap > 0 ){
            int left = 0;
            int right = left + gap;

            while (right < len){
//                Case 1 : arr1 vs arr1
                if (left < m && right < m){
                    if (arr1[left] > arr1[right]){
//                        Swap(arr1[left] and arr1[right])
                        int temp = arr1[left];
                        arr1[left] = arr1[right];
                        arr1[right] = temp;
                    }
                }
//                Case 2 : arr1 vs arr2
                else if(left < m && right >= m){
                    if (arr1[left] > arr2[right - m]){
//                        Swap(arr1[left] and arr2[right - m])
                        int temp = arr1[left];
                        arr1[left] = arr2[right - m];
                        arr2[right - m] = temp;
                    }
                }
//                Case 3 : arr2 vs arr2
                else{
                    if(arr2[left - m] > arr2[right - m]){
//                        Swap(arr2[left - m] and arr2[right - m])
                        int temp = arr2[left - m];
                        arr2[left - m] = arr2[right - m];
                        arr2[right - m] = temp;
                    }
                }
                left ++;
                right ++;
            }

            if(gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }
    }
//    Time Complexity : O((m+n) log(m+n))
//    Space Complexity : O(1)

//    LeetCode Solution : 88. Merge Sorted Array
//  Short Explanation : “Since nums1 has extra space at the end, We have used here three pointers and fill it from
//  the back by always placing the larger element between nums1 and nums2, avoiding overwriting and achieving O(1)
//  space.”
    static void leetCodeSol(int[] arr1, int m , int[] arr2, int n){

        int i = m - 1;       // Last element of arr1
        int j = n - 1;       // Last element of arr2
        int k = m + n - 1;   // last position of arr1

//        Fill arr1 from back
        while (i >= 0 && j >= 0){
            if(arr1[i] > arr2[j]){
                arr1[k] = arr1[i];
                i --;
            }
            else{
                arr1[k] = arr2[j];
                j --;
            }
            k --;
        }
//        Copy remaining elements of arr2(If any)
        while (j >= 0){
            arr1[k] = arr2[j];
            j --;
            k --;
        }
    }
//    Time Complexity : O(m + n)
//    Space Complexity : O(1)

}

