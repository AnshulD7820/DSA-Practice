//  GFG Problem : Median of 2 Sorted Arrays of Different Sizes
//  Link : https://www.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1

//  LeetCode Problem : 4. Median of Two Sorted Arrays
//  Link : https://leetcode.com/problems/median-of-two-sorted-arrays

public class Median_Of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};

        System.out.println("Brute Force Approach : " + medianOfTwoSortedArrayBrute(arr1, arr2));
        System.out.println("Optimal Approach : " + medianOfTwoSortedArrayOptimal(arr1, arr2));
    }

//    Brute Force Approach :
    public static double medianOfTwoSortedArrayBrute(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] merge = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                merge[k ++] = arr1[i ++];
            }
            else {
                merge[k ++] = arr2[j ++];
            }
        }

        while (i < n1){
            merge[k ++] = arr1[i ++];
        }

        while (j < n2){
            merge[k ++] = arr2[j ++];
        }

        int n = n1 + n2;

        if(n % 2 == 1){
            return merge[n / 2];
        }
        else{
            return (merge[n / 2] + merge[n / 2 - 1]) / 2.0;
        }
    }

//    Time Complexity : O(n + m)
//    Space Complexity : O(n + m)

//    Optimal Approach :
    public static double medianOfTwoSortedArrayOptimal(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        if(n1 > n2){
            return medianOfTwoSortedArrayOptimal(arr2, arr1);
        }

        int low = 0;
        int high = n1;

        int left = (n1 + n2 + 1) / 2;

        int n = n1 + n2;

        while (low <= high){
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1){
                r1 = arr1[mid1];
            }
            if(mid2 < n2){
                r2 = arr2[mid2];
            }

            if(mid1 - 1 >= 0){
                l1 = arr1[mid1 - 1];
            }
            if(mid2 - 1 >= 0){
                l2 = arr2[mid2 - 1];
            }

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1){
                    return Integer.max(l1, l2);
                }
                else{
                    return (Integer.max(l1, l2) + Integer.min(r1, r2)) / 2.0;
                }
            }
            else if(l1 > r2){
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
        }
        return 0;
    }

//    Time Complexity : O(log(min(n1,n2)))
//                          Suppose : n = size of smaller array

//    Space Complexity : O(1)
}
