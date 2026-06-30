//  GFG Problem : K-th element of two Arrays
//  Link : https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

//  NOTE : This is actually the sibling of Median of Two Sorted Arrays

public class Kth_Element_Of_Two_Sorted_Array {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;

        System.out.println("Brute Force Approach : " + kthElementBrute(arr1, arr2, k));
        System.out.println("Optimal Approach : " + kthElementOptimal(arr1, arr2, k));
    }

//    Brute Force Approach :
    public static int kthElementBrute(int[] arr1, int[] arr2, int k){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] merge = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
                merge[index ++] = arr1[i ++];
            }
            else{
                merge[index ++] = arr2[j ++];
            }
        }
        while (i < n1){
            merge[index ++] = arr1[i ++];
        }
        while (j < n2){
            merge[index ++] = arr2[j ++];
        }
        return merge[k - 1];
    }
//    Time Complexity : O(n + m)
//    Space Complexity : O(n + m)

//    Optimal Approach :
    public static int kthElementOptimal(int[] arr1, int[] arr2, int k){
        int n1 = arr1.length;
        int n2 = arr2.length;

        if(n1 > n2){
            return kthElementOptimal(arr2, arr1, k);
        }

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high){
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

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
                return Integer.max(l1, l2);
            }
            else if(l1 > r2){
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
        }
        return -1;
    }

//    Time Complexity : O(log(min(n1,n2)))
//                          Suppose : n = size of smaller array

//    Space Complexity : O(1)
}
